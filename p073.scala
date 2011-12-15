def gcd(a:Int, b:Int):Int = if (b == 0) a else gcd(b, a % b)

println((4 to 12000).view.map { d =>
  ((if (d % 3 > 0) d / 3 + 1 else d / 3) to d / 2).count(gcd(d, _) == 1)
}.sum)
