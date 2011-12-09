val primes = new PrimeSet(1000000)

println(primes.find { n =>
  val s = n.toString
  s.toSet.exists { c =>
    ((if (c == s(0)) 1 else 0) to 9).mkString.count { d =>
      c != d && primes.contains(s.replace(c, d).toInt)
    } == 7
  }
}.get)
