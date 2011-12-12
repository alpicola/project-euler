println((1 to 10000).count { n =>
  val m = math.sqrt(n).toInt
  m * m != n && Iterator.iterate(1, m) { case (a, b) =>
    val c = (n - b * b) / a
    (c, m - (b + m) % c)
  }.drop(1).indexOf(1, m) % 2 == 0
})
