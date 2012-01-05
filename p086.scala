println(Iterator.from(1).map { a =>
  (1 to a).map { b =>
    (1 to b).count { c =>
      val n = a * a + (b + c) * (b + c)
      val m = math.sqrt(n).round
      m * m == n
    }
  }.sum
}.scanLeft(0)(_ + _).indexWhere(1000000 <))
