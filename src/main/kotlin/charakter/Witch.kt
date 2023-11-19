package charakter

import Enemy
import Funktions.witchPoisenRounds

class Witch(
    override var name: String, override var healthPower: Int = 1500,
    override var damagePower: Int = 100
) : Enemy(name, healthPower, damagePower) {

    override var standartHP: Int = healthPower
    override val standartDP: Int = damagePower
    override var roots:Boolean=false
    override var cable: Boolean =false
    override var isDead: Boolean = false


    override fun fight(enemies: MutableList<Enemy>, heros: MutableList<Hero>) {
        if (healthPower>0) {
            var dice = (1..6).random()
            var randomHero = heros.random()
            var boss: Endboss? = null
            for (enemy in enemies) {
                if (enemy is Endboss)
                    boss = enemy
            }


            when (dice) {
                1 -> prayToTheBoss(boss!!)
                2 -> poisen(randomHero)
                3 -> powerToTheBadGuys(enemies)
                4 -> möllemann(heros)
                5 -> yoga()

            }
        }else
            println("$name wurde vor 500 Jahren schon einmal verbrannt, tot ist bei ihr nicht immer tot.... warten wir mal ab")
    }

    /**
     * Die Hexe betet Dajjal an, dieser wird dadurch stärker (also + damagePower) und bekommt HP+
     * schön wäre es, wenn er in der Zeit, wo die Hexe betet, auf Sie aufpasst und Schaden abwendet
     */
    fun prayToTheBoss(boss: Endboss): List<Int> {
        var rounds = (2..4).random()
        var plusDamage = (10..15).random()
        var plusHealth = (25..50).random()
        boss.damagePower += plusDamage
        boss.healthPower += plusHealth
        println("$name betet zu ${boss.name}")
        println()
        println("${boss.name} erhält $rounds lang $plusHealth Punkte Lebenskraft und $damagePower Punkte Schadenskraft")
        println()
        return listOf(rounds,plusHealth,plusDamage)
    }


    open fun poisen(hero: Hero) {

        if (hero.witchPoisen) {
            println("Die Hexe hat ${hero.name} nochmal angespuckt, das bringt aber nix mehr außer ekel")
            println()
            println("Oh doch , die Angriffskraft von ${hero.name} sinkt etwas")
            hero.damagePower -= 5
        } else {
            var rounds: Int = (2..4).random()
            var damage = (((hero.standartHP / 100) * (3..7).random()) / 100 * damagePower).toInt()
            if (damage > 10) {
                damage = 10
            }
            println(
                "$name hat ${hero.name} angespuckt, durch die letzten 500 Jahre mit nur wenig Zeit für Körperhygiene, und dem vielen verzweifelten Beischlaf mit Zombies \n" +
                        "(Jaaaa, auch Hexen haben Bedürfnisse) hat sich ihre Sabber in pures Gift verwandelt."
            )
            println()
            Thread.sleep(1500)
            println("Für $rounds werden $damage Lebenspunkte abgezogen")
            hero.healthPower -= damage
            hero.witchPoisen = true
            witchPoisenRounds = rounds - 1
        }
    }


    fun powerToTheBadGuys(enemys: MutableList<Enemy>) {

        for (enemy in enemys) {
            if (enemy.healthPower > 0) {
                var bonusPower = (10..20).random().toInt()
                enemy.damagePower += bonusPower
                println("Die Hexe hat durch einen Zauber, ${enemy.name} $bonusPower Punkte für die Schadenskraft gegeben")
                println()
                var bonusHP = (15..35).random()
                enemy.healthPower += bonusHP
                println("Außerdem hat ${enemy.name} noch $bonusHP Lebenspunkte erhalten, ne wat ne geile Sau die Agnes .... So schaffen es die bösen vielleicht endlich mal")
            }
        }

    }

    fun möllemann(heros: MutableList<Hero>) {
        var usedList: MutableList<Boolean> = mutableListOf(false, false, false, false)
        var randomHero = heros.random()
        var damage = (50..100).random()
        damage = (damage/100 * damagePower).toInt()

        println("Dieses kranke Weibsbild hat den Geist von Möllemann in die Köpfe der Flugzeugbesatzungen in der Nähe eingepflanzt.... ")
        if (randomHero.healthPower == 0)
            randomHero = heros.random()

        if (!usedList[0]) {

            println("Was ist das da am Himmel?")
            println()
            Thread.sleep(1500)
            println(" Oh mein Gott, da sind Fallschirmspringer die den Fallschirm nicht öffnen... sie sind genau über den Helden")
            println(
                "Einer ist fast genau auf $randomHero aufgeschlagen, er musste was tun und hat die Menschliche Bombe in der Luft zerfetzt, \n" +
                        "nichtsdestotrotz haben die Knochen und Gedärme unserem Helden $damage Schaden zugefügt "
            )
            usedList[0] = true
            randomHero.healthPower -= damage


        }else{
            if (!usedList[1]) {
                println("Man sollte meinen, das nicht so viele Flugzeuge beim Weltuntergang am Himmel sind, haben die Leute nix besseres vor? Familie oder so .... oooohhhhhh...")
                println()
                println("..während ich den Text geschrieben hab und du ihn gelesen hast, hat ein Fallschirmspringer wieder einen auf FDP gemacht.")
                println()
                Thread.sleep(1500)
                println("Er hat eine Hauswand durchschlagen und die Trümmer, gemischt mit breiartigen Menschenresten treffen einen unserer Helden")
                println("$randomHero hat $damagePower Schaden erlitten")
                usedList[1] = true
                randomHero.healthPower -= damage
            }else {
                if (!usedList[2]) {
                    println("Bei jedem Flugzeuggeräusch, zucken unsere Helden zusammen.... ")
                    println()
                    println("Tatsächlich, da ist ein kleines Sportflugzeug in unsere Heldengruppe gerauscht... ")
                    for (hero in heros) {
                        damage = (25..50).random()
                        hero.healthPower -= damage
                        println("${hero.name} hat $damage Schaden abbekommen")
                    }
                    usedList[2] = true
                } else{
                    if (!usedList[3]) {
                        println(" In der Zwischenzeit würde der Luftraum gesperrt aber wie du siehst ist ein kleines Flugzeug noch durch gekommen.")
                        println()
                        println(
                            "Schön , das es uns noch aufgefallen ist, ${randomHero.name} leider nicht, er wurde erwischt von der Pfütze da drüben. \n" +
                                    "natürlich war es nicht immer eine Pfütze, vor Sekunden noch war es ein Mensch "
                        )
                        println()
                        println("$damage Schaden für ${randomHero.name}")
                        println()
                        randomHero.healthPower -= damage
                        usedList[3] = true

                    }else {
                        println("Gut das der Luftraum gesperrt ist, die Hexe hat es schon wieder versucht")
                        println()
                    }
                }
            }
        }
        for (hero in heros){
            if (hero.healthPower <= 0) {
                println("Ich glaube, einer der Fallschirmspringer hat sich nach der Toilette nicht die Hände gewaschen.")
                println("${hero.name}'s verletzungen haben sich entzündet, das Spiel ist vorbei für unseren Helden")
                hero.healthPower = 0
                hero.isDead =true

            }

        }


    }

    fun yoga() {
        var plusHealth = healthPower / 100 * (5..9).random().toInt()
        var plusDamage = damagePower / 100

        println("Mitten in der Schlacht macht $name einfach Yoga")
        println()
        println("Aber es scheint zu wirken, $plusHealth Punkte für Ihre Gesundheit und $plusDamage für ihr Schadenskraft")

    }
}