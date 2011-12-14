val f = (2 :: Iterator.from(1).flatMap { i =>
  List(1, i * 2, 1)
}.take(99).toList).reverse

println(f.tail.foldLeft(BigInt(1), BigInt(f.head)) { (p, n) =>
  (p._2, p._1 + p._2 * n)
}._2.toString.map(_.asDigit).sum)

