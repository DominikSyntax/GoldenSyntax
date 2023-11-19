package Funktions

import Bag
import Enemy
import cableCounter
import charakter.*
import gaiaHero
import myTeam
import rootCounter
import tekkHero

import kotlin.NumberFormatException
var witchPoisenRounds:Int = 0

/**
 * Erstellung deines Superhelden Teams
 * @param heroList = Alle zur Auswahl stehenden Helden
 *
 * @return = dein Team aus 3 Helden
 */
fun makeYouTeam(heroList: MutableList<Hero>): MutableList<Hero> {
    var myTeam: MutableSet<Hero> = mutableSetOf()
    var int = 1
    println("Bitte erstelle dir ein Team von 3 Helden.")

    println()
    for (hero in heroList) {
        println()
        println("Du hast die Wahl aus...")
        hero.printInfo()
        newLine()
    }

    println()

    println(
        "Wen möchtest du zu deinem Team hinzufügen? Bitte gib die Zahl ein, die vor deinem Helden steht. \n" +
                "Du kannst jeden nur Einmal in dein Team wählen, unsere Helden sind schließlich Unikate!"
    )

    newLine()
    println("Hier nochmal besser zu lesen:")
    for (h in heroList) {
        println("$int für ${h.name}")
        int++
        println()

    }
    int = 1
    var userChoise: Int = 0
    var preChoise: Int = 0

    while (myTeam.size < 3) {
        try {
            userChoise = readln().toInt()
        } catch (e: NumberFormatException) {
            println("Wat is los mit dir Einstein? Ich hatte gesagt Zahlen! Das sind die Dinger die in $RED_TEXT Rot , hinter dem Minus auf deinem Konto stehen $STANDARTCOLOR.")
            println()
            continue
        }


        if (userChoise == preChoise) {
            println(
                """
                Ich weiß, so ein Text RPG braucht mehr als deine $userChoise Sekunden Aufmerksamkeitsspanne. Oder was wolltest du mir mit dieser Zahl sagen?
                        "Ich bleibe heute einfach mal freundlich und sage dir, dass du dieses Unikat von Held schon ausgewählt hast.
            
            
             Hier ein kleiner Livehack, so kommst du mit der Anzahl der Unikate nicht mehr so oft durcheinader....
                $RED_TEXT Man zählt da ungefähr so: $STANDARTCOLOR  
                 0, ${RED_BACKGROUND}Die Anzahl die es von Unikaten gibt$STANDARTCOLOR, 2 ,3 ,4
                        
            """
            )
            println()
        }

        if (userChoise < 1 || userChoise > 4) {
            println()
            println(
                "Okay, du hast schon einmal verstanden, was eine Zahl ist. Schafft nicht jeder auf anhieb :( \n" +
                        "Aber jetzt genug des Lobes, leider kommt die Zahl , die du wolltest, gar nicht in der Liste vor. \n" +
                        "Ich glaub an dich, schnapp dir alle deine $userChoise Imaginären Freunde (oder wo du diese Zahl auch her hast) \n" +
                        "und schaut euch, vielleicht zusammen die Liste nochmal an und triff die richtige Wahl."
            )
            println()
        } else {
            var userHero: Hero = heroList[userChoise - 1]
            println()
            myTeam.add(userHero)
            println()
        }


        if (myTeam.size == 1) {
            println()
            println("Einen hast du, deine Wahl ist auf ${myTeam.last().name} gefallen, es fehlen noch 2")
            println()
        }
        if (myTeam.size == 2) {
            println()
            println(
                "Es ist unglaublich Bob, ich muss mir an den Kopf fassen, wir haben tatsächlich schon Zwei Helden. \n" +
                        "Du bist auf jeden Fall jetzt schon einer der besten Spieler ! Dein Neuzugang heißt ${myTeam.last().name}"
            )
            println()
        }
        preChoise = userChoise

    }
    println()
    println(" Geschafft! Dein Team besteht aus: ")
    for (hero in myTeam) {
        print("${hero.name}, ")
    }
    var myTeamList = myTeam.toMutableList()
    loadingPrint()

    return myTeamList

}

