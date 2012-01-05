import scala.collection.SortedSet

println(SortedSet((20 to 50):_*).subsets(7).filter { s =>
  (2 to 4).forall(n => s.take(n).sum > s.takeRight(n-1).sum) &&
  (2 to 3).map { n =>
    for (a <- s.subsets(n); b <- (s -- a).filter(a.max >).subsets(n)
         if (a.sum == b.sum)) yield (a, b)
  }.forall(_.isEmpty)
}.minBy(_.sum).mkString)
