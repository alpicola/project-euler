val dart = (25, 1) :: (25, 2) :: List.range(1, 21).flatMap(i => (1 to 3).map((i, _)))
val one = dart.map(_ :: Nil)
val two = one.flatMap(o => dart.filter((o.head:Ordered[(Int, Int)]) >=).map(_ :: o))

println((0 :: (one ++ two).map(_.map(p => p._1 * p._2).sum)).flatMap { s =>
  (25 :: List.range(1, 21)).map(_ * 2 + s)
}.count(100 >))
