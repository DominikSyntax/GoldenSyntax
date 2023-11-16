package charakter

import Bag
import Enemy
import GREEN_TEXT
import STANDARTCOLOR
import WHITE_BACKGROUND
import cableCounter
import evilChoice

/**
 * Die Heldin Gaia ist ein Natur-Mutant, das bedeutet, Sie hat die Kraft, alles was mit der Natur zu tun hat, zu beeinflussen.
 * Wind, Pflanzen und sogar die Erde selbst hören auf Sie.
 */
class NatureMutant(
    override var name: String = "GAIA",
    override var healthPower: Int = 1000,
    override var damagePower: Int = 100,

    ) : Hero(name, healthPower, damagePower) {

    override var isDead: Boolean =
        if (healthPower <= 0) {
            true
        } else {
            false
        }

    override var nanoAreUsed = false
    override var otherHeroHaveNanos =false
    override var endbossFluch: Boolean = false
    override var standartHP: Int = healthPower

    override fun printInfo(){
        println("""
            $GREEN_TEXT
              ________     _____    .___     _____   
             /  _____/    /  _  \   |   |   /  _  \  
            /   \  ___   /  /_\  \  |   |  /  /_\  \ 
            \    \_\  \ /    |    \ |   | /    |    \
             \______  / \____|__  / |___| \____|__  /
                      
                                                                                                                                                         
 ____                                                  ___      __    __                  __  __            __                           
/\  _`\                                              /'___\    /\ \__/\ \                /\ \/\ \          /\ \__                        
\ \ \L\ \___   __  __  __     __   _ __         ___ /\ \__/    \ \ ,_\ \ \___      __    \ \ `\\ \     __  \ \ ,_\  __  __  _ __    __   
 \ \ ,__/ __`\/\ \/\ \/\ \  /'__`\/\`'__\      / __`\ \ ,__\    \ \ \/\ \  _ `\  /'__`\   \ \ , ` \  /'__`\ \ \ \/ /\ \/\ \/\`'__\/'__`\ 
  \ \ \/\ \L\ \ \ \_/ \_/ \/\  __/\ \ \/      /\ \L\ \ \ \_/     \ \ \_\ \ \ \ \/\  __/    \ \ \`\ \/\ \L\.\_\ \ \_\ \ \_\ \ \ \//\  __/ 
   \ \_\ \____/\ \___x___/'\ \____\\ \_\      \ \____/\ \_\       \ \__\\ \_\ \_\ \____\    \ \_\ \_\ \__/.\_\\ \__\\ \____/\ \_\\ \____\
    \/_/\/___/  \/__//__/   \/____/ \/_/       \/___/  \/_/        \/__/ \/_/\/_/\/____/     \/_/\/_/\/__/\/_/ \/__/ \/___/  \/_/ \/____/
        $STANDARTCOLOR""".trimIndent())
        super.printInfo()
        println("... eine Mutantin, die wie Ihr Name schon erahnen lässt, die Macht über die Natur hat  ")
    }
    override fun printAllFunktion(bag: Bag) {
        if (bag.bagIsUsed){
            println(
                "1 -> Schlagen \n" +
                        "2 -> Treten \n" +
                        "3 -> Gewittersturm \n" +
                        "4 -> Giftwurzeln  \n" +
                        "5 -> Teamheilung \n")

        }else {
            println(
                "1 -> Schlagen \n" +
                        "2 -> Treten \n" +
                        "3 -> Gewittersturm \n" +
                        "4 -> Giftwurzeln  \n" +
                        "5 -> Teamheilung \n" +
                        "6 -> Rucksack benutzen"
            )
        }
    }


    override fun attack(bag: Bag, int: Int, enemies: MutableList<Enemy>, heros: MutableList<Hero>){
        if (bag.bagIsUsed){
            when (int) {
                1 -> punch(evilChoice(enemies))
                2 -> kick(evilChoice(enemies))
                3 -> thunderStorm(enemies)
                4 -> poisonRoots(evilChoice(enemies))
                5 -> healing(heros)
                else -> println("Die Attackenauswahl war nicht gültig")
            }
        }else {
            when (int) {
                1 -> punch(evilChoice(enemies))
                2 -> kick(evilChoice(enemies))
                3 -> thunderStorm(enemies)
                4 -> poisonRoots(evilChoice(enemies))
                5 -> healing(heros)
                6 -> bag.useBag(heros)
                else -> println("Die Attackenauswahl war nicht gültig")
            }
        }

    }



    /**
     * Die Methode thunderStorm soll zwischen 1 und 3 Blitze auf den Gegner schleudern
     * @param enemy
     * @return enemy.healthPower
     */
    fun thunderStorm(enemies: MutableList<Enemy>) {
        for (enemy in enemies) {
            if (enemy.healthPower > 0) {
                println("Es ziehen dunkle Wolken auf ...")
                var shocksInt = (1..3).random()
                var abzug = (25..50).random()
                abzug == abzug/100 * damagePower

                repeat(shocksInt) {
                    if (enemy.healthPower >= abzug) {
                        println("Ein Blitz hat ${enemy.name} getroffen, $abzug Punkte wurden von seiner HP abgezogen")
                        enemy.healthPower -= abzug
                    } else {
                        println("Die Blitze haben Ihm den Rest gegeben")
                        println("${enemy.name} hat keine Lebensenergie mehr")
                        enemy.healthPower = 0
                        enemy.isDead =true
                    }
                }
            } else
                println("Die Leiche von ${enemy.name} hat Glück, Tote ziehen keine Blitze an ")
        }
    }


    /**
     * Die Methode Gift Wurzeln, schränkt die Bewegung des Gegners ein, er hat nur die Möglichkeit, sich zu befreien, zu heilen oder einen gegenangriff zu starten, der aber nur 50 % seiner normalen Stärke hat.
     * Zusätzlich verursacht diese Methode zwischen 3 und 5 Runden einen Gift-Schaden von je 7 % Lebensenergie.
     *@param enemy
     */
    fun poisonRoots(enemy: Enemy) {
        var randomRounds = (3..5).random()
        if (!enemy.roots){
            println("Die Erde bebt und reist überall auf, unzählige Wurzeln kommen aus der Erde. Von Oberschenkel dicken, bis zu Haarfeinen ist alles dabei... ")
            enemy.roots = true
            cableCounter = randomRounds
        }

    }

    /**
     *Heilt die ganze Truppe
     */
    fun healing(heros: MutableList<Hero>) {
        for (hero in heros) {
            var helthInt: Int = hero.standartHP / 100 * (7..10).random().toInt()
            hero.healthPower += helthInt
            println("${hero.name} wurden die Lebenmspunkte um $helthInt erhöht")
        }

    }
}