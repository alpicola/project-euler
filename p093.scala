implicit def int2rational(n:Int):Rational = new Rational(n)

val ops = List[(Rational, Rational) => Rational](
  (a, b) => a + b, (a, b) => a - b,
  (a, b) => a * b, (a, b) => a / b
)

println((1 to 9).toSet.subsets(4).map(_.toList).maxBy { s =>
  val values = s.permutations.collect {
    case List(a, b, c, d) =>
      for (o <- ops; p <- ops; q <- ops) yield List(
        o(a, p(b, q(c, d))), o(a, q(p(b, c), d)), p(o(a, b), q(c, d)),
        q(o(a, p(b, c)), d), q(p(o(a, b), c), d)
      )
  }.flatten.flatten.toSet
  Iterator.from(1).indexWhere(!values.contains(_))
}.sorted.mkString)
