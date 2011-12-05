val coins:List[Int] = List(200, 100, 50, 20, 10, 5, 2)

println(coins.foldLeft(List(0)) { (sums, coin) =>
  sums.flatMap(sum => (0 to (200 - sum) / coin).map(_ * coin + sum))
}.size)
