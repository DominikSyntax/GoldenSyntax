package charakter

import Bag
import evilChoice

open class Hero(open var name: String = String(), open var healthPower: Int = 1000, open var damagePower: Int = 100) {
    open var isDead: Boolean = false
    open val standartHP = 1000
    open var usedTankChocolade = false
    open var nanoAreUsed = false
    open  var otherHeroHaveNanos =false
    open var endbossFluch = false



    open fun printInfo(){
        println("Mit $name,  ...")
    }



    open fun attack(bag: Bag, int: Int, enemies: MutableList<Enemy>, heros: MutableList<Hero>) {

        when (int) {
            1 -> punch(evilChoice(enemies))
            2 -> kick(evilChoice(enemies))

        }

    }


    open fun printAllFunktion(bag: Bag) {
        println(
            "1 -> Schlagen  \n" +
                    "2 -> Treten "
        )

    }

    open fun punch(enemy: Enemy) {
        var abzug =enemy.standartHP/100 * (5..7).random()
        enemy.healthPower -= abzug
        println("${enemy.name} wurden durch den Schlag von $name $abzug Lebenspunkte abgezogen")
    }

    open fun kick(enemy: Enemy) {
        var abzug = enemy.standartHP/100 * (7..9).random()
        enemy.healthPower -= abzug
        println("${enemy.name} wurden durch den Tritt von $name $abzug Lebenspunkte abgezogen")
    }

}