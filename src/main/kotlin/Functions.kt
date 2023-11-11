import charakter.Endboss
import charakter.Enemy
import charakter.Hero
import kotlin.NumberFormatException

// Die Funktionen für die main.kt hier drin, hab ich auf alle erdenklichen Fehler getesten(nur die erste bis jetzt, in der zweiten könnten noch Fehler sein)


/*
-   -   -   -   -   -   -   -   -   -   TO DO's   -   -   -   -   -   -   -   -   -   -   -   -   -   -
-                                                                                                     -
-                                                                                                     -
- * heilen heißt natürlich nur 100% der start HP! aber um  fäir zu bleiben darf alles was über die    -
-   100 % geht auch nur eine zeit darüber bestehen                                                    -
-                                                                                                     -
-                                                                                                     -
- * Damit das mit den Runden klappt, brauche ich wahrscheinlich, einen return wert für die Runden     -
-   auf die ich von außen zugreifen kann. In der Runden- Schleife (sobald es sie richtig gibt)        -
- * ich glaube es ist besser die Namen der Helden , nicht in der Klasse festzulegen, sodern später    -
-   in der main.kt                                                                                    -
-                                                                                                     -
-                                                                                                     -
-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   - -
 */






fun makeYouTeam(heroList: MutableList<Hero>): MutableList<Hero> {
    var myTeam: MutableSet<Hero> = mutableSetOf()
    println("Bitte such dir ein Team von 3 Helden zusammen, um gegen ${Endboss("Dajjal").name} anzutreten")
    println(
        "Du hast die Wahl aus \n" +
                "1 für ${heroList[0].name} \n" +
                "2 für ${heroList[1].name} \n" +
                "3 für ${heroList[2].name} \n" +
                "4 für ${heroList[3].name} \n"
    )

    println()

    println(
        "Wen möchtest du zu deinem Team hinzufügen? Bitte gib die Zahl ein, die vor deinem Helden steht. \n" +
                "Du kannst jeden nur Einmal in dein Team wählen, unsere Helden sind schließlich Unikate!"
    )

    println()

    var userChoise: Int = 0
    var preChoise: Int = 0

    while (myTeam.size < 3) {
        try {
            userChoise = readln().toInt()
        } catch (e: NumberFormatException) {
            println("Wat is los mit dir Einstein? Ich hatte gesagt Zahlen! Das sind die Dinger mit denen man rechnet.")
            continue
        }

        if (userChoise == preChoise) {
            println(
                "Ich weiß, so ein Text RPG braucht mehr als deine $userChoise Sekunden Aufmerksamkeitsspanne. Oder was wolltest du mir mit dieser Zahl sagen? \n" +
                        "Ich bleibe heute einfach mal freundlich und sage dir, dass du dieses Unikat von Held schon ausgewählt hast."
            )
            println()
            println(" Hier ein kleiner Livehack, so kommst du mit der Anzahl der Unikate nicht mehr so oft durcheinader....")
            println(
                " 0 < Unikat Anzahl < 2   \n" +
                        "Triff eine andere Wahl, am besten eine Richtige"
            )
        }

        if (userChoise < 1 || userChoise > 4) {
            println(
                "Okay, du hast schon einmal verstanden, was eine Zahl ist. Schafft nicht jeder auf anhieb :( \n" +
                        "Aber jetzt genug des Lobes, leider kommt die Zahl , die du wolltest, gar nicht in der Liste vor. \n" +
                        "Ich glaub an dich, schnapp dir alle deine $userChoise Imaginären Freunde (oder wo du diese Zahl auch her hast) \n" +
                        "und schaut euch, vielleicht zusammen die Liste nochmal an und triff die richtige Wahl."
            )
        } else {
            var userHero: Hero = heroList[userChoise - 1]
            myTeam.add(userHero)
        }


        if (myTeam.size == 1) {
            println("Einen hast du, deine Wahl ist auf ${myTeam.last().name} gefallen, es fehlen noch 2")
        }
        if (myTeam.size == 2) {
            println(
                "Es ist unglaublich Bob, ich muss mir an den Kopf fassen, wir haben tatsächlich schon Zwei Helden. \n" +
                        "Du bist auf jeden Fall jetzt schon einer der besten Spieler ! Dein Neuzugang heißt ${myTeam.last().name}"
            )
        }
        preChoise = userChoise

    }
    println(" Geschafft! Dein Team besteht aus: ")
    for (hero in myTeam) {
        print("${hero.name}, ")
    }
    var myTeamList = myTeam.toMutableList()
    return myTeamList
}

