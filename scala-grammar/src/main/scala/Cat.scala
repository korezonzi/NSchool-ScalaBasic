object Cat{
  def main(args: Array[String]): Unit = {
    //println()
    val cat = new Cat("ぽち")
    cat.greet()
    //println(cat)
  }

  class Cat(val name: String) {
    def greet(): Unit = {
      println(s"Cat's name is....${name}")
    }
  }
}
