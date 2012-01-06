println(Iterator.iterate(1L, 1L) { case (a, b) =>
  if (a + b < Long.MaxValue / 2) (a + b, a)
  else  (((a + b) * 0.1).round, (a * 0.1).round)
}.zip(Iterator.iterate(1, 1) { case (a, b) =>
  ((a + b) % 1000000000, a)
}).indexWhere(p => List(p._1, p._2).forall {
  _._1.toString.take(9).sorted == "123456789"
}) + 2)
