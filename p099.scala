import scala.io.Source

val source = Source.fromFile("base_exp.txt")

println(source.getLines.map(_.split(",").map(_.toInt)).collect {
  case Array(n, e) => math.log(n) * e
}.zipWithIndex.maxBy(_._1)._2 + 1)

source.close
