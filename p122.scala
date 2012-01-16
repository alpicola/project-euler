def m(k:Int, min:Int, ns:List[Int] = List(1)):Int = {
  if (min <= ns.size) return min
  val muls = ns.flatMap(n => ns.map(n +).dropWhile(k <).takeWhile(ns.head <)).distinct
  if (muls.contains(k)) ns.size
  else muls.foldLeft(min)((min, n) => m(k, n :: ns, min).min(min))
}

println((2 to 200).map(k => m(k, k)).sum)
