println((2 to 99).flatMap { n =>
  (1 to 99).map(m => BigInt(n).pow(m).toString.map(_.asDigit).sum)
}.max)
