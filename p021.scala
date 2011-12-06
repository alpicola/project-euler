lazy val primes:Stream[Int] = 2 #:: Stream.from(3).filter(i =>
  primes.takeWhile(j => j * j <= i).forall(i % _ > 0))

def div(n:Int, d:Int, exp:Int = 0):(Int, Int) = {
  if (n % d != 0) (exp, n)
  else div(n / d, d, exp + 1)
}

def factorize(n:Int, ps:Stream[Int] = primes):List[(Int, Int)] = {
  if (n <= 1) return Nil
  val p = ps.head
  if (p * p > n) return List((n, 1))
  val (exp, quot) = div(n, p)
  if (exp == 0) factorize(quot, ps.tail)
  else (p, exp) :: factorize(quot, ps.tail)
}

val divisors = 0 :: 1 :: (2 until 10000).map(n => factorize(n).map {
  case (p, e) => (0 to e).map(math.pow(p, _).toInt).sum
}.product - n).toList

println(divisors.zipWithIndex.collect {
  case (n, i) if n < 10000 && divisors(n) != n && divisors(n) == i => i
}.sum)
