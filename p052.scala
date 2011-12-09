println(Iterator.from(1).find { n =>
 val set = n.toString.toSet
 (2 to 6).forall(m => (n * m).toString.toSet == set)
}.get)
