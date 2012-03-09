val N = 100000
val C = Array.fill(N)(0)

for (a <- 1 to N / 2;
     b <- 1 to (N / 2 / a).min(a);
     c <- 1 to ((N / 2 - a * b) / (a + b)).min(b)) {
  Iterator.from(0).scanLeft((a * b + b * c + c * a) * 2) { (r, i) =>
    r + (a + b + c) * 4 + i * 8
  }.takeWhile(N >).foreach(C(_) += 1)
}

println(C.indexOf(1000))
