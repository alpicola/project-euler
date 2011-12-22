import math._
import scala.collection.mutable.Map

def gcd(a:Int, b:Int):Int = if (b == 0) a else gcd(b, a % b)

val L = 1500000
val table = Map[Int, Int]()

for (m <- 2 to sqrt(L / 2).toInt;
     n <- 1 to min(L / (2 * m) - m, m - 1);
     if ((m + n) % 2 == 1 && gcd(m, n) == 1)) {
  val l = 2 * m * (m + n)
  (l to L by l).foreach { k => table(k) = table.getOrElse(k, 0) + 1 }
}

println(table.values.count(1 ==))
