import scala.collection.mutable.BitSet

val MAX = 10000000
val table = new BitSet(MAX)
table += 89

(2 until MAX).foreach { n =>
  if (table.contains(Iterator.iterate(n) { m =>
    m.toString.view.map(c => c.asDigit * c.asDigit).sum
  }.find(m => m < n || table.contains(m)).get)) table += n
}

println(table.size)
