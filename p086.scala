println(Iterator.from(1).map { a =>
  (1 to a).map { b =>
    (1 to b).count { c =>
      val m = List((a, b + c), (b, c + a), (c, a + b)).map { p =>
        p._1 * p._1 + p._2 * p._2
      }.min
      val s = math.rint(math.sqrt(m)).toInt
      s * s == m
    }
  }.sum
}.scanLeft(0)(_ + _).indexWhere(1000000 <))
