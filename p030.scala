import math.pow

println((2 to pow(9, 5).toInt * 4).filter(n =>
  n == n.toString.map(c => pow(c.asDigit, 5)).sum
).sum)
