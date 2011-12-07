println(Iterator.from(144).map(n => n.toLong * (n * 2 - 1)).find { n =>
  val m = math.sqrt(n * 2).toLong
  val l = math.sqrt(n / 1.5).ceil.toLong
  m * (m + 1) / 2 == n && l * (l * 3 - 1) / 2 == n
}.get)
