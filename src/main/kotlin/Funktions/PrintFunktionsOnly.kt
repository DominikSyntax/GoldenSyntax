package Funktions

import Enemy
import charakter.Hero
import charakter.OverCharakter
import myTeam

fun loadingPrint() {
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

fun newLine() {
    println()
    println("---------------------------------------------------------------------------")
    println()
    Thread.sleep(1000)

}


fun greeting() {
    newLine()

    println(" Herzlich willkommen bei ...")
    println(
        """ 
$YELLOW_BACKGROUND$BLACK_TEXT      ________ ________  .____     ________  ___________ _______       ______________.___._______________________  ____  ___       $STANDARTCOLOR
$YELLOW_BACKGROUND$BLACK_TEXT     /  _____/ \_____  \ |    |    \______ \ \_   _____/ \      \     /   _____/\__  |   |\      \__    ___/  _  \ \   \/  /       $STANDARTCOLOR
$YELLOW_BACKGROUND$BLACK_TEXT    /   \  ___  /   |   \|    |     |    |  \ |    __)_  /   |   \    \_____  \  /   |   |/   |   \|    | /  /_\  \ \     /        $STANDARTCOLOR 
$YELLOW_BACKGROUND$BLACK_TEXT    \    \_\  \/    |    \    |___  |    `   \|        \/    |    \   /        \ \____   /    |    \    |/    |    \/     \        $STANDARTCOLOR
$YELLOW_BACKGROUND$BLACK_TEXT     \______  /\_______  /_______ \/_______  /_______  /\____|__  /  /_______  / / ______\____|__  /____|\____|__  /___/\  \       $STANDARTCOLOR
$YELLOW_BACKGROUND$BLACK_TEXT            \/         \/        \/        \/        \/         \/           \/  \/              \/              \/      \_/       $STANDARTCOLOR

                                                                                            Golden Syntax 
                                                                                                       by Dominik Weber v 1.1 / 2023
                                                                                            $RED_TEXT  * v1.2 coming soon ... $STANDARTCOLOR 
      
      
* = (das heißt für dich in einfacher Sprache: es wird ${BRIGHT_CYAN_TEXT}NOCH$STANDARTCOLOR besser)
    """
    )
    loadingPrint()
}


fun displayCondition(person: OverCharakter) {
    if (person.healthPower < 1) {
        person.healthPower = 0
    }
    if (person.damagePower < 1) {
        person.damagePower = 0
    }
    val resetColor = STANDARTCOLOR

    // HP Darstellung
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

    var hpInfo = "(${person.healthPower} / ${person.standartHP})"

    // DP Darstellung

    val currentDP = person.damagePower // Erstellen Sie eine separate Variable, um den aktuellen DP zu speichern

    if (currentDP < 1) {
        person.damagePower = 0 // Aktualisieren Sie die tatsächliche Eigenschaft damagePower, falls erforderlich
    }

    val dpBarLength = 20.0f
    val dpPercentage = (100.0f / person.standartDP) * currentDP
    val currentDpBarLength = ((dpPercentage * dpBarLength) / 10.0f).coerceIn(0.0f, dpBarLength)
    val maxDpBarLength = dpBarLength - currentDpBarLength

    var currentDpColor =
        if (dpPercentage > 60.0f) {
            BLUE_BACKGROUND
        } else if (dpPercentage in 30.0f..60.0f) {
            YELLOW_BACKGROUND
        } else
            RED_BACKGROUND

    val maxDpColor = WHITE_BACKGROUND
    val currentDPBar = " ".repeat(currentDpBarLength.toInt())
    val maxDPBar = " ".repeat(maxDpBarLength.toInt())


    var dpInfo = "(${currentDP} / ${person.standartDP})"



    println(
        """
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        ${person.name}'s \n" +
                Lebensenergie : $currentHpColor$currentHPBar$resetColor$maxHpColor$maxHPBar$resetColor $resetColor  $hpInfo
                 
                Schlagkraft:    $currentDpColor$currentDPBar$resetColor$maxDpColor$maxDPBar$resetColor $resetColor  $dpInfo
        - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    """
    )
}


fun chuckNorris(round: Int) {
    if (round == 4) {
        println("$BLUE_TEXT Chuck Norris $STANDARTCOLOR hat von der Bedrohung erfahren.... Die Helden und auch die Bösen fangen an sich zu beeilen, keiner möchte das er wütend wird.")
    } else if (round == 7) {
        println(
            "Es gibt nur eine Theorie darüber, was passiert wenn Chuck Norris böse wird, \n " +
                    "Diese Theorie besagt das  $BLUE_TEXT Chuck Norris $STANDARTCOLOR böse war, weil Gott versucht hat bei 'MENSCH ÄRGER DICH NICHT', zu schummeln. \n" +
                    "Chuck hat mit der flachen Hand auf den Tisch gehauen, das nennen wir heutzutage:\n" +
                    "$RED_BACKGROUND$BLACK_TEXT Die URKNALL THEORIE $STANDARTCOLOR ..."
        )
    } else if (round == 10) {
        println("$BLUE_TEXT Chuck Norris $STANDARTCOLOR hat entschieden, sich erstmal raus zu halten. Als er das letzte mal jemanden angefeuert hat ist der aus respekt in Flammen aufgegangen")
    } else if (round == 20) {
        println(
            "$BLUE_TEXT Chuck Norris $STANDARTCOLOR dauert das nun doch zu lange.... er schaut in die Richtung des Kampfes....\n" +
                    "${RED_TEXT}UND$STANDARTCOLOR\n" +
                    "Alle sind tot umgefallen ! "
        )
        println(
            """
            $BRIGHT_CYAN_TEXT
             ::::::::  :::    ::: :::    :::  ::::::::  :::    :::      ::::    :::  ::::::::  :::::::::  :::::::::  ::::::::::: ::::::::       :::       ::: ::::::::::: ::::    :::  ::::::::  
            :+:    :+: :+:    :+: :+:    :+: :+:    :+: :+:   :+:       :+:+:   :+: :+:    :+: :+:    :+: :+:    :+:     :+:    :+:    :+:      :+:       :+:     :+:     :+:+:   :+: :+:    :+: 
            +:+        +:+    +:+ +:+    +:+ +:+        +:+  +:+        :+:+:+  +:+ +:+    +:+ +:+    +:+ +:+    +:+     +:+    +:+             +:+       +:+     +:+     :+:+:+  +:+ +:+        
            +#+        +#++:++#++ +#+    +:+ +#+        +#++:++         +#+ +:+ +#+ +#+    +:+ +#++:++#:  +#++:++#:      +#+    +#++:++#++      +#+  +:+  +#+     +#+     +#+ +:+ +#+ +#++:++#++ 
            +#+        +#+    +#+ +#+    +#+ +#+        +#+  +#+        +#+  +#+#+# +#+    +#+ +#+    +#+ +#+    +#+     +#+           +#+      +#+ +#+#+ +#+     +#+     +#+  +#+#+#        +#+ 
            #+#    #+# #+#    #+# #+#    #+# #+#    #+# #+#   #+#       #+#   #+#+# #+#    #+# #+#    #+# #+#    #+#     #+#    #+#    #+#       #+#+# #+#+#      #+#     #+#   #+#+# #+#    #+# 
             ########  ###    ###  ########   ########  ###    ###      ###    ####  ########  ###    ### ###    ### ########### ########         ###   ###   ########### ###    ####  ########
               $STANDARTCOLOR
               -Chuck Norris Wins- steht da  
        """.trimIndent()
        )

    }

}

fun endPrint(heros: MutableList<Hero>, enemies: MutableList<Enemy>) {
    var spannung = listOf<String>(".", ".", ".", ".", ".", ".", ".", ".", ".")
    fun useSpannung(s: List<String>) {
        for (point in s) {
            print(point)
            Thread.sleep(150)
        }
    }

    if (allBadsAreDead(enemies)) {
        println(
            """
        $RED_TEXT  
                     ███▄▄▄▄      ▄████████  ▄█  ███▄▄▄▄        ███████
                     ███▀▀▀██▄   ███    ███ ███  ███▀▀▀██▄      ██████
                     ███   ███   ███    █▀  ███▌ ███   ███      ██████
                     ███   ███  ▄███▄▄▄     ███▌ ███   ███      █████
                     ███   ███ ▀▀███▀▀▀     ███▌ ███   ███      ████
                     ███   ███   ███    █▄  ███  ███   ███ 
                     ███   ███   ███    ███ ███  ███   ███      ▄███▄
                      ▀█   █▀    ██████████ █▀    ▀█   █▀       ▀███▀  
                        $STANDARTCOLOR
                                      
        Die guten haben schon wieder gewonnen, aber nicht in meinem Spiel Freundchen. Das kann ich als Programmierer einfach nicht zulassen.
        """
        )
        newLine()
        println(
            """
            Während die Helden alle Feinde, nach und nach besiegt haben , hat Dajjal, heimlich und mit letzter Kraft einen 
            $RED_TEXT
            
                     ▄█   ▄█▄    ▄██████▄     ▄▄▄▄███▄▄▄▄      ▄████████      ███     
                     ███ ▄███▀  ███    ███  ▄██▀▀▀███▀▀▀██▄   ███    ███  ▀█████████▄ 
                     ███▐██▀    ███    ███  ███   ███   ███   ███    █▀      ▀███▀▀██ 
                    ▄█████▀     ███    ███  ███   ███   ███  ▄███▄▄▄          ███   ▀ 
                   ▀▀█████▄     ███    ███  ███   ███   ███ ▀▀███▀▀▀          ███     
                     ███▐██▄    ███    ███  ███   ███   ███   ███    █▄       ███     
                     ███ ▀███▄  ███    ███  ███   ███   ███   ███    ███      ███     
                     ███   ▀██▄  ▀██████▀    ▀█   ███   █▀    ██████████    ▄████▀ 
                       $STANDARTCOLOR
                     (von der größe des Mondes)
                    
            in Richtung gesteuert
                    
                    """
        )
        Thread.sleep(500)
        println()
        println("Keiner auf der Erde merkt etwas, alle freuen sich über die bezwungene Bedrohung und den wieder erhaltenen Frieden auf der Erde")
        println()
        Thread.sleep(500)
        println("Kleine Kinder spielen mit Ihren Eltern auf dem Spielplatz in der Nähe, plötzlich bleiben einige stehen und schauen zum Himmel...")
        println()
        println("Was ist das ?")
        useSpannung(spannung)
        print("Ein Stern?")
        useSpannung(spannung)
        print("Aber es wird so schnell größer")
        println()
        println("Bevor jemand etwas verstanden hat...")

        newLine()
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
        println(
            "Der ganze Planet explodiert, jeder und alles tot..... überall Gedärme und Körperteile im Weltraum, man sieht das Gesicht einer erschrockenen Frau \n" +
                    " sie dreht sich langsam und erst jetzt sieht man das es nur ein halber Kopf ist , der da durch den Weltraum fliegt  .... \n" +
                    "\n" +
                    "$RED_TEXT ENDE! $STANDARTCOLOR"
        )


    }
    if (allGoodsAreDead(myTeam)) {
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
        Thread.sleep(3500)
        println(
            """
          Oh Nooooo ${useSpannung(spannung)}
          
          $MAGENTA_TEXT
               ___  _                   _          __                     _      
              / __\| |__   _   _   ___ | | __   /\ \ \  ___   _ __  _ __ (_) ___ 
             / /   | '_ \ | | | | / __|| |/ /  /  \/ / / _ \ | '__|| '__|| |/ __|
            / /___ | | | || |_| || (__ |   <  / /\  / | (_) || |   | |   | |\__ \
            \____/ |_| |_| \__,_| \___||_|\_\ \_\ \/   \___/ |_|   |_|   |_||___/
            $STANDARTCOLOR
          """.trimIndent()
        )
        println()
        println("Jetzt sind alle tot, einfach aus Respekt, Chuck Norris hat gewonnen, kurz nachdem er gegen Gott 4 Gewinnt in nur 2 Zügen gewonnen hatte")
    }
}


fun showAllHP(myTeam: MutableList<Hero>, enemies: MutableList<Enemy>) {
    for (hero in myTeam) {
        displayCondition(hero)

    }
    for (enemy in enemies) {
        displayCondition(enemy)

    }
}

