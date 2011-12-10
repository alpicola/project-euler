val primes = new PrimeSet(Integer.MAX_VALUE)

println(Iterator.from(1, 2).map { i =>
  Iterator.from(i * i, i + 1).slice(1, 5).count(primes.contains(_))
}.scanLeft(0)(_ + _).drop(1).zipWithIndex.collectFirst {
  case (c, i) if (c / (1f + i * 4) < 0.1) => i * 2 + 1
}.get)
