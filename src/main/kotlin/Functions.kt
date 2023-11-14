import charakter.*

import kotlin.NumberFormatException

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

fun rootsOrCable(enemy: Enemy) {

    if (enemy.roots) {
        if (enemy.healthPower > 0) {


            var abzug: Int = (7..25).random()
            var damageMinus = (10..25).random()

            println("Die Wurzeln haben ${enemy.name} fest im Giff, für mehrere Runden werden ihmLebenspu nkte abgezogen und die Angriffskraft sinkt etwas")
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
    }
    if (enemy.cable) {
        var deduction: Int = (7..25).random()
        var deductionTwo = (25..50).random()
        var smallOrBig = listOf(deduction, deductionTwo)
        var abzug = smallOrBig.random()

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
        cableCounter--
    }


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
        }
    }
}


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
            println("Wat is los mit dir Einstein? Ich hatte gesagt Zahlen! Das sind die Dinger die in $RED_TEXT Rot , hinter dem Minus auf deinem Konto stehen $STANDARTCOLOR.")
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
        println("Aktuell gibt es nur ${enemies[0].name}, ich nehm dir die schwere Wahl ab und richte deinen Angiff mal gegen ihn. ")
        chosenEnemy = enemies.first()
        return chosenEnemy
    } else {
        println("Für diese Aktion, musst du dir einen Gegner aussuchen")
    }

    for (enemy in enemies) {
        if (enemy.isDead) {
            println("${enemy.name} ist bereits tot, ich würde deine Kraft nicht für dieses Kunstwerk aus $WHITE_BACKGROUND$RED_TEXT Blut, Knochen, Gedärmen und ein wirklich ungewöhnlich kleinen Teil Hirnmasse $STANDARTCOLOR verschwenden ")
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
            println("Nummern Junge. Mir ist klar, das du in der Schule nur singen und klatschen hattest. Aber das ist mein Spiel und wenn du dich nicht ein bisschen konzentrierst, werde ich ${RED_TEXT}Chuck Norris $STANDARTCOLOR bitten, dich aus der Geschichte zu entfernen ")
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
    println()

    println("$BLUE_BACKGROUND$RED_TEXT Deine Helden sind dran $STANDARTCOLOR")
    if (heros.size==0){
        println(" du hast keinen Helden mehr am Leben , der was machen kann ")
    }else {

        for (hero in heros) {
            if (hero.healthPower > 0) {

                isCursed(hero)

                botsAreGreat(hero)
                println("Du bist mit $BLUE_TEXT${hero.name}$STANDARTCOLOR am Zug")
                println("Was möchtest du machen, du hast die Wahl aus...")
                hero.printAllFunktion(bag)

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
            }

        }

        bag.bagIsUsed = false
        absatz()
    }

}


fun roundForBads(heros: MutableList<Hero>, enemies: MutableList<Enemy>, counter: Int) {
    if (enemies.size == 0){
        println("Kein Feind mehr zum prügeln, die spinnen , die Römer")
    }else {

        absatz()
        println("Die haben gut ausgeteilt, mal sehen was der Gegner macht in seiner $counter Runde... ")
        println()

        // if abfrage wegen den wurzeln . bzw kabeln falls ja abziehen

        var enemiesCopy = enemies.toMutableList()

        for (enemy in enemiesCopy) {
            if (enemy.healthPower> 0) {
                rootsOrCable(enemy)
                println("${enemy.name} ist am Zug")
                enemy.fight(enemies, heros)
                for (hero in heros) {
                    if (hero.healthPower <= 0) {
                        hero.healthPower = 0
                        hero.isDead = true
                        println("${hero.name} hat den Angriff nicht überlebt")
                        absatz()

                    } else {
                        absatz()
                    }
                }
            }
        }
    }

}


fun allGoodsAreDead(heros: MutableList<Hero>) {
    for (hero in heros) {
        if (hero.isDead || hero.healthPower <= 0) {
            heros.remove(hero)
        }
    }
}

fun allBadsAreDead(enemies: MutableList<Enemy>): Boolean {
        for (e in enemies) {
            if (e.isDead|| e.healthPower <= 0) {
                enemies.remove(e)
            }
        }
        return true
}



fun greeting() {
    absatz()

    println(" Herzlich willkommen bei ...")
    println(
        """ $WHITE_BACKGROUND$YELLOW_TEXT
 ____            ___       __                           ____                    __                      
/\  _`\         /\_ \      /\ \                       /\  _`\                 /\ \__                   
\ \ \L\_\     ___ \//\ \     \_\ \     __    ___     \ \,\L\_\   __  __    ___\ \ ,_\      __     __  _  
 \ \ \L_L    / __`\ \ \ \    /'_` \   /'__`\ /' _ `\   \/_\__ \  /\ \/\ \  /' _ `\ \ \/  /'__`\  /\ \/'\ 
  \ \ \/, \ /\ \L\ \ \_\ \_ /\ \L\ \ /\  __/ /\ \/\ \    /\ \L\ \  \ \_\ \ /\ \/\ \ \ \_/\ \L\.\_\/>  </ 
   \ \____/ \ \____// \____\  \___,_\  \____ \ \_\ \_\   \ `\____\ /`____ \  \_\ \_\ \__\ \__/.\_\/\_/\_\
    \/___/   \/___/  \/____/ \/__,_ / \/____/ \/_/\/_/    \/_____/ `/___/>  \/_/\/_/\/__/\/__/\/_/\//\/_/
                                                                  /\___/                            
                                                                   \/__/  
                                                                                         $STANDARTCOLOR
    Golden Syntax...by Dominik Weber v 1.1
      * v1.2 coming soon * 
      
      * = (das heißt übersetzt ... es wird noch besser)
    """
    )
    absatz()
}

fun absatz() {
    var loading = listOf<String>(
        "-",
        "-",
        "-",
        "-",
        "-",
        "-",
        "-",
        "-",
        "-",
        "-",
        "-",
        "-",
        "-",
        "-",
        "-",
        "-",
        "-",
        "-",
        "-",
        "-",
        "-",
        "-",
        "-"
    )
    var colorChoise = (0..4).random()
    var colors: List<String> = listOf(RED_TEXT, GREEN_TEXT, BLUE_TEXT, YELLOW_TEXT, MAGENTA_TEXT)
    println()
    println("loading....")
    for (i in loading) {
        print(colors[colorChoise] + i)
        Thread.sleep(100)
    }
    println(STANDARTCOLOR)

}


/**
 * Balken zur Grafischen darstellung der Lebensenergie
 * @param person = egal ob gut oder böse
 */
fun displayHp(person: OverCharakter) {
    if (person.healthPower < 1)
        person.healthPower = 0

    val hpBarLength = 20.0f
    val hpPercentage = ((100.0f / person.standartHP) * person.healthPower)
    val currentHpBarLength = ((hpPercentage * hpBarLength) / 100.0f).coerceIn(0.0f, hpBarLength)
    val maxHpBarLength = hpBarLength - currentHpBarLength

    var currentHpColor =
        if (hpPercentage > 60.0f) {
            GREEN_BACKGROUND
        } else if (hpPercentage in 30.0f..60.0f) {
            YELLOW_BACKGROUND
        } else
            RED_BACKGROUND

    val maxHpColor = WHITE_BACKGROUND
    val currentHPBar = " ".repeat(currentHpBarLength.toInt())
    val maxHPBar = " ".repeat(maxHpBarLength.toInt())
    val resetColor = STANDARTCOLOR

    var hpInfo = "(${person.healthPower} / ${person.standartHP})"
    println(
        "${person.name}'s Lebensenergie : $currentHpColor$currentHPBar$resetColor$maxHpColor$maxHPBar$resetColor $resetColor \n $hpInfo \n"
    )
}

fun chuckNorris(round: Int) {
    if (round == 4) {
        println("$BLUE_TEXT Chuck Norris $STANDARTCOLOR hat von der Bedrohung erfahren.... Die Helden und auch die Bösen fangen an sich zu beeilen, keiner möchte das er wütend wird.")
    } else if (round == 7) {
        println(
            "Das letzte mal das $BLUE_TEXT Chuck Norris $STANDARTCOLOR wirklich böse war, war als Gott versucht hat bei 'MENSCH ÄRGER DICH NICHT', zu schummeln. \n" +
                    "Chuck hat mit der flachen Hand auf den Tisch gehauen, das nennen wir heutzutage $RED_BACKGROUND$BLACK_TEXT Die URKNALL THEORIE $STANDARTCOLOR ..."
        )
    } else if (round == 10) {
        println("$BLUE_TEXT Chuck Norris $STANDARTCOLOR hat entschieden, sich raus zu halten. Er wollte einen Helden anfeuern, der ist dann aus Respekt wirklich verbrannt")
    }else if (round == 20){
        println("$BLUE_TEXT Chuck Norris $STANDARTCOLOR hat die Schnautze voll.... er schaut böse in die Richtung des Kampfes.\n" +
                "Alle sind tot umgefallen ! ")
        println("""
            $RED_BACKGROUND$BLACK_TEXT
             ::::::::  :::    ::: :::    :::  ::::::::  :::    :::      ::::    :::  ::::::::  :::::::::  :::::::::  ::::::::::: ::::::::       :::       ::: ::::::::::: ::::    :::  ::::::::  
            :+:    :+: :+:    :+: :+:    :+: :+:    :+: :+:   :+:       :+:+:   :+: :+:    :+: :+:    :+: :+:    :+:     :+:    :+:    :+:      :+:       :+:     :+:     :+:+:   :+: :+:    :+: 
            +:+        +:+    +:+ +:+    +:+ +:+        +:+  +:+        :+:+:+  +:+ +:+    +:+ +:+    +:+ +:+    +:+     +:+    +:+             +:+       +:+     +:+     :+:+:+  +:+ +:+        
            +#+        +#++:++#++ +#+    +:+ +#+        +#++:++         +#+ +:+ +#+ +#+    +:+ +#++:++#:  +#++:++#:      +#+    +#++:++#++      +#+  +:+  +#+     +#+     +#+ +:+ +#+ +#++:++#++ 
            +#+        +#+    +#+ +#+    +#+ +#+        +#+  +#+        +#+  +#+#+# +#+    +#+ +#+    +#+ +#+    +#+     +#+           +#+      +#+ +#+#+ +#+     +#+     +#+  +#+#+#        +#+ 
            #+#    #+# #+#    #+# #+#    #+# #+#    #+# #+#   #+#       #+#   #+#+# #+#    #+# #+#    #+# #+#    #+#     #+#    #+#    #+#       #+#+# #+#+#      #+#     #+#   #+#+# #+#    #+# 
             ########  ###    ###  ########   ########  ###    ###      ###    ####  ########  ###    ### ###    ### ########### ########         ###   ###   ########### ###    ####  ########
               $STANDARTCOLOR
        """.trimIndent())

    }

}

fun ending(heros: MutableList<Hero>, enemies: MutableList<Enemy>) {
    if (enemies.size == 0) {
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


    }
    if (heros.size == 0) {
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
    }

    println("Achja... ")
    println("""
        $RED_BACKGROUND$BLACK_TEXT
         ::::::::  :::    ::: :::    :::  ::::::::  :::    :::      ::::    :::  ::::::::  :::::::::  :::::::::  ::::::::::: ::::::::       :::    :::     ::: :::::::::::      :::::::::: ::::::::       :::::::::  :::::::::: ::::    ::::       :::    ::: ::::::::  ::::    ::::  :::::::::: ::::::::::: :::::::::: ::::    :::      :::::::::: :::::::::  :::            :::     :::    ::: ::::::::: ::::::::::: 
        :+:    :+: :+:    :+: :+:    :+: :+:    :+: :+:   :+:       :+:+:   :+: :+:    :+: :+:    :+: :+:    :+:     :+:    :+:    :+:      :+:    :+:   :+: :+:   :+:          :+:       :+:    :+:      :+:    :+: :+:        +:+:+: :+:+:+      :+:   :+: :+:    :+: +:+:+: :+:+:+ :+:            :+:     :+:        :+:+:   :+:      :+:        :+:    :+: :+:          :+: :+:   :+:    :+: :+:    :+:    :+:     
        +:+        +:+    +:+ +:+    +:+ +:+        +:+  +:+        :+:+:+  +:+ +:+    +:+ +:+    +:+ +:+    +:+     +:+    +:+             +:+    +:+  +:+   +:+  +:+          +:+       +:+             +:+    +:+ +:+        +:+ +:+:+ +:+      +:+  +:+  +:+    +:+ +:+ +:+:+ +:+ +:+            +:+     +:+        :+:+:+  +:+      +:+        +:+    +:+ +:+         +:+   +:+  +:+    +:+ +:+    +:+    +:+     
        +#+        +#++:++#++ +#+    +:+ +#+        +#++:++         +#+ +:+ +#+ +#+    +:+ +#++:++#:  +#++:++#:      +#+    +#++:++#++      +#++:++#++ +#++:++#++: +#+          +#++:++#  +#++:++#++      +#+    +:+ +#++:++#   +#+  +:+  +#+      +#++:++   +#+    +:+ +#+  +:+  +#+ +#++:++#       +#+     +#++:++#   +#+ +:+ +#+      +#++:++#   +#++:++#:  +#+        +#++:++#++: +#+    +:+ +#++:++#+     +#+     
        +#+        +#+    +#+ +#+    +#+ +#+        +#+  +#+        +#+  +#+#+# +#+    +#+ +#+    +#+ +#+    +#+     +#+           +#+      +#+    +#+ +#+     +#+ +#+          +#+              +#+      +#+    +#+ +#+        +#+       +#+      +#+  +#+  +#+    +#+ +#+       +#+ +#+            +#+     +#+        +#+  +#+#+#      +#+        +#+    +#+ +#+        +#+     +#+ +#+    +#+ +#+    +#+    +#+     
        #+#    #+# #+#    #+# #+#    #+# #+#    #+# #+#   #+#       #+#   #+#+# #+#    #+# #+#    #+# #+#    #+#     #+#    #+#    #+#      #+#    #+# #+#     #+# #+#          #+#       #+#    #+#      #+#    #+# #+#        #+#       #+#      #+#   #+# #+#    #+# #+#       #+# #+#            #+#     #+#        #+#   #+#+#      #+#        #+#    #+# #+#        #+#     #+# #+#    #+# #+#    #+#    #+#     
         ########  ###    ###  ########   ########  ###    ###      ###    ####  ########  ###    ### ###    ### ########### ########       ###    ### ###     ### ###          ########## ########       #########  ########## ###       ###      ###    ### ########  ###       ### ##########     ###     ########## ###    ####      ########## ###    ### ########## ###     ###  ########  #########     ###     
    
    $STANDARTCOLOR
    """.trimIndent())
}
