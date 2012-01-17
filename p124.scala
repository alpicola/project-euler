val N = 100000
val rad = Array.fill(N + 1)(1)

var i = 2
while (i != -1) {
  (i to N by i).foreach(rad(_) *= i)
  i = rad.indexOf(1, i+1)
}

println(rad.zipWithIndex.sorted.apply(10000)._2)
