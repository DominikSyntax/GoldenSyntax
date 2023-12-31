import charakter.Hero

open class Bag() {

    var healingDrinkInt = 3
    var vitaminsInt = 1
    var bagIsUsed = false


    /**
     * Kann nur 1x pro Runde eingesetzt werden, anstelle einer anderen Funktion
     */
    open fun useBag(heros: MutableList<Hero>) {
        if (bagIsUsed) {
            println("Das geht diese Runde nicht mehr")
        } else {

            println("Im eurem Beutel befinden sich $healingDrinkInt Heiltränke und $vitaminsInt Vitamine.")
            println()
            println(
                "Ein Heiltrank erhöht die Lebenspunkte eines Helden um die Hälfte seiner ursprünglichen HP. \n " +
                        "Die Vitaminen geben einem Helden dauerhaft 10 % mehr Schadenskraft"
            )
            println()
            println("Du kannst die Dinge, aus deinem Beutel, nur bei lebendigen Helden anwenden. Wir haben leider niemanden , der unsere gefallenen Freunde zurück holt.")

            println("Bitte geben Sie 1 für Heiltrank und 2 für Vitamine ein")

            var userInput: Int
            var userHeroInput: Int

            try {
                userInput = readln().toInt()
            } catch (e: NumberFormatException) {
                println("Zahlen Junge.... das sind die Dinger hinter dem Minus auf deinem Konto")
                return
            }
            if (userInput == 1 || userInput == 2) {
                if (userInput == 1) {
                    if (healingDrinkInt > 0) {
                        println("Welchen Helden möchtest du heilen?")
                        println()
                        var counter = 1
                        for (hero in heros) {
                            if (hero.isDead) {
                                println("Für ${hero.name} kommt jede hilfe zu spät")
                            } else {
                                println("$counter für ${hero.name}")
                                counter++
                            }
                        }
                        counter = 1
                        try {
                            userHeroInput = readln().toInt()
                        } catch (e: NumberFormatException) {
                            println("Nur Chuck Norris darf hier eingeben , was er möchte. Für dich gelten andere Regeln .... Zahlen Junge .... 1,2 oder 3  ob du wirklich richtig wählst, siehst du wenn diese meldung nicht kommt ")
                            return // wird zurück zur Eingabe geleitet
                        }


                        var userHero = heros[userHeroInput - 1]


                        if (heros.size < userHeroInput) {
                            println(" So viele Helden hast du gar nicht")
                            return // wird zurück zur Eingabe geleitet

                        } else {
                            if (userHero.isDead) {
                                println("Ich hatte dir bereits gesagt, dass man toten Helden nicht mehr helfen kann")
                            } else {
                                var healtPlus = userHero.standartHP / 2
                                userHero.healthPower += healtPlus
                                println("${userHero.name} erhält $healtPlus Lebensenergie")
                                healingDrinkInt--
                                this.bagIsUsed = true

                            }

                        }
                    } else
                        println("Du hast keine Heiltränke mehr")


                }
                if (userInput == 2) {
                    if (vitaminsInt > 0) {
                        println("Welchen Helden möchtest du heilen?")
                        println()
                        var counter = 1
                        for (hero in heros) {
                            if (hero.isDead) {
                                println("Für ${hero.name} kommt jede hilfe zu spät")
                            } else {
                                println("$counter für ${hero.name}")
                                counter++
                            }
                        }
                        counter = 1

                        try {
                            userHeroInput = readln().toInt()
                        } catch (e: NumberFormatException) {
                            println("Du kennst den Unterschied zwischen Zahlen und Buchstaben? Ich möchte eine Zahl du Experte.")
                            return // wird zurück zur Eingabe geleitet
                        }


                        var userHero = heros[userHeroInput - 1]

                        if (heros.size > userHeroInput) {
                            println(" So viele Helden hast du gar nicht")
                            return // wird zurück zur Eingabe geleitet

                        } else {
                            if (userHero.isDead) {
                                println("Ein toter Held kann niemanden angreifen, verschwenden wir also nicht die Vitamine an ihn ")
                            } else {
                                var damagePlus = (userHero.damagePower / 100 * 10).toInt()
                                userHero.damagePower += damagePlus
                                println("${userHero.name} erhält $damagePlus Schadensenergie")
                                vitaminsInt = 0
                                this.bagIsUsed = true

                            }
                        }

                    } else
                        println("Du hast keine Vitamine mehr")

                }
            } else {
                println("1 oder 2 nicht $userInput , ich weiß , du würdest uns gerne mitteilen das du nur $userInput sek beim Sex durchhälst, hier geht es aber um das Spiel. Such dir eine Selbsthilfegruppe")
            }
        }


    }

}
