println(Iterator.iterate(BigInt(1), BigInt(2)) { p =>
  (p._2, p._1 + p._2 * 2)
}.take(1000).count(p => (p._1 + p._2).toString.size > p._2.toString.size))
