println(Iterator.from(3, 2).filter(_ % 5 != 0).find { n =>
  // Iterator.iterate(1)(_ * 10 % n).scanLeft(0)((s, i) =>
  //   (s + i) % n).drop(1).indexOf(0) > 1000000
  var (i, j, k) = (1, 1, 1)
  while (j != 0) {
    i = i * 10 % n
    j = (i + j) % n
    k += 1
  }
  k > 1000000
}.get)
