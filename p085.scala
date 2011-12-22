val rectangles = (w:Int, h:Int) => w * (w + 1) * h * (h + 1) / 4
val grids= for (w <- Iterator.from(1).takeWhile(i => rectangles(i, 1) < 2100000);
                h <- (1 to w).takeWhile(i => rectangles(i, w) < 2100000)) yield (w, h)
val p = grids.minBy(Function.tupled(rectangles).andThen(n => math.abs(n - 2000000)))

println(p._1 * p._2)
