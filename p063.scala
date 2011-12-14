println((1 to 9).map { n =>
  Iterator.from(1).indexWhere(m => BigInt(n).pow(m).toString.size < m)
}.sum)
