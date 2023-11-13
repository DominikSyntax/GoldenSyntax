
import charakter.*

import kotlin.NumberFormatException



/*

-   -   -   -   -   -   -   -   -   -   TO DO's   -   -   -   -   -   -   -   -   -   -   -   -   -   -
-                                                                                                     -
-                                                                                                     -
-                                                                                                     -
-                                                                                                     -
-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   - -

 */


fun verflucht(heros: MutableList<Hero>) {
    for (hero in heros) {
        var twentyPercent = hero.standartHP / 100 * 20
        if (hero.endbossFluch && (hero.healthPower > twentyPercent)) {
            println("Dajjal's Fluch, der Autoimmunkrankheit hat ${hero.name} fest im Griff. ${hero.name}'s Körper Kämpft gegen sich selbst ")
            var abzug = hero.healthPower / 100 * 10
            hero.healthPower -= abzug
            println("$abzug Lebenspunkte wurden dem Helden abgezogen")
        } else if (hero.endbossFluch && (hero.healthPower <= twentyPercent)) {
            println("Du hast den Fluch schon verwendet aber bei einer Lebensenergie von unter $twentyPercent von ${hero.standartHP} lässt der Fluch nach")
            println("Ich weiß, was ist das für ein Fluch , der Rücksicht auf deinen Gesundheitszustand nimmt ? Der Auftraggeber wollte es einfach so")
        }
    }
}


