import scala.io.Source
import scala.collection.SortedSet

val source = Source.fromFile("sets.txt")
val sets = source.getLines.map(line => SortedSet(line.split(",").map(_.toInt):_*))

println(sets.filter { s =>
  (2 to (s.size + 1) / 2).forall(n => s.take(n).sum > s.takeRight(n-1).sum) &&
  (2 to s.size / 2).map { n =>
    for (a <- s.subsets(n); b <- (s -- a).filter(a.max >).subsets(n)
         if (a.sum == b.sum)) yield (a, b)
  }.forall(_.isEmpty)
}.map(_.sum).sum)

source.close
