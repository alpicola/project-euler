case class Vector(x:Int, y:Int) {
  def *(v:Vector) = x * v.x + y * v.y
  def -(v:Vector) = Vector(x - v.x, y - v.y)
}

val grid = for (x <- 0 to 50; y <- 0 to 50) yield Vector(x, y)

println((grid.toSet - Vector(0, 0)).subsets(2).count { s =>
  val List(p, q) = s.toList
  (p * q) * ((p - q) * p) * ((p - q) * q) == 0
})
