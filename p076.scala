val N = 100
val table = new Array[Int](N+1)
table(0) = 1

(2 to N-1).foreach { n =>
  table.zipWithIndex.foreach { case (p, sum) =>
    (n to N - sum by n).foreach { s => table(s + sum) += p }
  }
}

println(table.sum)
