def fact(n:Int):BigInt = (1 to n).foldLeft(BigInt(1))(_ * _)

println(fact(40) / (fact(20) * fact(20)))
