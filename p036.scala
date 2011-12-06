println((1 until 1000000).view.filter { n =>
  List(n.toString, BigInt(n).toString(2)).forall { s =>
    s.take(s.size / 2) == s.takeRight(s.size / 2).reverse
  }
}.sum)
