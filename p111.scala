import math._

val N = 10
val primes = new PrimeSet(pow(10, N * 0.5).toInt)

println((0 to 9).flatMap { d =>
  val c = d.toString.head
  Iterator.from(1).map { m =>
    ((1 - d.signum) until N).toSet.subsets(N - m).flatMap { s =>
      val f1 = "%0" + m + "d"
      val f2 = Array.tabulate(N)(i => if (s.contains(i)) d else "%s").mkString
      Iterator.range(
        if (s.contains(0)) 0 else pow(10, m-1).toInt,
        pow(10, m).toInt
      ).map(f1.format(_)).filterNot(_.contains(c)).map(f2.format(_:_*).toLong)
    }.filter { n =>
      primes.iterator.takeWhile(sqrt(n) >=).forall(n % _ != 0)
    }
  }.find(_.nonEmpty).get
}.sum)
