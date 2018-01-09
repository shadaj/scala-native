enablePlugins(ScalaNativePlugin)

scalaVersion := "2.11.12"

lazy val runAndCheck = taskKey[Unit]("...")

runAndCheck := {
  import scala.sys.process._

  val bin = (nativeLink in Compile).value
  val out = Process(bin.getAbsolutePath).lines_!.toList
  assert(out == List("result: 10"))
}
