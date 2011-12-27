import scala.io.Source

val source = Source.fromFile("matrix.txt")
val matrix = source.getLines.map(_.split(",").map(_.toInt)).toArray

for (x <- 0 until 80; y <- 0 until 80; if (x > 0 || y > 0)) {
  matrix(y)(x) += List((x - 1, y), (x, y - 1)).flatMap {
    case (x, y) => matrix.lift(y).flatMap(_.lift(x))
  }.min
}

println(matrix.last.last)

source.close
