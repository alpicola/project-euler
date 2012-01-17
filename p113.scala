val N = 100

println(List(List.fill(9)(1L), (0L :: List.fill(9)(1L)).reverse).flatMap {
  Iterator.iterate(_)(_.scanLeft(0L)(_ + _).tail).map(_.sum).take(N)
}.sum - N * 9)
