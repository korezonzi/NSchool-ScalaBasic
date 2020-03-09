//注ぐ
trait Fillable {
  def fill(): Unit = {
    println("Fill...")
  }
}

//捨てる
trait Disposable {
  def dispose(): Unit = {
    println("Dispose...")
  }
}

class Paper

class PaperCup extends Paper with Fillable with Disposable {

}
