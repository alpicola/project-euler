val N = 1000000
val factors = new Array[Int](N)

var i = 2
while (i != -1) {
  (i until N by i).foreach(factors(_) += 1)
  i = factors.indexOf(0, i+1)
}

println(factors.sliding(4, 1).zipWithIndex.drop(2).collectFirst {
  case (p, i) if (p.forall(4 ==)) => i 
}.get)
