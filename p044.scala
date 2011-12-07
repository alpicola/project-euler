def pentagonal(n:Int) = n * (n * 3 - 1) / 2

println(Iterator.from(1).map(i => (pentagonal(i), i)).find {
  case (d, i) => 
    val min = math.sqrt((i * 3 + 1) * 2 / 3.0).ceil.toInt
    Iterator.range(min, (d - 1) / 3).map(pentagonal).exists { n =>
      List(n + d, 2 * n + d).map(2 *).forall { m =>
        val sqrt = math.sqrt(m / 3.0).ceil.toInt
        sqrt * (sqrt * 3 - 1) == m
      }
    }
}.get._1)
