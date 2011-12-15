val N = 10000000
val factors = Array.fill(N)(Array[Int]())

var i = 2
while (i != -1) {
  (i until N by i).foreach(factors(_) :+= i)
  i = factors.indexWhere(_.size == 0, i+1)
}

println((2 until N).minBy { n =>
  val phi = math.rint(n * factors(n).map(1 - 1.0 / _).product).toInt
  if (phi.toString.sorted != n.toString.sorted) N
  else n.toDouble / phi
})
