import scala.collection.mutable.Map

def memorize[A, B](f:A => B):A => B = {
  val memo = Map[A, B]()
  n => memo.getOrElseUpdate(n, f(n))
}

val fill:Int => Long = memorize {
  case 0 => 1
  case n => (0 max n-4 until n).map(fill).sum
}

println(fill(50))
