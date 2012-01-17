val N = 100000000
val squares = (1 to math.sqrt(N / 2).toInt).map(n => n * n)

println(squares.scanLeft(0L)(_ + _).toList.tails.flatMap { 
  case n :: _ :: ns =>
    ns.iterator.map(_ - n).takeWhile(N >).filter { m =>
      val s = m.toString
      s == s.reverse
    }
  case _ => Nil
}.toSet.sum)
