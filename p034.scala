val facts = (1 to 9).scanLeft(1)(_ * _)

val MAX = math.pow(10, Iterator.from(1).indexWhere { i =>
  i * facts(9) < math.pow(10, i)
} + 1).toInt

println((3 until MAX).filter(n =>
  n.toString.map(c => facts(c.asDigit)).sum == n
).sum)
