val primes = new PrimeSet(10000)

println(Iterator.from(9, 2).filter(!primes.contains(_)).find { n =>
  primes.takeWhile(n >).forall { m =>
    val sqrt = math.sqrt((n - m) / 2)
    sqrt != sqrt.toInt
  }
}.get)
