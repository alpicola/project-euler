def square(n:Int) = n * n
println(square((1 to 100).sum) - (1 to 100).map(square).sum)
