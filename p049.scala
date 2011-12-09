val primes = new PrimeSet(10000)

println(primes.dropWhile(1488 >).collectFirst(Function.unlift({ a => 
  val set = a.toString.toSet
  primes.from(a+1).takeWhile((a + 10000) / 2 >).map { b =>
    List(a, b, b * 2 - a)
  }.find(s => s.tail.forall(_.toString.toSet == set && primes.contains(s(2))))
})).get.mkString)
