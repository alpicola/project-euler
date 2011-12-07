class PrimeSet(N:Int) extends Iterable[Int] {
  import java.util.BitSet

  var sieved = 1
  private val flags = new BitSet()
  flags.flip(2, N)

  private def square(n:Int) = BigInt(n).pow(2)

  private def from(n:Int) = new Iterator[Int] {
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

  def contains(n:Int) = {
    if (sieved < N && square(sieved) < n) {
      val sqrt = math.sqrt(n)
      from(sieved).dropWhile(sqrt >).next
    }
    flags.get(n)
  }

  def iterator = from(2)

  override def toString = {
    if (square(sieved) > N)
      "PrimeSet(" ++ from(2).mkString(",") ++ ")"
    else
      "PrimeSet(" ++ from(2).takeWhile(sieved >=).mkString(",") ++ "..)"
  }
}
