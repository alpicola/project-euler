import math._
import scala.collection.mutable.Map

val L = 120000L
val m = Map[Long, Set[Long]]()
var s = Set[Long]()

(1L to L).foreach { p =>
  val t = (1L to (p - 1 min L - p)).view.filter { q =>
    val i = (p + q) * (p + q) - p * q
    val j = sqrt(i).round.toLong
    j * j == i
  }.toSet
  if (t.nonEmpty) {
    m(p) = t
    s |= t.flatMap(q => (t & m.getOrElse(q, Set())).map(p + q +).filter(L >=))
  }
}

println(s.sum)
