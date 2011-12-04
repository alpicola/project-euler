def fact(n:Int):BigInt = (1 to n).foldLeft(BigInt(1))(_ * _)

println(fact(100).toString.map(_.asDigit).sum)
