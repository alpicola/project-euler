import scala.io.Source

val source = Source.fromFile("sudoku.txt")
val digits = (1 to 9).toSet

println(source.getLines.grouped(10).map { lines =>
  val matrix = lines.drop(1).map(_.map(_.asDigit).toArray).toArray
  var answer = 0

  def investigate(offset:Int = 0) {
    if (offset == 80) answer = matrix(0).take(3).mkString.toInt
    if (answer != 0) return

    val x = offset % 9
    val y = offset / 9
    if (matrix(y)(x) == 0) {
      val row = matrix(y)
      val col = matrix.transpose.apply(x)
      val box = matrix.slice(y / 3 * 3, y / 3 * 3 + 3).flatMap {
        _.slice(x / 3 * 3, x / 3 * 3 + 3)
      }
      (digits -- row -- col -- box).foreach { d =>
        matrix(y)(x) = d
        investigate(offset + 1)
        matrix(y)(x) = 0
      }
    } else {
      investigate(offset + 1)
    }
  }

  investigate()
  answer
}.sum)

source.close
