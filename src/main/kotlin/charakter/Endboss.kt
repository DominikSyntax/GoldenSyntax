package charakter

import Enemy
import charakter.*


final class Endboss(override var name: String = "Dajjal", override var healthPower: Int = 3000, override var damagePower: Int = 100):Enemy(name,healthPower,damagePower) {


    override var isDead: Boolean = false
    open var helperIsUsed: Boolean = false
    open var armeIsUsed: Boolean = false
    override var standartHP: Int = healthPower
    override val standartDP: Int = damagePower
    override var roots = false
    override var cable: Boolean =false



    override fun fight(enemies: MutableList<Enemy>, heros: MutableList<Hero>){
        val list = mutableListOf(1, 2, 3, 4, 5, 6)
        if (healthPower>0) {
            var dice = list.random()
            var randomHero = heros.random()

            when (dice) {
                1 -> sandStorm(heros)
                2 -> selfAttack(randomHero)
                3 -> underBoss(enemies)
                4 -> armeOfDead(enemies)
                5 -> strongDamage(enemies.random())
                6 -> shield(enemies.random())
            }
        }else
            println("Schau mal, hat sich die Leiche von $name nochmal bewegt? Oder dahinten, ich glaube die Stückchen gehören auch noch zu $name ")

    }


    /**
     * Verursacht Flächenschaden, d.h. trifft alle Helden gleichzeitig
     * @param MutableList<charakter.Hero>
     */
    fun sandStorm(heros: MutableList<Hero>) {
        println("$name hat einen Sandsturm ausgelöst")
        for (hero in heros) {
            var damage = (50..100).random()
            damage = ((damage/100)*damagePower).toInt()
            println("${hero.name} hat durch den Sandsturm $damage Schaden erlitten")
            hero.healthPower -= damage
        }
    }


    /**
     * Trifft nur einen Helden, pro Runde die HP des Helden -10 %, solange bis die HP <= 20 % der Standart HP ist (also 200)
     */
    fun selfAttack(hero: Hero) {
        if (hero.endbossFluch){
            println("Der Fluch der Selbstzerstörung ist bereits genutzt")
        }else {
            hero.endbossFluch = true
        }

    }


    /**
     * Ruft den UnderBoss zur Hilfe (geht nur 1 x im Spiel)
     */
    fun underBoss(list: MutableList<Enemy>){
        val witch: Witch = Witch("Agnes Waterhouse")

        if (!helperIsUsed) {
            list += witch
            helperIsUsed = true
            println("$name hat ${witch.name} beschworen, Sie hilft Ihm jetzt im Kampf gegen das Gute ")
        }else{
            println("$name ist etwas vergesslich, er wollte die hexe nochmal beschwören. Das geht natürlich nicht aber ihre Lebensenergie steigt um 15 % ")
            var bonus = (witch.healthPower/100 * 15).toInt()

        }

    }


    /**
     *DAJJAL beschört die Untoten, es werden zwischen 4 und 10 Zombies der Gergnerliste hinzugefügt
     */
    fun armeOfDead(list: MutableList<Enemy>){

        // add zwischen 4 oder 10 Untote zur MutableList<charakter.Enemy>
        var listOfAllUndead: MutableList<Undead> = mutableListOf(
            Undead("ZombieOne"),
            Undead("ZombieTwo"),
            Undead("ZombieTree"),
            Undead("ZombieFour"),
            Undead("ZombieFive"),
            Undead("ZombieSix"),
            Undead("ZombieSeven"),
            Undead("ZombieEight"),
            Undead("ZombieNine"),
            Undead("ZombieTen")
        )
        var armeInt: Int = (4..10).random()
        var listOfZombies:MutableList<Undead> = mutableListOf()
        if (!armeIsUsed) {
            repeat(armeInt) {
                var zombie = listOfAllUndead.random()
                listOfZombies.add(zombie)
                listOfAllUndead.remove(zombie)
                println("$name hat ${zombie.name} zum leben erweckt, die Guten haben also einen neuen Gegner")
            }
            armeIsUsed = true
            list += listOfZombies
        }else{
            println("Die Untoten wurden schon beschworen, glück gehabt")
        }


    }


    fun shield(enemy: Enemy) {
        enemy.healthPower += 100
        println("$name hat seine Lebenspunkte um 100 erhöht")
    }

    fun strongDamage(enemy: Enemy) {
        enemy.damagePower += (enemy.damagePower / 100 * 12)
        println("$name hat seine Schadenskraft um 12 % erhöht")
    }
}


