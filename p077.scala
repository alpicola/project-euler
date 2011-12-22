val primes = new PrimeSet(100)

println(Iterator.from(2).find { N =>
  val table = new Array[Int](N+1)
  table(0) = 1
  primes.from(3).takeWhile(N >).foreach { n =>
    table.zipWithIndex.foreach { case (p, sum) =>
      (n to N - sum by n).foreach { s => table(s + sum) += p }
    }
  }
  (N % 2 to N by 2).map(table(_)).sum > 5000
}.get)
