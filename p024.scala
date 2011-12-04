def fact(n:Int):Int = (1 to n).product
def divmod(x:Int, y:Int) = (x / y, x % y)

val nums = 0 to 9
def nth(n:Int, perm:Array[Int] = Array[Int]()):Array[Int] = {
  if (perm.size == nums.size) return perm
  val m = if (perm.size == 0) n - 1 else n
  val (div, mod) = divmod(m, fact(nums.size - perm.size - 1))
  nth(mod, perm :+ (nums.diff(perm))(div))
}

println(nth(1000000).mkString)