fun makeYouTeam(heroList: MutableList<Hero>): MutableList<Hero> {
    var myTeam: MutableSet<Hero> = mutableSetOf()
    var int = 1
    println("Bitte such dir ein Team von 3 Helden zusammen, um gegen ${Endboss("Dajjal").name} anzutreten")

    println()
    for (hero in heroList) {
        println()
        println("Du hast die Wahl aus...")
        hero.printInfo()
        absatz()
        println()
    }

    println()

    println(
        "Wen möchtest du zu deinem Team hinzufügen? Bitte gib die Zahl ein, die vor deinem Helden steht. \n" +
                "Du kannst jeden nur Einmal in dein Team wählen, unsere Helden sind schließlich Unikate!"
    )

    println()
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
    absatz()
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



    println("Für diese Aktion, musst du dir einen Gegner aussuchen")
    if (enemies.size < 2) {
        println("Aktuell gibt es nur ${enemies[0].name}, ich nehm dir die schwere Wahl ab und richte deinen Angiff mal gegen ihn. ")
        chosenEnemy = enemies.first()
        return chosenEnemy
    }

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
    absatz()
    println("Runde : $counter")


    if (deadBads) {
        println(
            """
            ███▄▄▄▄      ▄████████  ▄█  ███▄▄▄▄   
            ███▀▀▀██▄   ███    ███ ███  ███▀▀▀██▄ 
            ███   ███   ███    █▀  ███▌ ███   ███ 
            ███   ███  ▄███▄▄▄     ███▌ ███   ███ 
            ███   ███ ▀▀███▀▀▀     ███▌ ███   ███ 
            ███   ███   ███    █▄  ███  ███   ███ 
            ███   ███   ███    ███ ███  ███   ███ 
             ▀█   █▀    ██████████ █▀    ▀█   █▀  
                                      
        Die guten haben schon wieder gewonnen, aber nicht in meinem Spiel. Das kann ich als Programmierer nicht zulassen.
        """
        )
        absatz()
        println(
            "Die Helden haben alle Feinde besiegt, ihnen ist jedoch bei dem Kampf nicht aufgefallen, das ein " +
                    """  ▄█   ▄█▄  ▄██████▄    ▄▄▄▄███▄▄▄▄      ▄████████     ███     
                     ███ ▄███▀ ███    ███ ▄██▀▀▀███▀▀▀██▄   ███    ███ ▀█████████▄ 
                     ███▐██▀   ███    ███ ███   ███   ███   ███    █▀     ▀███▀▀██ 
                    ▄█████▀    ███    ███ ███   ███   ███  ▄███▄▄▄         ███   ▀ 
                   ▀▀█████▄    ███    ███ ███   ███   ███ ▀▀███▀▀▀         ███     
                     ███▐██▄   ███    ███ ███   ███   ███   ███    █▄      ███     
                     ███ ▀███▄ ███    ███ ███   ███   ███   ███    ███     ███     
                     ███   ▀█▀  ▀██████▀   ▀█   ███   █▀    ██████████    ▄████▀   
                             ▀                                                             """ +
                    "(3x so groß und doppelt so schnell, wie der, der die Dinos ausgelöscht hat) \n" +
                    "auf die Erde zugeflogen kam. \n" +
                    ""
        )
        Thread.sleep(500)
        println("Alle freuen sich, kleine Kinder spielen auf dem Spielplatz und plötzlich......")
        println()
        println(
            """
            █████████▄   ▄██████▄   ▄██████▄    ▄▄▄▄███▄▄▄▄   
             ███    ███ ███    ███ ███    ███ ▄██▀▀▀███▀▀▀██▄ 
             ███    ███ ███    ███ ███    ███ ███   ███   ███ 
            ▄███▄▄▄██▀  ███    ███ ███    ███ ███   ███   ███ 
           ▀▀███▀▀▀██▄  ███    ███ ███    ███ ███   ███   ███ 
             ███    ██▄ ███    ███ ███    ███ ███   ███   ███ 
             ███    ███ ███    ███ ███    ███ ███   ███   ███ 
           ▄█████████▀   ▀██████▀   ▀██████▀   ▀█   ███   █▀  
                                                   
        """.trimIndent()
        )
        println("Der ganze Planet explodiert, alle und alles tot..... überall Gedärme und Körperteile im Weltraum .... ENDE!")


    } else if (deadGoods) {
        println(
            """
                 ▄█    ▄████████  ▄█     █▄   ▄██████▄     ▄█    █▄     ▄█                    ▄████████ ███▄▄▄▄   ████████▄   ▄█        ▄█   ▄████████    ▄█    █▄    
                 ███   ███    ███ ███     ███ ███    ███   ███    ███   ███                   ███    ███ ███▀▀▀██▄ ███   ▀███ ███       ███  ███    ███   ███    ███   
                 ███   ███    ███ ███     ███ ███    ███   ███    ███   ███                   ███    █▀  ███   ███ ███    ███ ███       ███▌ ███    █▀    ███    ███   
                 ███   ███    ███ ███     ███ ███    ███  ▄███▄▄▄▄███▄▄ ███                  ▄███▄▄▄     ███   ███ ███    ███ ███       ███▌ ███         ▄███▄▄▄▄███▄▄ 
                 ███ ▀███████████ ███     ███ ███    ███ ▀▀███▀▀▀▀███▀  ███                 ▀▀███▀▀▀     ███   ███ ███    ███ ███       ███▌ ███        ▀▀███▀▀▀▀███▀  
                 ███   ███    ███ ███     ███ ███    ███   ███    ███   ███                   ███    █▄  ███   ███ ███    ███ ███       ███  ███    █▄    ███    ███   
                 ███   ███    ███ ███ ▄█▄ ███ ███    ███   ███    ███   ███▌    ▄             ███    ███ ███   ███ ███   ▄███ ███▌    ▄ ███  ███    ███   ███    ███   
             █▄ ▄███   ███    █▀   ▀███▀███▀   ▀██████▀    ███    █▀    █████▄▄██             ██████████  ▀█   █▀  ████████▀  █████▄▄██ █▀   ████████▀    ███    █▀    
             ▀▀▀▀▀▀                                                     ▀                                                     ▀                                        
                                      
        Die bösen haben endlich mal gewonnen, das einzige Happy End das ich mag , ist ein romantisches Date mit mir, meiner Hand und einem Taschentuch
        """
        )
        absatz()
        println(
            "Die Bösen haben alle Helden besiegt, ihnen ist jedoch bei dem Kampf nicht aufgefallen, das ein " +
                    """  ▄█   ▄█▄  ▄██████▄    ▄▄▄▄███▄▄▄▄      ▄████████     ███     
                     ███ ▄███▀ ███    ███ ▄██▀▀▀███▀▀▀██▄   ███    ███ ▀█████████▄ 
                     ███▐██▀   ███    ███ ███   ███   ███   ███    █▀     ▀███▀▀██ 
                    ▄█████▀    ███    ███ ███   ███   ███  ▄███▄▄▄         ███   ▀ 
                   ▀▀█████▄    ███    ███ ███   ███   ███ ▀▀███▀▀▀         ███     
                     ███▐██▄   ███    ███ ███   ███   ███   ███    █▄      ███     
                     ███ ▀███▄ ███    ███ ███   ███   ███   ███    ███     ███     
                     ███   ▀█▀  ▀██████▀   ▀█   ███   █▀    ██████████    ▄████▀   
                             ▀                                                             """ +
                    "(3x so groß und doppelt so schnell, wie der, der die Dinos ausgelöscht hat) \n" +
                    "auf die Erde zugeflogen kam. \n" +
                    ""
        )
        Thread.sleep(500)
        println("Alle Menschen auf der Erde leben in Angst und Schrecken. Doch plötzlich......")
        println()
        println(
            """
            █████████▄   ▄██████▄   ▄██████▄    ▄▄▄▄███▄▄▄▄   
             ███    ███ ███    ███ ███    ███ ▄██▀▀▀███▀▀▀██▄ 
             ███    ███ ███    ███ ███    ███ ███   ███   ███ 
            ▄███▄▄▄██▀  ███    ███ ███    ███ ███   ███   ███ 
           ▀▀███▀▀▀██▄  ███    ███ ███    ███ ███   ███   ███ 
             ███    ██▄ ███    ███ ███    ███ ███   ███   ███ 
             ███    ███ ███    ███ ███    ███ ███   ███   ███ 
           ▄█████████▀   ▀██████▀   ▀██████▀   ▀█   ███   █▀  
                                                   
        """.trimIndent()
        )
        println("Der ganze Planet explodiert, alle und jeder sind tot..... überall Gedärme und Körperteile im Weltraum .... ENDE!")


    } else {
        println()
        println("Zuerst sind deine Helden dran")
        verflucht(heros)
        for (hero in heros) {
            if (hero.nanoAreUsed) {
                if (hero.healthPower > 0) {
                    var healing = hero.healthPower / 100 * 2
                    hero.healthPower += healing
                } else {
                    println("Einem toten können auch die Nanobots nicht mehr helfen")
                }
            }
            println("Du bist mit ${hero.name} am Zug")
            println("Was möchtest du machen, du hast die Wahl aus...")
            hero.printAllFunktion(bag)

            var userChoiceFun: Int


            try {
                userChoiceFun = readln().toInt()
            } catch (e: NumberFormatException) {
                println(
                    "Nummern, sind die Dinger hinter dem - auf deinem Konto \n" +
                            "Nur Chuck Norris darf hier auch Buchstaben eingeben!"

                )
                return
            }


            hero.attack(bag, userChoiceFun, enemies, heros)
            for (enemy in enemies) {
                if (enemy.healthPower <= 0) {
                    enemy.healthPower = 0
                    enemy.isDead = true
                    absatz()
                    println("Mit ${enemy.name} ist nichts mehr anzufangen, das Weichei hat den Tod vorgezogen, anstatt sich seiner Verantwortung zu stellen")
                    println()
                } else {
                    absatz()
                    println("${enemy.name} hat noch ${enemy.healthPower} Lebenspunkte ")
                    println()
                }
            }


        }
        bag.bagIsUsed = false
        absatz()

    }
}


