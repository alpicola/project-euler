def gcd(a:Int, b:Int):Int = if (b == 0) a else gcd(b, a % b)
def lcm(a:Int, b:Int) = a / gcd(a, b) * b

println((1 to 20).reduceLeft(lcm))
