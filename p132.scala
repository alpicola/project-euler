val N = 1000000000
val primes = new PrimeSet(1000000)

println(primes.iterator.drop(3).filter { p =>
  var (i, j, k) = (1, 1, 0)
  do {
    i = i * 10 % p
    j = (i + j) % p
    k += 1
  } while (i != 1 && k < N - 1)
  k == N && j == 0 ||
  ((j - 1) * (N / k) + Iterator.iterate(1)(_ * 10 % p).take(N % k).sum) % p == 0
}.take(40).sum)
