import math._

val n = Iterator.iterate((21L, 4L)) {
  case (a, b) => (a * 6 - b - 2, a)
}.collectFirst {
  case (a, _) if (a > 1000000000000L) => a
}.get

println((n / sqrt(2)).round)
