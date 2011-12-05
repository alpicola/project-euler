def gcd(a:Int, b:Int):Int =
  if (b == 0) a else gcd(b, a % b)

val p = (10 to 99).flatMap(n =>
  (10 until n).map((_, n))).collect {
  case (a, b) if (a * (b % 10) == b * (a / 10) &&
                  a % 10 == b / 10) => (a, b)
}.reduceLeft((f1, f2) => (f1._1 * f2._1, f1._2 * f2._2))

println(p._2 / gcd(p._1, p._2))
