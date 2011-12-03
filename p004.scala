println((100 to 999).view.flatMap(i => (i to 999).map(i *)).filter { n =>
  val s = n.toString
  s == s.reverse
}.max)
