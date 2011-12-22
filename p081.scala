import scala.io.Source

val source = Source.fromFile("matrix.txt")
val matrix = source.getLines.map(_.split(",").map(_.toInt)).toArray

for (x <- 0 to 79; y <- 0 to 79; if (x > 0 || y > 0)) {
  matrix(y)(x) += List((x - 1, y), (x, y - 1)).flatMap { case (x, y) =>
    matrix.lift(y).flatMap(_.lift(x))
  }.min
}

println(matrix(79)(79))

source.close
