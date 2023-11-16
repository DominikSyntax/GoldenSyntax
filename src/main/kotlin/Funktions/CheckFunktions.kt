package Funktions

import Enemy
import cableCounter
import charakter.Hero
import gaiaHero
import rootCounter
import tekkHero

fun allGoodsAreDead(heros: MutableList<Hero>): Boolean {
    var allDead = false

    for (hero in heros) {
        if (hero.isDead || hero.healthPower <= 0) {
            hero.isDead = true
        }
    }

    if (heros.all { it.isDead }) {
        allDead = true
    }
    return allDead


}

fun allBadsAreDead(enemies: MutableList<Enemy>): Boolean {
    var allEnemyDead = false

    for (e in enemies) {
        if (e.isDead || e.healthPower <= 0) {
            e.isDead = true
        }
    }

    if (enemies.all { it.isDead }) {
        allEnemyDead = true
    }
    return allEnemyDead

}

/**
 * Überprüft ob NanoBots aktiviert sind, falls ja und der Held ist noch am leben , bekommt er 5% seiner StandartHP zurück
 * @param hero
 */
fun botsAreGreat(hero: Hero) {
    if (hero.nanoAreUsed) {
        if (hero.healthPower > 0) {
            var healing = hero.standartHP / 100 * 5
            hero.healthPower += healing
            println("$BLUE_TEXT Die NanoBots haben ${hero.name} um $healing Lebenspunkte geheilt")
            newLine()
        }
    }
}

fun rootsOrCable(enemy: Enemy) {

    if (enemy.roots) {
        if (enemy.healthPower > 0) {
            var abzug: Int = (7..25).random()
            abzug = (abzug / 100 * gaiaHero.damagePower).toInt()
            if (abzug > 10) {
                abzug = 10
            }
            var damageMinus = (1..5).random()
            println()

            println("Die Wurzeln haben ${enemy.name} fest im Giff. Für $rootCounter Runden werden Lebenspunkte abgezogen und die Angriffskraft sinkt etwas")
            if (enemy.healthPower >= abzug) {
                enemy.healthPower -= abzug
            } else {
                println("Das war wohl zuviel des guten Stoffs, die Wurzeln haben alle Lebenspunkte zurück zu Mutter Natur geführt")
                println("Die Wurzeln lösen ${enemy.name} langsam auf, Asche zu Asche und Gehirnmasse zu Gehirnmasse")
                enemy.healthPower = 0
                enemy.isDead = true
            }
        }
        rootCounter--
        println()
    }
    if (enemy.cable) {
        var deduction: Int = (7..25).random()
        deduction = (deduction / 100 * tekkHero.damagePower).toInt()

        var deductionTwo = (25..50).random()
        deductionTwo = (deductionTwo / 100 * tekkHero.damagePower).toInt()

        var smallOrBig = listOf(deduction, deductionTwo)
        var abzug = smallOrBig.random()
        if (enemy.healthPower > 0) {

            if (enemy.healthPower > abzug) {
                enemy.healthPower -= abzug

                if (abzug <= 10) {
                    println("Das war nicht mehr als ein prickeln auf ${enemy.name}'s Haut, du sollst ihn nicht zu Tode langweilen ")
                    println("$abzug Lebenspunkte abzug für ${enemy.name}")
                } else if ((abzug > 11) && (abzug < 25)) {
                    println(
                        "Schon besser, es kommt mir zwar noch immer so vor als hättest du lieber eine Beziehung zu ${enemy.name}, als seinen Kopf von seinem Körper zu trennen. \n" +
                                "Aber Hey , jedem das seine. Wo die liebe hinfällt"
                    )
                    println("$abzug Lebenspunkte abzug für ${enemy.name}")
                } else {
                    println(".. oh, da war wohl ein Starkstromkabel mit dabei. ${enemy.name} hat $abzug Punkte Lebenskraft abgezogen")
                }
            } else {
                println(".. oh, das war wohl ein Starkstromkabel zuviel ${enemy.name} ist in Rauch aufgegangen. ")
                enemy.damagePower = 0
                enemy.isDead
            }
        } else
            println(
                "Einem Haufen undefinierbarer Matsche machen die Stromschläge fast nix aus, hier und da zuckt noch ein Muskel aufgrund der Spannung.\n" +
                        "Aber keine Sorge, von Wackelpudding, mit Knochen- und Hirnstückchen auf Blut und Kotsoße geht keine Gefahr aus, auser auszurutschen oder sich mit komischen Dingen anzustecken.  "
            )

    }
    cableCounter--
    newLine()
}


/**
 * Funktion zum Überprüfen, ob der Fluch des Endgegners aktiv ist und falls ja, werden dem Helden 10 % seiner Lebensenergie abgezogen.
 * Bis dieser nur noch 20 % über hat
 * @param heros = Dein Team von Helden
 */
fun isCursed(hero: Hero) {

    var twentyPercent = hero.standartHP / 100 * 20

    if (hero.endbossFluch && hero.healthPower > twentyPercent) {
        println("Dajjal's Fluch, hat eine Autoimmunkrankheit bei  ${hero.name} ausgelöst. ${hero.name}'s Körper Kämpft gegen sich selbst ")

        var abzug = hero.healthPower / 100 * 10
        hero.healthPower -= abzug
        println("$abzug Lebenspunkte wurden dem Helden abgezogen")

    } else if (hero.endbossFluch && (hero.healthPower <= twentyPercent)) {
        println("Du hast den Fluch schon verwendet aber bei einer Lebensenergie von unter $twentyPercent von ${hero.standartHP} lässt der Fluch nach")
        println("Ich weiß, was ist das für ein Fluch , der Rücksicht auf deinen Gesundheitszustand nimmt ? Der Auftraggeber wollte es einfach so")
    }
}

fun isPoisoned(hero: Hero) {

    if (hero.witchPoisen) {

        while (witchPoisenRounds > 0) {
            var damage = ((hero.standartHP / 100) * (3..7).random()).toInt()
            if (damage > 10) {
                damage = 10
            }

            println("Agnes Sabber hat ${hero.name} $damage durch vergiftung abgezogen.")
            println()
            Thread.sleep(1500)

            hero.healthPower -= damage
            witchPoisenRounds--
        }
    }
}



