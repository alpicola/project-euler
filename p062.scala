val cubes = (1 to 9999).map(BigInt(_).pow(3))

println(cubes.groupBy(_.toString.sorted).values.filter(_.size == 5).flatten.min)
