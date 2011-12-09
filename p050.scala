val primes = new PrimeSet(1000000)

println(primes.flatMap { n =>
  val sum = primes.from(n+1).scanLeft(n)(_ + _).takeWhile(1000000 >).toIterable
  sum.tail.zipWithIndex.filter(p => primes.contains(p._1)).lastOption
}.maxBy(p => p._2)._1)
