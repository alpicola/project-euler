import math._

lazy val fibs:Stream[BigInt] = 1 #:: 1 #:: fibs.zip(fibs.tail).map(p => p._1 + p._2)

val n = BigInt(10).pow(999)
println(fibs.takeWhile(n >).size + 1)
