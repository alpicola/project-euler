val units = """ one two three four five six seven eight nine ten eleven twelve
thirteen fourteen fifteen sixteen seventeen eighteen nineteen""".split("\\s")
val tens = """  twenty thirty forty fifty sixty seventy eighty ninety""".split(" ")

lazy val name:Int => String = {
  case n if (n < 20) => units(n)
  case n if (n < 100) => tens(n / 10) ++ units(n % 10)
  case n if (n < 1000) => units(n / 100) ++ "hundred" ++
    (if (n % 100 > 0) "and" ++ name(n % 100) else "")
  case 1000 => "onethousand"
}

println((1 to 1000).map(name(_).size).sum)
