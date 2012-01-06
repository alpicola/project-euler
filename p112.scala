var n = 100
var c = 0
while (c * 100 / n < 99) {
  n += 1
  val s = n.toString
  if (s != s.sorted && s != s.sorted.reverse) c += 1
}

println(n)
