val primes = List(2, 3, 5, 7, 11, 13, 17, 19)

println((1 until 20).map(n => primes.map { p =>
  Iterator.iterate(n)(_ / p).indexWhere(_ % p != 0)
}).transpose.map(_.max).zip(primes).map(p => BigInt(p._2).pow(p._1)).product)
