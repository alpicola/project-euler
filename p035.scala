import java.util.BitSet

class PrimeSet(N:Int) extends Iterable[Int] {
  private var sieved = 1
  private val bits = new BitSet()
  bits.flip(2, N)

  private def square(n:Int):BigInt = BigInt(n).pow(2)

  private def from(n:Int) = new Iterator[Int] {
    private var p = bits.nextSetBit(n)
    def hasNext:Boolean = p != -1
    def next:Int = {
      val q = p
      p = bits.nextSetBit(p+1)
      if (q > sieved) {
        if (square(q) <= N) {
          (q * q to N by q).foreach(bits.clear(_))
          sieved = q
        } else {
          sieved = N
        }
      }
      q
    }
  }

  def contains(n:Int) = {
    if (sieved < N && square(sieved) < n) {
      val sqrt = math.sqrt(n)
      from(sieved).dropWhile(sqrt >).next
    }
    bits.get(n)
  }

  def iterator = from(2)

  override def toString = {
    if (square(sieved) > N)
      "PrimeSet(" ++ from(2).mkString(",") ++ ")"
    else
      "PrimeSet(" ++ from(2).takeWhile(sieved >=).mkString(",") ++ "..)"
  }
}

val primes = new PrimeSet(1000000)
var circulars = Set[Int]()
primes.foreach { p =>
  if (!circulars.contains(p)) {
    val s = p.toString.size
    val ps = (1 to s).scanLeft(p) { (n, _) =>
      n / 10 + (n % 10) * math.pow(10, s-1).toInt
    }.tail.toSet
    if (ps.forall(primes.contains(_))) circulars ++= (ps + p)
  }
}

println(circulars.size)
