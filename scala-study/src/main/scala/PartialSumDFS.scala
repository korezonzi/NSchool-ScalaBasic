object PartialSumDFS extends App {
  //a
  val numSeq = Seq(1,2,3,4,5,8)
  //n
  val numLen = numSeq.length
  //k
  val total = 7

  def isMatchAndResult(index: Int, partial: Seq[Int]): (Boolean, Seq[Int]) = {
    if(index == numLen) {
      return if(partial.sum == total) (true, partial)
      else (false, Seq.empty)
    }
    val (isMatchNotAdd, resultNotAdd) = isMatchAndResult(index + 1, partial)
    if(isMatchNotAdd) return (isMatchNotAdd, resultNotAdd)

    isMatchAndResult(index + 1 , partial :+ numSeq(index))
  }

  val (isMatch, result) = isMatchAndResult(0, Seq())
  if(isMatch) println(s"Yes ${result}")
  else println("No Result...")
}
