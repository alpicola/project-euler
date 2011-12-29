class Rational(n:BigInt, d:BigInt) extends Ordered[Rational] {
  require(n != 0 || d != 0)

  private val g = if (d < 0) -n.gcd(d) else n.gcd(d)
  val numerator = n / g
  val denominator = d / g

  def this(n:BigInt) = this(n, 1)

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

  def signum = numerator.signum
  def negate = new Rational(-numerator, denominator)
  def unary_- = negate
  def abs = if (signum == -1) -this else this
  def pow(n:Int) = new Rational(numerator.pow(n), denominator.pow(n))

  override def compare(that:Rational) =
    if (denominator == 0 && that.denominator == 0) signum - that.signum
    else (numerator * that.denominator - denominator * that.numerator).signum
  override def equals(that:Any) =
    canEqual(that) && compare(that.asInstanceOf[Rational]) == 0
  def canEqual(that:Any) = that.isInstanceOf[Rational]
  override def hashCode = 41 * (41 + numerator.hashCode) + denominator.hashCode

  def toInt = (numerator / denominator).toInt
  def toLong = (numerator / denominator).toLong
  def toFloat = numerator.toFloat / denominator.toFloat
  def toDouble = numerator.toDouble / denominator.toDouble

  override def toString =
    if (denominator == 1) numerator.toString else numerator + "/" + denominator
}

object Rational {
  implicit object RationalIsFractional extends Fractional[Rational] with Ordering[Rational] {
    def compare(x:Rational, y:Rational) = x.compare(y)
    def plus(x:Rational, y:Rational) = x + y
    def minus(x:Rational, y:Rational) = x - y
    def times(x:Rational, y:Rational) = x * y
    def div(x:Rational, y:Rational) = x / y
    def negate(x:Rational) = -x
    def toInt(x:Rational) = x.toInt 
    def toLong(x:Rational) = x.toLong
    def toFloat(x:Rational) = x.toFloat
    def toDouble(x:Rational) = x.toDouble
    def fromInt(x:Int) = new Rational(x)
  }
}
