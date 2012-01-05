println((3L to 1000000000L / 3 by 2).flatMap { a =>
  List(a + 1, a - 1).filter { b =>
    val n = a * a - b * b / 4
    val m = math.sqrt(n).round
    m * m == n
  }.map(a * 2 +)
}.sum)
