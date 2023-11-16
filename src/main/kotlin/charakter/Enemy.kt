import charakter.*

open class Enemy(override var name: String, override var healthPower: Int = 2000, override var damagePower: Int = 100) :
    OverCharakter(name, healthPower, damagePower) {


    override var standartHP: Int = healthPower
    override var isDead: Boolean = false

    open var endbossFluch = false
    open var roots = false
    open var cable = false


    open fun fight(enemies: MutableList<Enemy>, heros: MutableList<Hero>) {}
}


