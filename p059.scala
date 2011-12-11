import scala.io.Source

val source = Source.fromFile("cipher1.txt")
val cipher = source.getLines.flatMap(_.split(",").map(_.toInt)).toList

println(Iterator.iterate(List("")) { prev =>
  prev.flatMap(s => ('a' to 'z').map(s +))
}.drop(3).next.view.map { key =>
  cipher.zipWithIndex.map { case (c, i) => (c ^ key(i % 3)).toChar }.mkString
}.find(_.contains(" the ")).get.map(_.toInt).sum)

source.close
