println((2 to 100).flatMap(a => (2 to 100).map(BigInt(a).pow(_))).toSet.size)
