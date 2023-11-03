class Endboss(override var name: String ="Dajjal", override var healthPower: Int=3000, override var damagePower: Int=100):Enemy(name,healthPower,damagePower) {


    override var isDead: Boolean = false
    var helperIsUsed:Boolean = false
    var armeIsUsed:Boolean = false
    override val standartHP: Int = 3000

    override fun fight(boss: Endboss, enemies: MutableList<Enemy>, heros: MutableSet<Hero>) {
        val list = mutableListOf(1, 2, 3, 4, 5, 6,)

        if (helperIsUsed) {
            list.remove(3)
        }
        if (armeIsUsed) {
            list.remove(4)
        }

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
     * @param MutableList<Hero>
     */
    fun sandStorm(heros: MutableSet<Hero>) {
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
        var twentyPercent = hero.standartHP/100 *20
        println("Dajjal's Zauber wirkt auf ${hero.name}")
        if (hero.healthPower >= twentyPercent) {
            var damage:Int
            damage = (hero.healthPower * 0.9).toInt()
            println("${name}'s Zauber hat ${hero.name} $damage Schaden von den HP abgezogen")
        }
    }


    /**
     * Ruft den UnderBoss zur Hilfe (geht nur 1 x im Spiel)
     */
    fun underBoss(list: MutableList<Enemy>) {
        var witch = Witch("Agnes Waterhouse")
        list.add(witch)
        helperIsUsed = true

        }



    /**
     *DAJJAL beschört die Untoten, es werden zwischen 4 und 10 Zombies der Gergnerliste hinzugefügt
     */
    fun armeOfDead(list: MutableList<Enemy>) {

        // add zwischen 4 oder 10 Untote zur MutableList<Enemy>
        var listOfAllUndead:MutableList<Undead> = mutableListOf(
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

        repeat(armeInt) {
            var zombie= listOfAllUndead.random()
            list.add(zombie)
            listOfAllUndead.remove(zombie)
        }
        armeIsUsed = true
    }


    fun shield(enemy: Enemy) {
        enemy.healthPower += 100
    }

    fun strongDamage(enemy: Enemy) {
        enemy.damagePower += (enemy.damagePower/100 * 12)
    }
}


