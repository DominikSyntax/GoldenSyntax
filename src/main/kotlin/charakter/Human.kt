package charakter

import charakter.Hero

open class Human(override var name: String, override var healthPower: Int, override var damagePower: Int): Hero(name,healthPower,damagePower) {

    override var standartHP: Int = healthPower
    override val standartDP: Int = damagePower
    override var isDead: Boolean = false
    override var witchPoisen = false



}