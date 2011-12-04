val months = for (yr <- 1901 to 2000; mon <- 1 to 12) yield (yr, mon)

println(months.take(100 * 12 - 1).map {
  case (mon, yr) =>
    mon match {
      case 2 if (yr % 4 == 0 && (yr % 100 != 0 || yr % 400 == 0)) => 29
      case 2 => 28
      case 4 | 6 | 9 | 11 => 30
      case _ => 31
    }
}.scanLeft(0)(_ + _).count(_ % 7 == 5))
