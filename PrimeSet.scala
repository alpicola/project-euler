class PrimeSet(N:Int) extends Iterable[Int] {
  import java.util.BitSet

  private var sieved = 1
  private val flags = new BitSet()
  flags.set(2, N)

  private def square(n:Int) = BigInt(n).pow(2)

  def from(n:Int):Iterator[Int] = {
    if (n > sieved) from(sieved).dropWhile(n >)
    else new Iterator[Int] {
      private var p = flags.nextSetBit(n)
      def hasNext = p != -1
      def next = {
        val q = p
        if (q > sieved) {
          if (square(q) <= N) {
            (q * q to N by q).foreach(flags.clear(_))
            sieved = q
          } else {
            sieved = N
          }
        }
        p = flags.nextSetBit(p+1)
        q
      }
    }
  }

  def contains(n:Int) = {
    if (sieved < N && square(sieved) < n) {
      val sqrt = math.sqrt(n)
      from(sieved).dropWhile(sqrt >).next
    }
    flags.get(n)
  }

  def iterator = from(2)

  override def toString = {
    if (sieved < N)
      "PrimeSet(" ++ takeWhile(sieved >=).mkString(",") ++ "..)"
    else
      "PrimeSet(" ++ mkString(",") ++ ")"
  }
}
