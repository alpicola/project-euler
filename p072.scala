val N = 1000000
val factors = Array.fill(N+1)(Array[Int]())

var i = 2
while (i != -1) {
  (i to N by i).foreach(factors(_) :+= i)
  i = factors.indexWhere(_.size == 0, i+1)
}

println((2 to N).view.map { n =>
  BigInt(math.rint(n * factors(n).map(1 - 1.0 / _).product).toInt)
}.sum)