fun heroChoice(heros: MutableList<Hero>): Hero {

    var chosenHero: Hero
    var heroInt: Int = 1

    println("Such dir einen deiner Helden aus, auf den du mit der Aktion helfen möchtest... ")
    for (hero in heros) {
        if (hero.isDead) {
            println("${hero.name} kann man nicht mehr helfen. Vielleicht kannst du dir aus seinen Knochen ein Scharfes Messer machen ")

        } else {
            println("Gib die $heroInt für ${hero.name} ein")
            heroInt++
        }
    }
    var userInputInt: Int = 0
    try {
        userInputInt = readln().toInt()
    } catch (e: NumberFormatException) {
        println("Nur Chuck Norris kann mit Buchstaben die richtige Zahl eingeben, ich denke nicht das du das verstehst Einstein, deswegen such ich einen Helden für dich aus")
        chosenHero = heros.random()
    }


    if (userInputInt > heros.size) {
        println("Denk nochmal nach Kollege, ich glaube so viele Helden hast du nicht")
        println("Um es dir leichter zu machen suche ich dir dieses mal jemanden aus.")
        chosenHero = heros.random()
    } else {
        chosenHero = heros[userInputInt - 1]
    }

    heroInt = 1

    return chosenHero

}


fun evilChoice(enemies: MutableList<Enemy>): Enemy {
    var chosenEnemy: Enemy? = null
    var enemyInt: Int = 1



    if (enemies.size < 2) {
        println()
        println("Aktuell gibt es nur ${enemies[0].name}, ich nehm dir die schwere Wahl ab und richte deinen Angiff mal gegen ihn. ")
        println()
        chosenEnemy = enemies.first()
        return chosenEnemy
    } else {
        println()
        println("Für diese Aktion, musst du dir einen Gegner aussuchen")
        println()
    }

    for (enemy in enemies) {
        if (enemy.isDead) {
            println("Mit der $enemyInt wählst du ${enemy.name}. Allerdings ist ${enemy.name} bereits tot, du kannst natürlich solange du möchtest das Kunstwerk aus \n" +
                    " $WHITE_BACKGROUND$RED_TEXT Blut, Knochen, Gedärmen und ein wirklich ungewöhnlich kleinen Teil Hirnmasse $STANDARTCOLOR weiter bearbeiten aber versuch doch \n" +
                    "erstmal die anderen vom Waffenstillstand zu überzeugen oder verwandel sie auch in ein wunderschönes Kunstwerk  ")
        } else {
            println("Gib die $enemyInt für ${enemy.name} ein")
            enemyInt++
        }
    }
    while (chosenEnemy == null) {
        var userInputInt: Int = 0
        try {
            userInputInt = readln().toInt()
        } catch (e: NumberFormatException) {
            println("Nummern Junge. Mir ist klar, das du in der Schule nur singen und klatschen hattest. \n" +
                    "Aber das ist mein Spiel und wenn du dich nicht ein bisschen konzentrierst, \n" +
                    "werde ich ${RED_TEXT}Chuck Norris $STANDARTCOLOR bitten, dich aus der Geschichte zu entfernen ")
        }
        if (userInputInt < 1 || userInputInt > enemies.size) {
            println("Das war keine gültige Auswahl")
            chosenEnemy = null
        } else {
            chosenEnemy = enemies[userInputInt - 1]
        }
    }
    return chosenEnemy

}

fun roundForGoods(bag: Bag, heros: MutableList<Hero>, enemies: MutableList<Enemy>, counter: Int) {

    newLine()

    println("Runde : $counter")
    println()

    println("$GREEN_TEXT Deine Helden sind dran $STANDARTCOLOR")
    println()

    for (hero in heros) {
        if (hero.healthPower > 0) {

            isCursed(hero)
            println()

            botsAreGreat(hero)
            println()

            isPoisoned(hero)
            println()

            println("Du bist mit $BLUE_TEXT${hero.name}$STANDARTCOLOR am Zug")
            println()
            println("Was möchtest du machen, du hast die Wahl aus...")
            hero.printAllFunktion(bag)
            newLine()

            var userChoiceFun: Int

            try {
                userChoiceFun = readln().toInt()
            } catch (e: NumberFormatException) {
                println(
                    """
                $RED_BACKGROUND$BLACK_TEXT
                Nur Chuck Norris darf hier auch Buchstaben eingeben!
                $STANDARTCOLOR
                """
                )
                return
            }
            hero.attack(bag, userChoiceFun, enemies, heros)
            for (enemy in enemies){
                displayCondition(enemy)
            }
            newLine()

        }
    }


    bag.bagIsUsed = false
    loadingPrint()
}




fun roundForBads(heros: MutableList<Hero>, enemies: MutableList<Enemy>, counter: Int) {


    newLine()
    println("Die haben gut ausgeteilt, mal sehen was der Gegner macht in seiner $counter Runde... ")
    println()


    for (enemy in enemies) {
        if (enemy.healthPower > 0) {
            newLine()
            rootsOrCable(enemy)

            println()
            println("$RED_TEXT${enemy.name}$STANDARTCOLOR ist am Zug")

            println()
            enemy.fight(enemies, heros)
            for (hero in heros){
                displayCondition(hero)
            }

            newLine()
        }

    }
    loadingPrint()
}






