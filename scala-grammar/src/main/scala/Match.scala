object Match {
  def main(args: Array[String]): Unit = {
    //println(patternMatchType())
    println(patternGenerics())
  }

  def patternMatchType(): Unit = {
    val obj: AnyRef = "String Literal"
    obj match {
      case v: java.lang.Integer => println("Integer")
      case v: String            => println(s"String length is ${v.length}")
    }
  }

  def patternGenerics(): Unit = {
    val obj: AnyRef = Seq("a", "b", "c")
    obj match {
      case v: Seq[_] => println("Seq[_]")
      case _         => println("nothing...")
    }
  }
}
