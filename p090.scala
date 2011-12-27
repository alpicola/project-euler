val squares = (1 to 9).map(n => n * n)
val cubes = (0 to 9).toSet.subsets(6).toSet

println(cubes.subsets(2).count { s =>
  val List(a, b) = s.toList.map {
    case c if (c.contains(6)) => c + 9
    case c if (c.contains(9)) => c + 6
    case c => c
  }
  squares.forall { n =>
    a.contains(n / 10) && b.contains(n % 10) ||
    a.contains(n % 10) && b.contains(n / 10)
  }
})
