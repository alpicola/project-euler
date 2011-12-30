import scala.collection.mutable.Set
import math._

val MAX = 50000000
val primes = new PrimeSet(sqrt(MAX).toInt)
val table = Set[Int]()

for (n <- primes.iterator.map(pow(_, 4).toInt).takeWhile(MAX >);
     m <- primes.iterator.map(pow(_, 3).toInt + n).takeWhile(MAX >);
     l <- primes.iterator.map(pow(_, 2).toInt + m).takeWhile(MAX >)) table += l

println(table.size)
