val primes = new PrimeSet(100000)

println(Iterator.from(3, 2).filter { n =>
  lazy val a = {
    var (i, j, k) = (1, 1, 1)
    while (j != 0) {
      i = i * 10 % n
      j = (i + j) % n
      k += 1
    }
    k
  }
  n % 5 != 0 && !primes.contains(n) && (n - 1) % a == 0
}.take(25).sum)
