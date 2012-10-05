val N = 2000
val table = new Array[Int](N * N)

(1 to 55).foreach { k =>
  table(k-1) = ((100003L - 200003L * k + 300007L * k * k * k) % 1000000).toInt - 500000
}
(55 until N * N).foreach { k =>
  table(k) = (table(k-24) + table(k-55) + 1000000) % 1000000 - 500000
}

val rows = table.iterator.sliding(N, N)
val cols = Iterator.range(0, N).map { n =>
  Iterator.range(n, N * N, N).map(table)
}
val diagonals = Iterator.range(1-N, N).flatMap { n =>
  val r = Iterator.range(0 max n, N min N+n)
  Iterator(r.map(_ * (N-1) + n + N-1),
           r.map(_ * (N+1) - n)).map(_.map(table))
}

println((rows ++ cols ++ diagonals).map { row =>
  row.foldLeft(0L, 0L) { case ((p, s), n) =>
    val q = 0L max p+n
    (q, s max q)
  }._2
}.max)
