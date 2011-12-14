val primes = new PrimeSet(1000000)
var circulars = Set[Int]()
primes.foreach { p =>
  if (!circulars.contains(p)) {
    val s = p.toString.size
    val ps = Iterable.iterate(p, s) { n =>
      n / 10 + (n % 10) * math.pow(10, s-1).toInt
    }.tail.toSet
    if (ps.forall(primes.contains(_))) circulars ++= (ps + p)
  }
}

println(circulars.size)
