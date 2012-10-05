val N = 1000
val randoms = Iterator.iterate(0) { t =>
  ((615949L * t + 797807L) % 1048576).toInt
}.drop(1).map(_ - 524288)
val triangle = Array.tabulate(N) { n =>
  randoms.take(n+1).scanLeft(0)(_ + _).toArray
}

println(Iterator.range(0, N).flatMap { x =>
  Iterator.range(0, x+1).flatMap { y =>
    Iterator.range(x, N).map { n =>
      val row = triangle(n)
      row(y+n-x+1) - row(y)
    }.scanLeft(0L)(_ + _).drop(1)
  }
}.min)
