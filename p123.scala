val N = 1000000
val primes = new PrimeSet(N)

println(primes.iterator.map(BigInt(_)).zipWithIndex.map { case (p, n) =>
  val m = p * p
  List(p - 1, p + 1).map(_.modPow(n + 1, m)).sum % m
}.indexWhere(BigInt(10).pow(10) <) + 1)
