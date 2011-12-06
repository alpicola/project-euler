def pow(n:Int, e:Int) = math.pow(n, e).toInt

println((0 to 6).map { i =>
  val n = pow(10, i)
  val (rest, d) = Iterator.from(1).scanLeft(n) { (r, i) =>
    r - (pow(10, i) - pow(10, i-1)) * i
  }.takeWhile(0 <).zipWithIndex.reduceLeft((_, p) => p)
  (pow(10, d) + (rest-1) / (d+1)).toString()((rest-1) % (d+1)).asDigit
}.product)
