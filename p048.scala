val m = BigInt("10000000000")

println((1 to 1000).view.map(n => BigInt(n).modPow(n, m)).sum.mod(m))
