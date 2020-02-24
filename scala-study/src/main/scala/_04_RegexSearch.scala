object _04_RegexSearch extends App {
  val text = "カワカドカドカドドワンゴカドカドンゴドワドワンゴドワカワカドンゴドワ"
  val pattern = "ドワンゴ"
  val matchIndex = pattern.r.findAllIn(text).matchData.map(_.start).toSeq
  println(matchIndex)
}
