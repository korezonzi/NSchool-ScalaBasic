//挑戦: ×
import scala.math.sqrt

object _03_Factorization extends App {
  var target = 24
  //平方根を産出(小数点は切り捨て)
  //ex)24 -> 4, 25 -> 5
  val maxDivisor = sqrt(target).toInt
  //divisor: 割る数, acc: 答え
  def factorizationRec(num: Int, divisor: Int, acc: Map[Int, Int]): Map[Int, Int] = {
    if(divisor > maxDivisor) {
      if(num == 1) acc
      else acc + (num -> 1)
    } else if(num % divisor == 0) {
      val nextAcc = acc + (divisor -> (acc.getOrElse(divisor,0) + 1))
      factorizationRec(num/ divisor, divisor, nextAcc)
    } else{
      factorizationRec(num, divisor+1, acc)
    }
  }
  println(factorizationRec(target, 2, Map()))
}
