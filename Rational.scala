class Rational(n:Int, d:Int) extends Ordered[Rational] {
  private val g = if (n == 0 && d == 0) 1 else if (d < 0) -gcd(n, d) else gcd(n, d)
  val numerator = n / g
  val denominator = d / g

  def this(n:Int) = this(n, 1)

  def +(that:Rational) =
    new Rational(numerator * that.denominator + that.numerator * denominator,
                 denominator * that.denominator)
  def -(that:Rational) =
    new Rational(numerator * that.denominator - that.numerator * denominator,
                 denominator * that.denominator)
  def *(that:Rational) =
    new Rational(numerator * that.numerator, denominator * that.denominator)
  def /(that:Rational) =
    new Rational(numerator * that.denominator, denominator * that.numerator)

  override def compare(that:Rational) =
    numerator * that.denominator - denominator * that.numerator
  override def equals(that:Any) =
    canEqual(that) && compare(that.asInstanceOf[Rational]) == 0
  def canEqual(that:Any) = that.isInstanceOf[Rational]
  override val hashCode = 41 * (41 + numerator) + denominator

  override def toString = numerator + "/" + denominator

  private def gcd(a:Int, b:Int):Int = if (b == 0) a.abs else gcd(b, a % b)
}
