class Cat(name: String) {
  def main(args: Array[String]): Unit = {
    println(greet("ぽち"))
  }

  def greet(name: String): Unit = {
    println(s"Cat's name is....${name}")
  }
}
