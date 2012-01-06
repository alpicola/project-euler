import scala.collection.mutable.Map

def memorize[A, B](f:A => B):A => B = {
  val memo = Map[A, B]()
  n => memo.getOrElseUpdate(n, f(n))
}

val fill:Int => Long = memorize {
  case n if (n < 3) => 1
  case n => (0 until n-3).map(fill).sum + fill(n-1) + 1
}

println(fill(50))
