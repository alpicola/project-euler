import scala.collection.mutable.Map
import math._

val N = 100000
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

val divisors = (0 until N).map(n => factorize(n).foldLeft(List(1)) {
  case (l, (p, e)) => l.flatMap(m => (0 to e).map(pow(p, _).toInt * m))
}.sorted)

def partitions(n:Int, start:Int = 2):List[List[Int]] = {
  divisors(n).dropWhile(start >).takeWhile(sqrt(n) >=).flatMap { m =>
    (List(n / m) :: partitions(n / m, m)).map(l => m :: l)
  }
}

val MAX = 12000
val table = Map[Int, Int]()

var n = 4
while (table.size < MAX - 1) {
  partitions(n).foreach { p =>
    val k = n - p.sum + p.size
    if (k <= MAX && !table.contains(k)) table(k) = n
  }
  n += 1
}

println(table.values.toSet.sum)
