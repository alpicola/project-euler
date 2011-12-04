lazy val fibs:Stream[Int] = 1 #:: 2 #:: fibs.zip(fibs.tail).map(p => p._1 + p._2)

println(fibs.view.takeWhile(4000000 >=).filter(_ % 2 == 0).sum)
