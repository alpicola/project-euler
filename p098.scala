import scala.io.Source
import math._

val source = Source.fromFile("words.txt")
val words = source.getLines.flatMap(_.split(",").map(s => s.slice(1, s.size-1)))
val anagrams = words.toList.groupBy(_.sorted).values.flatMap(_.toSet.subsets(2))

println(anagrams.map(_.toList).collect { case List(a, b) =>
  Iterator.range(sqrt(pow(10, a.size-1)).ceil.toInt,
                 sqrt(pow(10, a.size)-1).toInt).map(i => i * i).flatMap { n =>
    val map = a.zip(n.toString).toMap
    val m = b.map(map).toInt
    val r = rint(sqrt(m))
    if (map.size == map.values.toSet.size && a.map(map).toInt == n &&
        map(b.head) != '0' && r * r == m) List(n, m)
    else Nil
  }
}.flatten.max)

source.close
