package scala.scalanative

import scalanative.native._

object NamedStructSuite extends tests.Suite {
  final case class Point(var x: Int, var y: Int) extends CStruct {
    def distanceTo(other: Point): Int = {
      println("from " + this)
      println("to " + other)
      Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2)).toInt
    }
  }

  final case class ScalaPoint(var x: Int, var y: Int)

  test("allocate with new") {
    val point = new Point(0, 0)
    assert(point.x == 0)
    assert(point.y == 0)
    point.x = 10
    assert(point.x == 10)
    assert(point.y == 0)
    point.y = 20
    assert(point.x == 10)
    assert(point.y == 20)
  }

  test("allocate with stackalloc") {
    val point = !stackalloc[Point]
    assert(point.x == 0)
    assert(point.y == 0)
    point.x = 10
    assert(point.x == 10)
    assert(point.y == 0)
    point.y = 20
    assert(point.x == 10)
    assert(point.y == 20)
  }

  test("call equals") {
    val p1 = new Point(10, 20)
    val p2 = new Point(10, 20)
    assert(p1 == p2)
    assert(p1.equals(p2))
  }

  test("call to string") {
    val p = new Point(10, 20)
    assert(p.toString == "Point(10,20)")
  }

  test("call hash code") {
    val p1 = new Point(10, 20)
    val p2 = new ScalaPoint(10, 20)
    assert(p1.hashCode == p2.hashCode)
  }

  test("call custom method") {
    val p1 = new Point(0, 0)
    val p2 = new Point(3, 4)
    assert(p1.distanceTo(p2) == 5)
  }
}
