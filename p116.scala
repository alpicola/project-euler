import scala.collection.mutable.Map

def memorize[A, B](f:A => B):A => B = {
  val memo = Map[A, B]()
  n => memo.getOrElseUpdate(n, f(n))
}

println((2 to 4).map { i =>
  lazy val fill:Int => Long = memorize {
    case n if (n < i) => 1
    case n => fill(n-i) + fill(n-1)
  }
  fill(50) - 1
}.sum)
