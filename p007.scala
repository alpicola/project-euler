lazy val primes:Stream[Int] = 2 #:: Stream.from(3).filter(i =>
  primes.takeWhile(j => j * j <= i).forall(i % _ != 0))
println(primes(10000))
