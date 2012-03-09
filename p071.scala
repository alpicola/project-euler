def gcd(a:Int, b:Int):Int = if (b == 0) a else gcd(b, a % b)

val fs = for (d <- 2 to 1000000; n = d * 3 / 7;
              if (d != 7 && gcd(n, d) == 1)) yield (n, d)
println(fs.maxBy(f => f._1.toDouble / f._2)._1)
