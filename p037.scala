val primes = new PrimeSet(1000000)
println(primes.dropWhile(10 >).filter { p =>
  val s = p.toString
  ((1 until s.size).scanLeft(s)((s, _) => s.tail).tail.map(_.toInt) ++
   (1 until s.size).scanLeft(p)((p, _) => p / 10).tail).forall(primes.contains(_))
}.sum)
