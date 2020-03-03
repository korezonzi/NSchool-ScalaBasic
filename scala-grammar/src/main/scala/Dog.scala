object Dog {
  def apply(name: String): Dog = new Dog(name)
  def apply(id: Int) = new Dog(s"番号つき犬${id}犬")
  def printerName(dog: Dog): Unit = {
    println(s"${dog.name}だわん")
  }
}

class Dog(private val name: String) {
  def greet(): Unit = println(s"My name is ${name}...")
}

//object Taro extends Dog("taro")