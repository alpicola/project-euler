import scala.math.BigInt

var n = BigInt("600851475143")
def primes(s:Stream[Int]):Stream[Int] = s.head #:: primes(s.tail.filter(_ % s.head != 0))
println(primes(Stream.from(2)).find { p => while (n % p == 0) n /= p; n == 1 }.get)
