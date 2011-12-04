def cycle(n:Int, d:Int, mods:Array[Int] = Array[Int]()):Int = {
  val mod = n % d
  if (mod == 0) return 0
  val i = mods.indexOf(mod)
  if (i != -1) mods.size - i
  else cycle(mod * 10, d, mods :+ mod)
}

println((2 until 1000).maxBy(cycle(1, _)))
