println((1 to 500).flatMap { c =>
  (1 to (c * 0.707).toInt).flatMap { a =>
    val b = math.sqrt(c * c - a * a)
    if (b == b.toInt) Some(a, b.toInt, c)
    else None
  }
}.groupBy(p => p._1 + p._2 + p._3).maxBy(p => p._2.size)._1)
