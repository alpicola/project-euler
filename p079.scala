import scala.io.Source

val source = Source.fromFile("keylog.txt")
val keylog = source.getLines.toList.distinct
val keys = keylog.mkString.distinct

source.close

println((0 until keys.size).permutations.find { p =>
  val order = keys.zip(p).toMap
  keylog.forall(_.map(order(_)).sliding(2).forall(s => s(0) < s(1)))
}.get.zip(keys).sorted.map(_._2).mkString)
