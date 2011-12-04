def from(n:Long, c:Int = 0):Int = if (n == 1) c + 1 else
  from(if (n % 2 == 0) n / 2 else n * 3 + 1, c + 1)
println((1 until 1000000).maxBy(from(_)))