fun heroChoice(heros: MutableList<Hero>): Hero {
    var chosenHero: Hero
    var heroInt: Int = 1
    println("Für diese Aktion, musst du dir einen Helden aussuchen")
    for (hero in heros) {
        if (hero.isDead || hero.healthPower <= 0) {
            println("${hero.name} macht nix mehr, evtl. kannst du die Knochen noch als Waffe nutzen")
        } else {
            println("Gib die $heroInt für ${hero.name} ein")
            heroInt++
        }
    }
    var userInputInt: Int = readln().toInt() - 1


    if (userInputInt > heros.size - 1) {
        println("Denk nochmal nach Kollege, ich glaube so viele Helden hast du nicht")
        println("Um es dir leichter zu machen suche ich dir dieses mal jemanden aus.")
        chosenHero = heros.random()
    } else {
        chosenHero = heros[userInputInt]
    }

    heroInt = 1
    return chosenHero

}


fun evilChoice(enemies: MutableList<Enemy>): Enemy {
    var chosenEnemy: Enemy? = null
    var enemyInt: Int = 1


    println("Für diese Aktion, musst du dir einen Gegner aussuchen")

    for (enemy in enemies) {
        if (enemy.healthPower <= 0 || enemy.isDead) {
            println("${enemy.name} ist tot")
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
            println("Nummern, sind die Dinger hinter dem - auf deinem Konto")
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

    println("Runde : $counter")
    println()
    println("Zuerst sind deine Helden dran")



    for (hero in heros) {
        println("Du bist mit ${hero.name} am Zug")
        println("Was möchtest du machen, du hast die Wahl aus...")
        hero.printAllFunktion(bag)
        var userChoiceFun: Int
        try {
            userChoiceFun = readln().toInt()
        } catch (e: NumberFormatException) {
            println("Nummern, sind die Dinger hinter dem - auf deinem Konto \n" +
                    "Nur Chuck Norris darf hier auch Buchstaben eingeben!")
            return
        }

        for (enemy in enemies) {
            if (enemy.healthPower <= 0) {
                enemy.healthPower = 0
                enemy.isDead = true
                println("Mit ${enemy.name} ist nichts mehr anzufangen, das Weichei hat den Tod vorgezogen, anstatt sich seiner Verantwortung zu stellen")
            } else {
                println("${enemy.name} hat noch ${enemy.healthPower} Lebenspunkte ")
            }
        }

        hero.attack(bag, userChoiceFun, enemies, heros)


    }
    bag.bagIsUsed = false





    Thread.sleep(1500)
}


fun roundForBads(heros: MutableList<Hero>, enemies: MutableList<Enemy>, counter: Int) {
    println("Die haben gut ausgeteilt, mal sehen was der Gegner macht in seiner $counter Runde... ")
    var enemiesCopy = enemies.toMutableList()
    var selfAttackisUsed: Boolean



    for (hero in heros) {
        if (hero.healthPower <= 0) {
            hero.healthPower = 0
            hero.isDead = true
        } else {
            for (enemy in enemiesCopy) {
                println("${enemy.name} ist am Zug")
                enemy.fight(enemies, heros)
                println()
                Thread.sleep(1500)
            }
            for (hero in heros) {
                println("${hero.name} hat noch ${hero.healthPower} Lebensenergie")
                println()

            }
        }

    }

}


fun allGoodsAreDead(heros: MutableList<Hero>): Boolean {
    var allDead = false
    if (heros.all { it.isDead }) {
        allDead = true
    }
    return allDead

}

fun allBadsAreDead(enemies: MutableList<Enemy>): Boolean {
    var allDead = false
    if (enemies.all { it.isDead }) {
        allDead = true
    }
    return allDead
}


fun greeting() {
    println(" Herzlich willkommen bei Golden Syntax")
}