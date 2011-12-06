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

val MAX = 28123
val divisors = 0 :: 1 :: (2 to MAX).map(n => factorize(n).map {
  case (p, e) => (0 to e).map(math.pow(p, _).toInt).sum
}.product - n).toList
val abundants = divisors.zipWithIndex.collect {
  case (n, i) if n > i => i
}

println((1 to MAX).diff(abundants.zipWithIndex.view.flatMap {
  case (n, i) => abundants.drop(i).takeWhile(MAX - n >=).map(n +)  
}).sum)
