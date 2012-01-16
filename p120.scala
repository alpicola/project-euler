def gcd(a:Int, b:Int):Int = if (b == 0) a else gcd(b, a % b)
def lcm(a:Int, b:Int) = a * b / gcd(a, b)

println((3 to 1000).map { n =>
  val i = Iterator.iterate(1)(_ * (n - 1) % (n * n))
  val j = Iterator.iterate(1)(_ * (n + 1) % (n * n))
  val k = lcm(i.drop(1).indexOf(1) + 1, j.drop(1).indexOf(1) + 1)
  i.zip(j).take(k - 1).map { case (a, b) => (a + b) % (n * n) }.max
}.sum)
