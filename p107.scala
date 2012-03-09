import scala.io.Source

val source = Source.fromFile("network.txt")
val network = source.getLines.map(_.split(",").map {
  case "-" => Int.MaxValue
  case s   => s.toInt
}).toArray
val total = network.zipWithIndex.flatMap { case (a, i) =>
  a.drop(i + 1).filter(Int.MaxValue !=) }.sum

val span = (0 until 40).toSet
var vertices = Set(0)
var edges = Set[(Int, Int)]()
while (vertices.size < 40) {
  val e = (for (v1 <- vertices; v2 <- span -- vertices)
    yield (v1, v2)).minBy(e => network(e._1)(e._2))
  vertices += e._2
  edges += e
}

println(total - edges.map(e => network(e._1)(e._2)).sum)

source.close
