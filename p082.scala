import scala.io.Source

val source = Source.fromFile("matrix.txt")
val matrix = source.getLines.map(_.split(",").map(_.toInt)).toArray
val columns = matrix.transpose
val table = columns.head
val rows = 0 until 80

columns.tail.foreach { c =>
  rows.foreach(i => table(i) += c(i))
  while (rows.exists { i =>
    val m = List(i - 1, i + 1).flatMap(table.lift(_)).min + c(i)
    if (table(i) > m) {
      table(i) = m; true
    } else {
      false
    }
  })()
}

println(table.min)

source.close
