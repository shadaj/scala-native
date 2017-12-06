package java.lang

object ThreadLocalSuite extends tests.MultiThreadSuite {
  test("Each thread should have their own copies") {
    val localString = new ThreadLocal[String]
    Console.out.println("main:" + localString.get())
    assertEquals(localString.get(), null)
    localString.set("banana")
    Console.out.println("main:" + localString.get())
    assertEquals(localString.get(), "banana")

    class ThreadLocalTester(str: String) extends Thread {
      override def run() = {
        Console.out.println(str + "-tread:" + localString.get())
        assertEquals(localString.get(), null)
        localString.set(str)
        Console.out.println(str + "-tread:" + localString.get())
        assertEquals(localString.get(), str)
        localString.remove()
        Console.out.println(str + "-tread:" + localString.get())
        assertEquals(localString.get(), null)
        localString.set(str)
        Console.out.println(str + "-tread:" + localString.get())
        assertEquals(localString.get(), str)
      }
    }
    val appleThread  = new ThreadLocalTester("apple")
    val orangeThread = new ThreadLocalTester("orange")

    appleThread.start()
    orangeThread.start()
    appleThread.join()
    orangeThread.join()

    Console.out.println("main:" + localString.get())
    assertEquals(localString.get(), "banana")
    localString.remove()
    assertEquals(localString.get(), null)
  }
  test("Initial values") {
    val localString = new ThreadLocal[String] {
      override protected def initialValue = "<empty>"
    }
    assertEquals(localString.get(), "<empty>")
    localString.set("banana")

    class ThreadLocalTester(str: String) extends Thread {
      override def run() = {
        assertEquals(localString.get(), "<empty>")
        localString.set(str)
        assertEquals(localString.get(), str)
        localString.remove()
        assertEquals(localString.get(), "<empty>")
        localString.set(str)
        assertEquals(localString.get(), str)
      }
    }
    val appleThread  = new ThreadLocalTester("apple")
    val orangeThread = new ThreadLocalTester("orange")

    appleThread.start()
    orangeThread.start()
    appleThread.join()
    orangeThread.join()

    assertEquals(localString.get(), "banana")
    localString.remove()
    assertEquals(localString.get(), "<empty>")
  }
}
