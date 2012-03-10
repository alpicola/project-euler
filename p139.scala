import math._

def gcd(a:Long, b:Long):Long = if (b == 0) a else gcd(b, a % b)

val L = 100000000L
var i = 0L

for (m <- 2L to sqrt(L / 2).toLong;
     n <- (m % 2 + 1L) to min(L / 2 / m - m, m - 1) by 2L;
     a = m * m - n * n;
     b = m * n * 2;
     c = m * m + n * n;
     if (c % (b - a) == 0 && gcd(m, n) == 1)) {
  i += L / (a + b + c)
}

println(i)
