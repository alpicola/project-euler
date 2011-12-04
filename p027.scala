lazy val primes:Stream[Int] = 2 #:: Stream.from(3).filter(isPrime)

def isPrime(n:Int) = primes.takeWhile(p => p * p <= n).forall(n % _ > 0)

val (a, b) = primes.takeWhile(1000 >).flatMap(b =>
  (-999 to 999).map(a => (a, b))).maxBy {
  case (a, b) =>
    Iterator.from(1).takeWhile { n =>
      val m = n * n + a * n + b
      m > 0 && isPrime(m)
    }.size
}

println(a * b)
