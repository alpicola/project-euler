def gcd(a:Int, b:Int):Int = if (b == 0) a else gcd(b, a % b)

println((2 to 1000000).view.map(d => (d * 3 / 7, d)).maxBy {
  case (3, 7) => 0
  case (n, d) if (gcd(n, d) == 1) => n.toDouble / d
  case _ => 0
}._1)
