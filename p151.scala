val e = Iterator.iterate(Iterator((List(1, 1, 1, 1), 1.0, 0)))(_.flatMap {
  case (bag, p, c) =>
    val s = bag.sum
    val d = if (s == 1) c + 1 else c
    Iterator.range(0, 4).map(bag.splitAt(_)).collect {
      case (a, n :: b) if (n != 0) => (a ++ (n-1 :: b.map(1+)), p * n / s, d)
    }
}).drop(14).next.map(t => t._2 * t._3).sum

printf("%.6f\n", e)
