def sqrt(n:BigInt, m:BigInt = 1, d:Int = 0, digits:List[Int] = Nil):List[Int] = {
  if (digits.size == 100) digits
  else if (n < m) sqrt(100 * n, 10 * (m - 1) + 1, 0, d :: digits)
  else sqrt(n - m, m + 2, d + 1, digits)
}

println(((1 to 100) diff (1 to 10).map(n => n * n)).flatMap(sqrt(_)).sum)
