import math._

val primes = List(2, 3, 5, 7, 11, 13, 17, 19)
println((1 until 20).map(n => primes.map { p =>
  Iterator.from(1).scanLeft(n)((r, _) => r / p).takeWhile(_ % p == 0).size
}).transpose.map(_.max).zip(primes).map(p => pow(p._2, p._1).toInt).product)
