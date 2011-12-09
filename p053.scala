println(Iterator.iterate(Seq(BigInt(1), BigInt(1))) { prev =>
  (0 to prev.size).map(i => List(i, i-1).flatMap(prev.lift(_)).sum)
}.take(100).map(_.count(_ > 1000000)).sum)

