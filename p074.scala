val facts = (1 to 9).scanLeft(1)(_ * _)

println((1 until 1000000).count { n =>
  Iterator.iterate(n) { p =>
    p.toString.map(c => facts(c.asDigit)).sum
  }.scanLeft(Set[Int]())(_ + _).zipWithIndex.indexWhere {
    case (s, i) => s.size < i
  } == 61
})
