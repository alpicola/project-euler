println((1 to 1000).maxBy { n =>
  val m = math.sqrt(n).toInt
  if (n != m * m) {
    val it = Iterator.iterate(1, m, BigInt(m), BigInt(1)) {
      case (p, q, r, s) =>
        val t = (n - q * q) / p
        (t, m - (q + m) % t, (q + m) / t * r + s, r)
    }
    val (k, x) = it.zipWithIndex.drop(1).collectFirst {
      case ((1, `m`, _, s), i) => (i, s) 
    }.get
    if (k % 2 == 0) x else it.drop(k-1).next._4
  } else {
    BigInt(0)
  }
})
