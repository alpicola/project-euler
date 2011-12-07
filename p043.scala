val primes = List(2, 3, 5, 7, 11, 13, 17)

println((1 to 9).flatMap { n =>
  (0 to 9).filter(n !=).permutations.map(_.mkString).filter { s =>
    s.sliding(3, 1).toList.zip(primes).forall(p => p._1.toInt % p._2 == 0)
  }.map(s => BigInt(n.toString ++ s))
}.sum)
