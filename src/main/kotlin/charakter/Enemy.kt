import charakter.*

open class Enemy(open var name: String, open var healthPower: Int = 2000, open var damagePower: Int = 100){

    open var standartHP = healthPower
    open var isDead: Boolean = false






    open fun fight(enemies: MutableList<Enemy>, heros: MutableList<Hero>) {}
}


