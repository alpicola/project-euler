import scala.io.Source

val source = Source.fromFile("names.txt")
val names = source.getLines.flatMap(_.split(",").map(s => s.slice(1, s.size-1)))

println(names.toList.sorted.zipWithIndex.map {
  case (name, i) => name.map(_.toInt - 64).sum * (i + 1)
}.sum)

source.close
