import scala.io.Source

val source = Source.fromFile("roman.txt")
val chars = Map('I' -> 1, 'V' -> 5, 'X' -> 10, 'L' -> 50,
                'C' -> 100, 'D' -> 500, 'M' -> 1000)
val parse:List[Int] => Int = {
  case m :: n :: rest if (m * 5 == n || m * 10 == n) => n - m + parse(rest) 
  case n :: rest => n + parse(rest)
  case _ => 0
}

println(source.getLines.map { roman =>
  val n = parse(roman.map(chars).toList)
  roman.size - n / 1000 - (n % 1000).toString.map(_.asDigit).map {
    case 9 | 4 => 2
    case n if (n >= 5) => n - 4
    case n => n
  }.sum
}.sum)

source.close
