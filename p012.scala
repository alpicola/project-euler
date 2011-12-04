println(Stream.from(2).map(n => n * (n+1) / 2).find { n =>
  (1 to math.sqrt(n).toInt).count(n % _ == 0) * 2 >= 501
}.get)
