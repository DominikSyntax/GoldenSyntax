package charakter

class Endboss(
    override var name: String = "Dajjal",
    override var healthPower: Int = 3000,
    override var damagePower: Int = 100
) : Enemy(name, healthPower, damagePower) {


    override var isDead: Boolean = false
    var helperIsUsed: Boolean = false
    var armeIsUsed: Boolean = false
    override val standartHP: Int = healthPower



    override fun fight(enemies: MutableList<Enemy>, heros: MutableList<Hero>){
        val list = mutableListOf(1, 2, 3, 4, 5, 6)


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

    }


    /**
     * Verursacht Flächenschaden, d.h. trifft alle Helden gleichzeitig
     * @param MutableList<charakter.Hero>
     */
    fun sandStorm(heros: MutableList<Hero>) {
        println("$name hat einen Sandsturm ausgelöst")
        for (hero in heros) {
            var damage = (50..100).random()
            println("${hero.name} hat durch den Sandsturm $damage Schaden erlitten")
            hero.healthPower -= damage
        }
    }


    /**
     * Trifft nur einen Helden, pro Runde die HP des Helden -10 %, solange bis die HP <= 20 % der Standart HP ist (also 200)
     */
    fun selfAttack(hero: Hero) {
        var twentyPercent = hero.standartHP / 100 * 20
        println("Dajjal's Zauber wirkt auf ${hero.name}")
        while (hero.healthPower >= twentyPercent) {
            var damage: Int
            damage = (hero.standartHP/100 * 10).toInt()
            hero.healthPower -= damage
            println("${name}'s Zauber hat ${hero.name} $damage Schaden von den HP abgezogen")
        }

    }


    /**
     * Ruft den UnderBoss zur Hilfe (geht nur 1 x im Spiel)
     */
    fun underBoss(list: MutableList<Enemy>){
        var witch: Witch = Witch("Agnes Waterhouse")
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


