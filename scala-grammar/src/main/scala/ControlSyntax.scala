object ControlSyntax {
  def main(args: Array[String]): Unit = {
    //println(printOver18(20))
    //println(doubleLoop())
    println(generateCollection())
  }

  def printOver18(age: Int): Unit = {
    val msg = {
      if(age >= 18) {
        "over 18"
      }else {
        "under 18"
      }
    }
    println(msg)
  }

  def doubleLoop(): Unit = {
    for(x <- 1 to 5;y <- 1 until 5 if x != y) {
      println(s"x=${x} + y=${y}")
    }
  }

  def generateCollection(): Seq[String] = {
    for(e <- Seq("A", "B", "C", "D")) yield "Pre" + e
  }
}
