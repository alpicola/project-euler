println((1 to 9999).view.flatMap { n =>
  Iterator.from(1).scanLeft("") { (s, i) =>
    s ++ (n * i).toString
  }.takeWhile(_.size <= 9).find(_.size == 9)
}.filter(_.sorted == "123456789").map(_.toInt).max)
