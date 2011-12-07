import scala.io.Source

val source = Source.fromFile("words.txt")
val words = source.getLines.flatMap(_.split(",").map(s => s.slice(1, s.size-1)))

println(words.map(s => s.map(_.toInt - 64).sum * 2).count { n =>
  val sqrt = math.sqrt(n).toInt
  sqrt * (sqrt + 1) == n
})

source.close
