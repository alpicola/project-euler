import scala.util.Random

val statistics = new Array[Int](40)

def pile = Random.shuffle((1 to 16).toList)
val cc = Iterator.continually(pile).flatten
val ch = Iterator.continually(pile).flatten

def roll(p:Int, c:Int = 1):Int = {
  statistics(p) += 1
  val a = Random.nextInt(4) + 1
  val b = Random.nextInt(4) + 1
  if (a == b && c == 3) return 10
  val q = advance(p, a + b)
  if (a != b || q == 10) q 
  else roll(q, c + 1)
}

def advance(p:Int, d:Int):Int = { 
  val q = (p + d) % 40
  q match {
    case 1 | 17 | 33 => cc.next match {
      case 1 => 0
      case 2 => 10
      case _ => q
    }
    case 7 | 22 | 36 => ch.next match {
      case 1 => 0
      case 2 => 10
      case 3 => 11
      case 4 => 24
      case 5 => 39
      case 6 => 5
      case 7 | 8 => (q + 5) % 40 / 10 * 10 + 5
      case 9 => if (12 < q && q <= 28) 28 else 12
      case 10 => advance(q, -3)
      case _ => q
    }
    case 30 => 10
    case _ => q
  }
}

Iterable.iterate(0, 100000)(roll(_))

println(statistics.zipWithIndex.sortBy(-_._1).map(_._2).take(3).mkString)
