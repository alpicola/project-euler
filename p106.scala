import scala.collection.SortedSet

val N = 12
val s = SortedSet((0 until N):_*)
println((2 to N / 2).flatMap { n =>
  for (a <- s.subsets(n); b <- (s -- a).filter(a.max >).subsets(n)
       if (a.zip(b).exists { case (i, j) => i < j })) yield (a, b)
}.size)
