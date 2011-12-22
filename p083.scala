import scala.io.Source

val source = Source.fromFile("matrix.txt")
val matrix = source.getLines.map(_.split(",").map(_.toInt)).toArray
val table = matrix.scanLeft(0)(_ + _.head).tail.zip(matrix).map {
  case (n, row) => row.tail.scanLeft(n)(_ + _)
}
val cells = for (x <- 0 until 80; y <- 0 until 80) yield(x, y)

while (cells.exists { case (x, y) =>
  val m = List((x - 1, y), (x + 1, y), (x, y - 1), (x, y + 1)).flatMap {
    case (x, y) => table.lift(y).flatMap(_.lift(x))
  }.min + matrix(y)(x)
  if (table(y)(x) > m) {
    table(y)(x) = m; true
  } else {
    false
  }
})()

println(table.last.last)

source.close
