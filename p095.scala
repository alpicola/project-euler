val N = 1000000
val primes = new PrimeSet(N).toList

def div(n:Int, d:Int, exp:Int = 0):(Int, Int) = {
  if (n % d != 0) (exp, n)
  else div(n / d, d, exp + 1)
}

def factorize(n:Int, ps:List[Int] = primes):List[(Int, Int)] = {
  if (n <= 1) return Nil
  val p = ps.head
  if (p * p > n) return List((n, 1))
  val (exp, quot) = div(n, p)
  if (exp == 0) factorize(quot, ps.tail)
  else (p, exp) :: factorize(quot, ps.tail)
}

val divisors = Array.tabulate(N)(n => factorize(n).map {
  case (p, e) => (0 to e).map(math.pow(p, _).toInt).sum
}.product - n)

println((2 until N).maxBy { n =>
  var s = List(n)
  while (s.head < N && !s.tail.contains(s.head)) {
    s ::= divisors(s.head)
  }
  if (s.head == n) s.size else 0
})
