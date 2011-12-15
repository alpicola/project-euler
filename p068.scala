println((1 to 9).permutations.map { p =>
  val (i, e) = p.splitAt(5)
  (i :+ i.head).sliding(2).toList.zip(e :+ 10).map {
    case (Seq(n, m), l) => List(l, n, m)
  }
}.filter(_.map(_.sum).sliding(2).forall(p => p(0) == p(1))).map { s =>
  val (l, f) = s.splitAt(s.zipWithIndex.minBy(_._1.head)._2)
  BigInt((f ++ l).flatten.mkString)
}.max)
