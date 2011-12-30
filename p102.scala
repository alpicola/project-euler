import scala.io.Source

val source = Source.fromFile("triangles.txt")

case class Vector(x:Int, y:Int) {
  def cross(v:Vector) = x * v.y - y * v.x
  def -(v:Vector) = Vector(x - v.x, y - v.y)
}

println(source.getLines.count { line =>
  val Array(a, b, c) = line.split(",").map(_.toInt).grouped(2).map {
    case Array(x, y) => Vector(x, y)
  }.toArray
  Array(a, b, c).zip(Array(a - b, b - c, c - a)).map {
    case (x, y) => (x cross y).signum
  }.sliding(2).forall(_.product >= 0)
})

source.close
