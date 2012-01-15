val N = 15
val Max = math.pow(10, N)

println((2 to N * 9).flatMap { n =>
  Iterator.iterate(1L)(n *).dropWhile(10 >).takeWhile(Max >).filter {
    _.toString.map(_.asDigit).sum == n
  }
}.sorted.apply(29))
