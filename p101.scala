implicit def int2rational(n:Int):Rational = new Rational(n)

class Polynomial(val coefficients:Array[Rational]) {
  def apply(i:Int) = coefficients(i)
  def +(that:Polynomial) = 
    new Polynomial(coefficients.zip(that.coefficients).map(p => p._1 + p._2))
  def -(that:Polynomial) =
    new Polynomial(coefficients.zip(that.coefficients).map(p => p._1 - p._2))
  def *(c:Rational) = new Polynomial(coefficients.map(c *))
  def /(c:Rational) = new Polynomial(coefficients.map(_ / c))
  def substitute(n:Rational) = coefficients.zipWithIndex.map {
    case (c, e) => c * n.pow(e)
  }.sum
}

def solve(a:Array[Polynomial], b:Array[Rational]) = {
  val n = a.size
  for (i <- 0 until n; j <- 0 until n; if (i != j)) {
    val k = a(j)(i) / a(i)(i)
    a(j) -= a(i) * k
    b(j) -= b(i) * k
  }
  Array.tabulate(n)(i => b(i) / a(i)(i))
}

val g = new Polynomial(Array.tabulate(11)(i => -1.pow(i)))
val u = Array.tabulate(11)(i => g.substitute(i+1))

println((1 to 10).map { n =>
  new Polynomial(solve(Array.tabulate(n) { i =>
    new Polynomial(Array.tabulate(n)(j => (i+1).pow(j)))
  }, u.take(n))).substitute(n + 1)
}.sum)
