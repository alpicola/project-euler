import scala.collection.mutable.BitSet

val N = 10000000
val table = new BitSet(N)
table += 89

(2 until N).foreach { n =>
  if (table.contains(Iterator.iterate(n) { m =>
    m.toString.view.map(c => c.asDigit * c.asDigit).sum
  }.find(m => m < n || table.contains(m)).get)) table += n
}

println(table.size)
