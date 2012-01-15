val N = 100000
val primes = new PrimeSet(N)

def partitions(set:Set[Int]):Iterator[List[Set[Int]]] = {
  if (set.isEmpty) {
    Iterator.single(Nil)
  } else {
    val m = set.max
    (set - m).subsets.map(_ + m).flatMap { s =>
      partitions(set -- s).map(s :: _)
    }
  }
}

println(partitions((1 to 9).toSet).map {
  _.map(_.toList.permutations.map(_.mkString.toInt).count { n =>
    if (n < N) primes.contains(n)
    else primes.iterator.takeWhile(math.sqrt(n) >=).forall(n % _ != 0)
  }).product
}.sum)
