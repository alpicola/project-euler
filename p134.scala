val primes = new PrimeSet(1000004)

println(primes.iterator.drop(2).sliding(2).collect { case Seq(p, q) =>
  val n = BigInt(10).pow(p.toString.size)
  val m = (n % q).toInt
  var (r, i) = (p, 0)
  while (r != 0) {
    r = (r + m) % q
    i += 1
  }
  n * i + p 
}.sum)
