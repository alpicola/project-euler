case class Vector(x:Int, y:Int) {
  def *(p:Vector):Int = x * p.x + y * p.y
  def -(p:Vector) = Vector(x - p.x, y - p.y)
}

val grid = for (x <- 0 to 50; y <- 0 to 50) yield Vector(x, y)

println((grid.toSet - Vector(0, 0)).subsets(2).count { s =>
  val List(p, q) = s.toList
  (p * q) * ((p - q) * p) * ((p - q) * q) == 0
})
