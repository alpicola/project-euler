def square(n:Int) = n * n

println(1 + (1 to 500).map { n =>
  val m = n * 2
  (square(m - 1) + square(m + 1) + m) * 2
}.sum)
