val primes = new PrimeSet(1000000)
var circulars = Set[Int]()
primes.foreach { p =>
  if (!circulars.contains(p)) {
    val s = p.toString.size
    val ps = (1 to s).scanLeft(p) { (n, _) =>
      n / 10 + (n % 10) * math.pow(10, s-1).toInt
    }.tail.toSet
    if (ps.forall(primes.contains(_))) circulars ++= (ps + p)
  }
}

println(circulars.size)