fun roundForBads(heros: MutableList<Hero>, enemies: MutableList<Enemy>, counter: Int) {
    absatz()
    println("Die haben gut ausgeteilt, mal sehen was der Gegner macht in seiner $counter Runde... ")
    println()

    var enemiesCopy = enemies.toMutableList()


    if (deadBads) {
        println(
            """
            ███▄▄▄▄      ▄████████  ▄█  ███▄▄▄▄   
            ███▀▀▀██▄   ███    ███ ███  ███▀▀▀██▄ 
            ███   ███   ███    █▀  ███▌ ███   ███ 
            ███   ███  ▄███▄▄▄     ███▌ ███   ███ 
            ███   ███ ▀▀███▀▀▀     ███▌ ███   ███ 
            ███   ███   ███    █▄  ███  ███   ███ 
            ███   ███   ███    ███ ███  ███   ███ 
             ▀█   █▀    ██████████ █▀    ▀█   █▀  
                                      
        Die guten haben schon wieder gewonnen, aber nicht in meinem Spiel. Das kann ich als Programmierer nicht zulassen.
        """
        )
        absatz()
        println(
            "Die Helden haben alle Feinde besiegt, ihnen ist jedoch bei dem Kampf nicht aufgefallen, das ein " +
                    """  ▄█   ▄█▄  ▄██████▄    ▄▄▄▄███▄▄▄▄      ▄████████     ███     
                     ███ ▄███▀ ███    ███ ▄██▀▀▀███▀▀▀██▄   ███    ███ ▀█████████▄ 
                     ███▐██▀   ███    ███ ███   ███   ███   ███    █▀     ▀███▀▀██ 
                    ▄█████▀    ███    ███ ███   ███   ███  ▄███▄▄▄         ███   ▀ 
                   ▀▀█████▄    ███    ███ ███   ███   ███ ▀▀███▀▀▀         ███     
                     ███▐██▄   ███    ███ ███   ███   ███   ███    █▄      ███     
                     ███ ▀███▄ ███    ███ ███   ███   ███   ███    ███     ███     
                     ███   ▀█▀  ▀██████▀   ▀█   ███   █▀    ██████████    ▄████▀   
                             ▀                                                             """ +
                    "(3x so groß und doppelt so schnell, wie der, der die Dinos ausgelöscht hat) \n" +
                    "auf die Erde zugeflogen kam. \n" +
                    ""
        )
        Thread.sleep(500)
        println("Alle freuen sich, kleine Kinder spielen auf dem Spielplatz und plötzlich......")
        println()
        println(
            """
            █████████▄   ▄██████▄   ▄██████▄    ▄▄▄▄███▄▄▄▄   
             ███    ███ ███    ███ ███    ███ ▄██▀▀▀███▀▀▀██▄ 
             ███    ███ ███    ███ ███    ███ ███   ███   ███ 
            ▄███▄▄▄██▀  ███    ███ ███    ███ ███   ███   ███ 
           ▀▀███▀▀▀██▄  ███    ███ ███    ███ ███   ███   ███ 
             ███    ██▄ ███    ███ ███    ███ ███   ███   ███ 
             ███    ███ ███    ███ ███    ███ ███   ███   ███ 
           ▄█████████▀   ▀██████▀   ▀██████▀   ▀█   ███   █▀  
                                                   
        """.trimIndent()
        )
        println("Der ganze Planet explodiert, alle und alles tot..... überall Gedärme und Körperteile im Weltraum .... ENDE!")


    } else if (deadGoods) {
        println(
            """
                 ▄█    ▄████████  ▄█     █▄   ▄██████▄     ▄█    █▄     ▄█                    ▄████████ ███▄▄▄▄   ████████▄   ▄█        ▄█   ▄████████    ▄█    █▄    
                 ███   ███    ███ ███     ███ ███    ███   ███    ███   ███                   ███    ███ ███▀▀▀██▄ ███   ▀███ ███       ███  ███    ███   ███    ███   
                 ███   ███    ███ ███     ███ ███    ███   ███    ███   ███                   ███    █▀  ███   ███ ███    ███ ███       ███▌ ███    █▀    ███    ███   
                 ███   ███    ███ ███     ███ ███    ███  ▄███▄▄▄▄███▄▄ ███                  ▄███▄▄▄     ███   ███ ███    ███ ███       ███▌ ███         ▄███▄▄▄▄███▄▄ 
                 ███ ▀███████████ ███     ███ ███    ███ ▀▀███▀▀▀▀███▀  ███                 ▀▀███▀▀▀     ███   ███ ███    ███ ███       ███▌ ███        ▀▀███▀▀▀▀███▀  
                 ███   ███    ███ ███     ███ ███    ███   ███    ███   ███                   ███    █▄  ███   ███ ███    ███ ███       ███  ███    █▄    ███    ███   
                 ███   ███    ███ ███ ▄█▄ ███ ███    ███   ███    ███   ███▌    ▄             ███    ███ ███   ███ ███   ▄███ ███▌    ▄ ███  ███    ███   ███    ███   
             █▄ ▄███   ███    █▀   ▀███▀███▀   ▀██████▀    ███    █▀    █████▄▄██             ██████████  ▀█   █▀  ████████▀  █████▄▄██ █▀   ████████▀    ███    █▀    
             ▀▀▀▀▀▀                                                     ▀                                                     ▀                                        
                                      
        Die bösen haben endlich mal gewonnen, das einzige Happy End das ich mag , ist ein romantisches Date mit mir, meiner Hand und einem Taschentuch
        """
        )
        absatz()
        println(
            "Die Bösen haben alle Helden besiegt, ihnen ist jedoch bei dem Kampf nicht aufgefallen, das ein " +
                    """  ▄█   ▄█▄  ▄██████▄    ▄▄▄▄███▄▄▄▄      ▄████████     ███     
                     ███ ▄███▀ ███    ███ ▄██▀▀▀███▀▀▀██▄   ███    ███ ▀█████████▄ 
                     ███▐██▀   ███    ███ ███   ███   ███   ███    █▀     ▀███▀▀██ 
                    ▄█████▀    ███    ███ ███   ███   ███  ▄███▄▄▄         ███   ▀ 
                   ▀▀█████▄    ███    ███ ███   ███   ███ ▀▀███▀▀▀         ███     
                     ███▐██▄   ███    ███ ███   ███   ███   ███    █▄      ███     
                     ███ ▀███▄ ███    ███ ███   ███   ███   ███    ███     ███     
                     ███   ▀█▀  ▀██████▀   ▀█   ███   █▀    ██████████    ▄████▀   
                             ▀                                                             """ +
                    "(3x so groß und doppelt so schnell, wie der, der die Dinos ausgelöscht hat) \n" +
                    "auf die Erde zugeflogen kam. \n" +
                    ""
        )
        Thread.sleep(500)
        println("Alle Menschen auf der Erde leben in Angst und Schrecken. Doch plötzlich......")
        println()
        println(
            """
            █████████▄   ▄██████▄   ▄██████▄    ▄▄▄▄███▄▄▄▄   
             ███    ███ ███    ███ ███    ███ ▄██▀▀▀███▀▀▀██▄ 
             ███    ███ ███    ███ ███    ███ ███   ███   ███ 
            ▄███▄▄▄██▀  ███    ███ ███    ███ ███   ███   ███ 
           ▀▀███▀▀▀██▄  ███    ███ ███    ███ ███   ███   ███ 
             ███    ██▄ ███    ███ ███    ███ ███   ███   ███ 
             ███    ███ ███    ███ ███    ███ ███   ███   ███ 
           ▄█████████▀   ▀██████▀   ▀██████▀   ▀█   ███   █▀  
                                                   
        """.trimIndent()
        )
        println("Der ganze Planet explodiert, alle und jeder sind tot..... überall Gedärme und Körperteile im Weltraum .... ENDE!")


    } else {

        for (enemy in enemiesCopy) {
            println("${enemy.name} ist am Zug")
            enemy.fight(enemies, heros)
            for (hero in heros) {
                if (hero.healthPower <= 0) {
                    hero.healthPower = 0
                    hero.isDead = true
                    println("${hero.name} hat den Angriff nicht überlebt")
                    absatz()

                } else {
                    println("${hero.name} hat noch ${hero.healthPower} Lebensenergie")
                    absatz()
                }
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
    absatz()

    println(" Herzlich willkommen bei ...")
    println(
        """
 ____            ___       __                           ____                    __                      
/\  _`\         /\_ \      /\ \                       /\  _`\                 /\ \__                   
\ \ \L\_\     ___ \//\ \     \_\ \     __    ___     \ \,\L\_\   __  __    ___\ \ ,_\      __     __  _  
 \ \ \L_L    / __`\ \ \ \    /'_` \   /'__`\ /' _ `\   \/_\__ \  /\ \/\ \  /' _ `\ \ \/  /'__`\  /\ \/'\ 
  \ \ \/, \ /\ \L\ \ \_\ \_ /\ \L\ \ /\  __/ /\ \/\ \    /\ \L\ \  \ \_\ \ /\ \/\ \ \ \_/\ \L\.\_\/>  </ 
   \ \____/ \ \____// \____\  \___,_\  \____ \ \_\ \_\   \ `\____\ /`____ \  \_\ \_\ \__\ \__/.\_\/\_/\_\
    \/___/   \/___/  \/____/ \/__,_ / \/____/ \/_/\/_/    \/_____/ `/___/>  \/_/\/_/\/__/\/__/\/_/\//\/_/
                                                                  /\___/                            
                                                                  \/__/                        
    Golden Syntax...by Dominik Weber v 1.1
      * v1.2 coming soon * 
      
      * = (das heißt übersetzt ... es wird noch besser)
    """
    )
    absatz()
}

fun absatz() {
    var loading = listOf<String>("-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-")
    var colorChoise = (0..4).random()
    var colors:List<String> = listOf(RED_TEXT,GREEN_TEXT,BLUE_TEXT,YELLOW_TEXT,MAGENTA_TEXT)
    println()
    Thread.sleep(100)
    for (i in loading) {
        print(colors[colorChoise] + i )
        Thread.sleep(100)
    }
    println(STANDARTCOLOR)

}



/**
 * Balken zur Grafischen Anzeige der Lebensenergie der Helden
 */
fun displayHpHero (hero:Hero) {
    if (hero.healthPower < 1 )
        hero.healthPower = 0

    val hpBarLength = 20
    val hpPercentage = (hero.healthPower/hero.standartHP * 100).toInt()
    val currentHpBarLength = (hpPercentage *hpBarLength /100).coerceIn(0,hpBarLength)
    val maxHpBarLength = hpBarLength - currentHpBarLength

    var currentHpColor =
        if (hpPercentage>60) {
            GREEN_BACKGROUND
        }else if (hpPercentage in 30..60) {
            YELLOW_BACKGROUND
        }else
            RED_BACKGROUND

    val maxHpColor = WHITE_BACKGROUND
    val currentHPBar = " ".repeat(currentHpBarLength)
    val maxHPBar = " ".repeat(maxHpBarLength)
    val resetColor = STANDARTCOLOR


    var hpInfo = "(${hero.healthPower/hero.standartHP})".padStart("${hero.name}'Lebensenergie: $currentHPBar$maxHPBar".length)
    println("${hero.name}'s Lebensenergie : $currentHpColor$currentHPBar$resetColor$maxHpColor$maxHPBar$resetColor $resetColor \n $hpInfo \n")

}


fun displayHpEnemy(enemy: Enemy) {
    if (enemy.healthPower < 1)
        enemy.healthPower = 0

    val hpBarLength = 20.0f
    val hpPercentage = ((100.0f / enemy.standartHP) * enemy.healthPower)
    val currentHpBarLength = ((hpPercentage * hpBarLength) / 100.0f).coerceIn(0.0f, hpBarLength)
    val maxHpBarLength = hpBarLength - currentHpBarLength

    var currentHpColor =
        if (hpPercentage > 60.0f) {
            GREEN_BACKGROUND
        } else if (hpPercentage  in 30.0f..60.0f) {
            YELLOW_BACKGROUND
        } else
            RED_BACKGROUND

    val maxHpColor = WHITE_BACKGROUND
    val currentHPBar = " ".repeat(currentHpBarLength.toInt())
    val maxHPBar = " ".repeat(maxHpBarLength.toInt())
    val resetColor = STANDARTCOLOR

    var hpInfo = "(${enemy.healthPower} / ${enemy.standartHP})"
    println(
        "${enemy.name}'s Lebensenergie : $currentHpColor$currentHPBar$resetColor$maxHpColor$maxHPBar$resetColor $resetColor \n $hpInfo \n"
    )
}
