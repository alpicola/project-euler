import scala.math.BigInt

var n = BigInt("600851475143")
lazy val primes:Stream[Int] = 2 #:: Stream.from(3).filter(i =>
  primes.takeWhile(j => j * j <= i).forall(i % _ > 0))
println(primes.find { p => while (n % p == 0) n /= p; n == 1 }.get)
