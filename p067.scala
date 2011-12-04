import scala.io.Source

val source = Source.fromFile("triangle.txt")
val triangle = for (line <- source.getLines) yield line.split(" ").map(_.toInt)

println(triangle.reduceLeft((prev, row) => (0 to prev.size).map(i =>
  row(i) + List(i, i-1).flatMap(prev.lift(_)).max).toArray).max)

source.close
