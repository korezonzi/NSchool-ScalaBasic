import java.util.Random

object RPG extends App {
  val random       = new Random()
  val monsterCount = 5
  val hero         = new Hero(200, 30)
  var monsters     = for(i <- 1 to monsterCount)yield {
    new Monster(random.nextInt(120), random.nextInt(120), false)
  }
  println(
    s"""あなたは冒険中の ${hero} であり、
       |${monsterCount}匹のモンスターが潜んでいる洞窟を抜けねばならない。
       |【ルール】:
       |1を入力してEnterキーを押すと攻撃、それ以外を入力すると逃走となる。
       |逃走成功確率は50%。逃走に失敗した場合はダメージをうける。
       |一度でもダメージを受けるとモンスターの体力と攻撃力が判明する。
       |またモンスターを倒した場合、武器を奪いその攻撃力を得ることできる。
       |---------------------------------------------
       |未知のモンスターがあらわれた。""".stripMargin)

  while (!monsters.isEmpty) {
    val monster = monsters.head
    val input   = scala.io.StdIn.readLine("[選択]: 攻撃[1] or 逃走[0]>")

    //攻撃する
    if(input == "1") {
      hero.attack(monster)
      println(s"あなたは${hero.attackDamage}のダメージを与え、${monster.attackDamage}のダメージを受けた。")
    //逃走する
    } else {
      if(hero.escape(monster)) {
        println("あなたは、モンスターからの逃走に成功した")
      }else {
        println(s"あなたはモンスターからの逃走に失敗し、${monster.attackDamage} のダメージを受けた")
      }
    }
    println(s"[現在の状態]: ${hero}, ${monster}")

    //ヒーローの生存判定
    if(!hero.isAlive) {
      println(
        """---------------------------------------------
          |【ゲームオーバー】: あなたは無残にも殺されてしまった。 """.stripMargin)
      System.exit(0)
    //モンスターがいない時
    } else if(!monster.isAlive || monster.isAwayFromHero) {
      //倒した時
      if(!monster.isAwayFromHero) {
        println("モンスターは倒れた。そして、あなたは、モンスターの武器を奪った")
        if(monster.attackDamage > hero.attackDamage) hero.attackDamage = monster.attackDamage
      }
      monsters = monsters.tail
      println(s"残りのモンスターの数は、${monsters.length}匹になった")
      if(monsters.nonEmpty) {
        println(
          """---------------------------------------------
            |新たな未知のモンスターがあらわれた。 """.stripMargin)
      }
    }
  }
  println(
    s"""---------------------------------------------
    |【ゲームクリア】: あなたは困難を乗り越えた。新たな冒険に祝福を。
    |【結果】: ${hero}""".stripMargin
  )
  System.exit(0)

  abstract class Creature(var HP: Int, var attackDamage: Int) {
    def isAlive: Boolean = this.HP > 0
  }

  class Hero(_HP: Int, _attackDamage: Int) extends Creature(_HP, _attackDamage) {
    def attack(monster: Monster): Unit = {
      monster.HP = monster.HP - this.attackDamage
      this.HP = this.HP - monster.attackDamage
    }
    def escape(monster: Monster): Boolean = {
      val isEscaped = RPG.random.nextInt(2) == 1
      if(!isEscaped) {
        this.HP = this.HP - monster.attackDamage
      } else {
        monster.isAwayFromHero = true
      }
      isEscaped
    }

    override def toString: String = s"Hero(体力: ${HP}, 攻撃力: ${attackDamage})"
  }

  class Monster(_HP: Int, _attackDamage: Int, var isAwayFromHero: Boolean) extends Creature(_HP, _attackDamage) {
    override def toString: String = s"Monster(体力: ${HP}, 攻撃力: ${attackDamage}, ヒーロから離れている: ${isAwayFromHero})"
  }
}
