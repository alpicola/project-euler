import math.pow

val facts = (1 to 9).scanLeft(1)(_ * _)

val MAX = pow(10, Iterator.from(1).takeWhile { i =>
  i * facts(9) >= pow(10, i)
}.size + 1).toInt

println((3 until MAX).filter(n =>
  n.toString.map(c => facts(c.asDigit)).sum == n
).sum)
