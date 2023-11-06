
open class Enemy(open var name:String = String(),open var healthPower:Int = 1000, open var damagePower:Int = 100) {


    open var isDead: Boolean = false
    open val standartHP: Int = 1000




    open fun fight(enemies: MutableList<Enemy>, heros: MutableList<Hero>) {}
}


