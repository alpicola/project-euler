import math._

val MAX = 50000000
val primes = new PrimeSet(sqrt(MAX).toInt)

println(primes.from(2).map(pow(_, 4).toInt).takeWhile(MAX >).flatMap { n =>
  primes.from(2).map(pow(_, 3).toInt + n).takeWhile(MAX >).flatMap { m =>
    primes.from(2).map(pow(_, 2).toInt + m).takeWhile(MAX >)
  }
}.toSet.size)
