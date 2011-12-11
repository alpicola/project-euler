val primes = new PrimeSet(100000000)
val table = primes.takeWhile(10000 >).map { n =>
  n -> primes.from(n+1).takeWhile(10000 >).filter { m =>
    List(n, m).permutations.map(_.mkString.toInt).forall(primes.contains(_))
  }.toList
}.toMap

def combinations(ps:List[Int], n:Int, c:List[Int] = Nil):List[List[Int]] = {
  if (n == 1) {
    ps.map(p => p :: c)
  } else {
    ps.flatMap(p => combinations(table(p).intersect(ps), n-1, p :: c))
  }
}

println(combinations(primes.takeWhile(10000 >).toList, 5).map(_.sum).min)
