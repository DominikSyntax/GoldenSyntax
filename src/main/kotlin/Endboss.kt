class Endboss(override var name: String, override var healthPower: Int=3000, override var damagePower: Int=100):Enemy(name,healthPower,damagePower) {


    /**
     * Verursacht Flächenschaden, d.h. trifft alle Helden gleichzeitig
     * @param MutableList<Hero>
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
    fun selfAttack(hero: Hero) {                                                // Alle Personenklassen brauchen noch eine val standartHP für genau sowas
        println("Dajjal's Zauber wirkt auf ${hero.name}")
        if (hero.healthPower >= 200) {
            var damage = 0
            damage = (hero.healthPower * 0.9).toInt()
            println("${name}'s Zauber hat ${hero.name} $damage Schaden von den HP abgezogen")
        }
    }


    /**
     * Ruft den UnderBoss zur Hilfe (geht nur 1 x im Spiel)
     */
    fun underBoss(list: MutableList<Enemy>) {
        var witch = Witch("Agnes Waterhouse")
        if (list.contains(Witch())){
            println("$name hat versucht noch eine Hexe zu beschören, das ging zum Glück daneben...")
        }else {
            println("$name hat die Hexe ${witch.name} herbei gerufen")
            list.add(witch)
        }
    }


    /**
     *DAJJAL beschört die Untoten, es werden zwischen 4 und 10 Zombies der Gergnerliste hinzugefügt
     */
    fun armeOfDead(list: MutableList<Enemy>) {
        // add zwischen 4 oder 10 Untote zur MutableList<Enemy>
        var listOfAllUndead = listOf(
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
            list.add(listOfAllUndead.first())
        }
    }

    fun shield(enemy: Enemy) {
        enemy.healthPower += 100
    }

    fun strongDamage(enemy: Enemy) {
        enemy.damagePower += (enemy.damagePower/100 * 12)
    }
}


