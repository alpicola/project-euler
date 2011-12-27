import scala.io.Source

val source = Source.fromFile("roman.txt")
val chars = Map('I' -> 1, 'V' -> 5, 'X' -> 10, 'L' -> 50,
                'C' -> 100, 'D' -> 500, 'M' -> 1000)
lazy val parse:List[Int] => Int = {
  case s :: n :: rest if (s * 5 == n || s * 10 == n) => n - s + parse(rest) 
  case n :: rest => n + parse(rest)
  case Nil => 0
}

println(source.getLines.map { roman =>
  val n = parse(roman.map(chars).toList)
  roman.size - n / 1000 - (n % 1000).toString.map(_.asDigit).collect {
    case 9 => 2
    case n if (n >= 5) => n - 4
    case 4 => 2
    case n => n
  }.sum
}.sum)

source.close
