println((1 to 9).map { n =>
  Iterator.from(1).takeWhile(m => BigInt(n).pow(m).toString.size == m).size
}.sum)
