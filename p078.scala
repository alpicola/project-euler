import scala.collection.mutable.ArrayBuffer

def pentagonals = List(Iterator.from(1).map(n => n * (n * 3 + 1) / 2),
                       Iterator.from(1).map(n => n * (n * 3 - 1) / 2))
val p = ArrayBuffer(1)

println(Iterator.from(1).map { n =>
  p.append(pentagonals.flatMap(_.takeWhile(n >=).zipWithIndex.map {
    case (m, i) if (i % 2 == 0) => p(n - m)
    case (m, i) => -p(n - m)
  }).reduceLeft((s, i) => (s + i) % 1000000))
  p.last
}.indexOf(0) + 1)
