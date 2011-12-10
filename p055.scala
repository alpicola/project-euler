println((1 to 9999).count { n =>
  Iterator.iterate(BigInt(n), BigInt(n.toString.reverse)) { p => 
    val m = p._1 + p._2
    (m, BigInt(m.toString.reverse))
  }.take(50).drop(1).forall(p => p._1 != p._2)
})
