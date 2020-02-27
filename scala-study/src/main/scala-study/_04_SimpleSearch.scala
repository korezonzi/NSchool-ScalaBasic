//挑戦: 初級,中級
object _04_SimpleSearch extends App {
  val text = "カワカドカドカドドワンゴカドカドンゴドワドワンゴドワカワカドンゴドワ".toSeq
  val pattern = "ドワンゴ".toSeq

  def search(text: Seq[Char], pattern: Seq[Char]): Seq[Int] = {
    var matchIndexes: Seq[Int] = Seq.empty
    for(i <- 0 until text.length) {
      val partText = text.slice(i, i+ pattern.length)
      //該当するIndexを追加していく
      if(isMatch(partText, pattern)) matchIndexes = matchIndexes :+ i
    }
    matchIndexes
  }

  def isMatch(textPart: Seq[Char], pattern: Seq[Char]): Boolean = {
    var isMatch = true
    for(i <- 0 until pattern.length) {
      if(textPart.length < pattern.length || textPart(i) != pattern(i)) isMatch = false
    }
    isMatch
  }
  val matchIndexes = search(text, pattern)
  println(s"出現場所: ${matchIndexes}")
}
