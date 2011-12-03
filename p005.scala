import math._

val primes = List(2, 3, 5, 7, 11, 13, 17, 19)
println((1 until 20).map(n => primes.map { p =>
  val m = log(n) / log(p)
  if (m.toInt == m) m.toInt else 0
}).transpose.map(_.max).zip(primes).map(p => pow(p._2, p._1).toInt).product)
