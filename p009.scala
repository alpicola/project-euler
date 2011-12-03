// (a - 1000)(b - 1000) = 2^5 * 5^6
// a < 1000/3, b < 1000/2

val rs = for { n <- 0 to 5; m <- 0 to 6
               a = 1000 - (pow(2, n) * pow(5, m)).toInt
               b = 1000 - (pow(2, 5-n) * pow(5, 6-m)).toInt
               if 0 < a && a < 333 && 0 < b && b < 500 } yield a * b * (1000 - a - b)
println(rs(0))
