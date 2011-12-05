import math.pow

implicit def seq2int(ns:Seq[Int]):Int = ns.reverse.zipWithIndex.map {
  case (n, i) => n * pow(10, i).toInt
}.sum

println((1 to 7).dropWhile { i =>
  (2 to 9-i-1) > (9 to 9-i+1 by -1)
}.takeWhile { i =>
  (i+1 to 9).permutations.map(p => p.splitAt(p.size/2) match {
    case (m1, m2) => m1 * m2
  }).max > (1 to i)
}.flatMap { i =>
  (1 to 9).permutations.flatMap(p => p.splitAt(i) match {
    case (prod, muls) =>
      val product:Int = prod 
      (1 to muls.size-1).map(j => muls.splitAt(j)).collect {
        case (m1, m2) if m1 * m2 == product => product
      }
  })
}.toSet.sum)
