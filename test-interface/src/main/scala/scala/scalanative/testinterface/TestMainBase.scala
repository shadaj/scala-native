package scala.scalanative
package testinterface

import java.io.{
  ByteArrayInputStream,
  ByteArrayOutputStream,
  DataInputStream,
  DataOutputStream
}
import java.net.Socket

import scala.scalanative.native._
import scala.scalanative.runtime.ByteArray
import sbt.testing.{Event => SbtEvent, _}

import scala.scalanative.testinterface.serialization._
import scala.annotation.tailrec

abstract class TestMainBase {

  /** All the frameworks reported in `loadedTestFrameworks` in sbt. */
  def frameworks: Seq[Framework]

  /** A mapping from class name to instantiated test object. */
  def tests: Map[String, AnyRef]
  
  val singleTestLogger = new Logger {
    def debug(msg: String): Unit = Console.err.println("DEBUG: " + msg)

    def error(msg: String): Unit = Console.err.println("ERROR: " + msg)

    val ansiCodesSupported = true

    def warn(msg: String): Unit = Console.err.println("WARN: " + msg)

    def trace(t: Throwable): Unit = {
      Console.err.println("TRACE:")
      t.printStackTrace()
    }

    def info(msg: String): Unit = Console.err.println("INFO: " + msg)
  }

  val singleTestEventHandler = new EventHandler {
    def handle(event: SbtEvent): Unit = {}
  }

  private def runSingleTest(value: String): Unit = {
    val runner = frameworks(0).runner(Array.empty,
                                      Array.empty,
                                      new PreloadedClassLoader(tests))
    val taskDef = new TaskDef(
      value,
      DeserializedSubclassFingerprint(isModule = true,
                                      "tests.Suite",
                                      requireNoArgConstructor = false),
      false,
      Array(new SuiteSelector))
    val Array(task: Task) = runner.tasks(Array(taskDef))
    task.execute(singleTestEventHandler, Array(singleTestLogger))
  }

  /** Actual main method of the test runner. */
  def testMain(args: Array[String]): Unit = {
    if (args.isEmpty) {
      tests.keys.foreach(runSingleTest)
    } else {
      println("launched with args " + args.toList)
      val serverPort   = args.head.toInt
      val clientSocket = new Socket("127.0.0.1", serverPort)
      testRunner(Array.empty, null, clientSocket)
    }
  }

  /** Test runner loop.
   *
   * @param tasks         The tasks known to the runner (executed and waiting)
   * @param runner        The actual underlying `Runner`
   * @param clientSocket  The client socket from which we receive and reply to commands
   */
  @tailrec
  private def testRunner(tasks: Array[Task],
                         runner: Runner,
                         clientSocket: Socket): Unit = {
    println("in runner")
    val stream = new DataInputStream(clientSocket.getInputStream)
    println("created stream")
    val rec = receive(stream)
    println(rec)
    rec match {
      case Command.NewRunner(id, args, remoteArgs) =>
        val runner = frameworks(id).runner(args.toArray,
                                           remoteArgs.toArray,
                                           new PreloadedClassLoader(tests))
        testRunner(tasks, runner, clientSocket)

      case Command.SendInfo(id, None) =>
        val fps  = frameworks(id).fingerprints()
        println(fps)
        val name = frameworks(id).name()
        println(name)
        val info = Command.SendInfo(id, Some(FrameworkInfo(name, fps.toSeq)))
        println(info)
        send(clientSocket)(info)
        testRunner(tasks, runner, clientSocket)

      case Command.Tasks(newTasks) =>
        val ts = runner.tasks(newTasks.toArray)
        val taskInfos = TaskInfos(ts.zipWithIndex.toSeq.map {
          case (t, id) => task2TaskInfo(id, t, runner)
        })
        send(clientSocket)(taskInfos)
        testRunner(tasks ++ ts, runner, clientSocket)

      case Command.Execute(taskID, colors) =>
        val handler = new RemoteEventHandler(clientSocket)
        val loggers =
          colors.map(new RemoteLogger(clientSocket, 0, _): Logger).toArray

        // Execute the task, possibly generating new tasks to execute...
        val newTasks = tasks
          .lift(taskID)
          .map(_.execute(handler, loggers))
          .getOrElse(Array.empty)
        val origSize = tasks.length

        // Convert the tasks to `TaskInfo` before sending to sbt. Keep task numbers correct.
        val taskInfos = newTasks.zipWithIndex.map {
          case (t, id) => task2TaskInfo(id + origSize, t, runner)
        }
        send(clientSocket)(TaskInfos(taskInfos))
        testRunner(tasks ++ newTasks, runner, clientSocket)

      case Command.RunnerDone(_) =>
        val r       = runner.done()
        val message = Command.RunnerDone(r)
        send(clientSocket)(message)

      case other =>
        println(s"Unexpected message: $other")
    }
  }

  private def task2TaskInfo(id: Int, task: Task, runner: Runner) =
    TaskInfo(id, task.taskDef, task.tags)

  /** Receives a message from `client`. */
  private def receive[T](dis: DataInputStream): Message = {
    val msglen = dis.readInt()
    val msgbuf = new Array[Byte](msglen)
    if (msglen > 0) {
      dis.readFully(msgbuf)
    }
    val deserializer = new SerializedInputStream(
      new ByteArrayInputStream(msgbuf))
    deserializer.readMessage()
  }

  /** Sends message `v` to `client`. */
  private def send[T](client: Socket)(msg: Message): Unit = {
    val bos = new ByteArrayOutputStream()
    SerializedOutputStream(new DataOutputStream(bos))(_.writeMessage(msg))
    val data = bos.toByteArray()

    val out = client.getOutputStream
    out.write(data)
    out.flush
  }

  private class RemoteEventHandler(client: Socket) extends EventHandler {
    override def handle(event: SbtEvent): Unit = {
      val ev = Event(event.fullyQualifiedName(),
                     event.fingerprint(),
                     event.selector(),
                     event.status(),
                     event.throwable(),
                     event.duration())
      send(client)(ev)
    }
  }

  private class RemoteLogger(client: Socket,
                             index: Int,
                             val ansiCodesSupported: Boolean)
      extends Logger {
    private def log(level: Log.Level,
                    msg: String,
                    twb: Option[Throwable]): Unit = {
      send(client)(Log(index, msg, twb, level))
    }

    override def error(msg: String): Unit  = log(Log.Level.Error, msg, None)
    override def warn(msg: String): Unit   = log(Log.Level.Warn, msg, None)
    override def info(msg: String): Unit   = log(Log.Level.Info, msg, None)
    override def debug(msg: String): Unit  = log(Log.Level.Debug, msg, None)
    override def trace(t: Throwable): Unit = log(Log.Level.Trace, "", Some(t))
  }
}
