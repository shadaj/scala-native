case class Foo(a: Int, b: Int, c: Int, d: Int, e: Int, f: Int, g: Int)

object Test {
  def main(args: Array[String]): Unit = {
    while (true) {
      println(new Foo(1, 2, 3, 4, 5, 6, 7))
    }
  }
}
