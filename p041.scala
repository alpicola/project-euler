val primes = new PrimeSet(100000000)

println((4 to 8).flatMap { n =>
  (1 to n).permutations.map(_.mkString.toInt).filter(primes.contains(_))
}.max)
