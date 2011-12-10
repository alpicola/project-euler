import scala.io.Source

val source = Source.fromFile("poker.txt")

println(source.getLines.count { line =>
  val ranks = line.split(" ").grouped(5).map { cards =>
    val values = cards.map(_(0)).map {
      case 'T' => 10 
      case 'J' => 11
      case 'Q' => 12
      case 'K' => 13
      case 'A' => 14
      case d => d.asDigit
    }.sorted.reverse.toList
    val flush = cards.map(_(1)).sliding(2).forall(s => s(0) == s(1))
    val straight = values.zipWithIndex.forall(p => values.head == p._1 + p._2)
    values.distinct.map(v => (values.count(v ==), v)).sorted.reverse match {
      case _ if (flush && straight) => 9 :: values
      case List((4, a), (1, b)) => List(8, a, b)
      case List((3, a), (2, b)) => List(7, a, b)
      case _ if (flush) => 6 :: values
      case _ if (straight) => 5 :: values
      case List((3, a), (1, b), (1, c)) => List(4, a, b, c)
      case List((2, a), (2, b), (1, c)) => List(3, a, b, c)
      case List((2, a), (1, b), (1, c), (1, d)) => List(2, a, b, c, d)
      case _ => 1 :: values
    }
  }
  ranks.next.zip(ranks.next).dropWhile(p => p._1 == p._2) match {
    case p :: ps => p._1 > p._2
    case _ => false
  }
})

source.close
