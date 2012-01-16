val N = 15

println((2 to N + 1).foldLeft(1L)(_ * _) / (0 until (N + 1) / 2).map { n =>
  (1 to N).toSet.subsets(n).map(_.foldLeft(1L)(_ * _)).sum
}.sum)
