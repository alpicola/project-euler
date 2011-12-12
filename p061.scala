def polygonals(n:Int) = Iterator.from(1).scanLeft(1)(_ + _ * (n - 2) + 1)

val tables = (3 to 7).map { n =>
  polygonals(n).dropWhile(1000 >).takeWhile(10000 >).toList.groupBy(_ / 100)
}

println(polygonals(8).dropWhile(1000 >).takeWhile(10000 >).flatMap { n =>
  (3 to 7).permutations.flatMap(_.foldLeft(List(List(n))) { (prev, k) =>
    prev.flatMap(l => tables(k - 3).get(l.head % 100).map(_.map(_ :: l))).flatten
  }.filter(_.head % 100 == n / 100))
}.next.sum)
