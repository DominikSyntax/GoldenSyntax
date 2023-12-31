package charakter

import Funktions.BLUE_TEXT
import Bag
import Enemy
import Funktions.STANDARTCOLOR
import cableCounter
import Funktions.evilChoice
import Funktions.heroChoice

class ElectricMutant(
    override var name: String = "Tekk",
    override var healthPower: Int = 1000,
    override var damagePower: Int = 100
) : Hero(name, healthPower, damagePower) {

    override var nanoAreUsed = false
    override var otherHeroHaveNanos = false
    override var endbossFluch: Boolean = false
    override var standartHP: Int = healthPower
    override val standartDP: Int = damagePower

    override var isDead: Boolean = false
    override var witchPoisen = false




    override fun printInfo() {
        println("""$BLUE_TEXT
            ::::::::::: :::::::::: :::    ::: :::    :::      
                :+:     :+:        :+:   :+:  :+:   :+:       
                +:+     +:+        +:+  +:+   +:+  +:+        
                +#+     +#++:++#   +#++:++    +#++:++         
                +#+     +#+        +#+  +#+   +#+  +#+        
                #+#     #+#        #+#   #+#  #+#   #+#       
                ###     ########## ###    ### ###    ###      
        $STANDARTCOLOR""".trimIndent())
        super.printInfo()
        println("... einen starken Elektro Mutanten. Mit der Fähigkeit alles was irgendwie mit Technik zu tun hat zu kontrollieren. ")
    }

    override fun printAllFunktion(bag: Bag) {
        if (bag.bagIsUsed) {
            println()
            println(
                "1 -> Schlagen \n" +
                        "2 -> Treten \n" +
                        "3 -> Fahrzeugkontrolle \n" +
                        "4 -> lebendige Kabel (nur 1x pro Gegner verfügbar)\n" +
                        "5 -> NanoBot Hilfe \n" +
                        "6 -> nicht verfügbar "
            )
        } else if (bag.bagIsUsed && nanoAreUsed) {
            println(
                "" +
                        "1 -> Schlagen \n" +
                        "2 -> Treten \n" +
                        "3 -> Fahrzeugkontrolle \n" +
                        "4 -> lebendige Kabel (nur 1x pro Gegner verfügbar)\n" +
                        "5 -> nicht verfügbar \n" +
                        "6 -> nicht verfügbar"
            )
        } else if (nanoAreUsed) {
            println(
                "1 -> Schlagen \n" +
                        "2 -> Treten \n" +
                        "3 -> Fahrzeugkontrolle \n" +
                        "4 -> lebendige Kabel(nur 1x pro Gegner verfügbar)\n" +
                        "5 -> nicht verfügbar \n" +
                        "6 -> Rucksack benutzen"
            )
        } else {
            println(
                "1 -> Schlagen \n" +
                        "2 -> Treten \n" +
                        "3 -> Fahrzeugkontrolle \n" +
                        "4 -> lebendige Kabel (nur 1x pro Gegner verfügbar)\n" +
                        "5 -> NanoBot Hilfe \n" +
                        "6 -> Rucksack benutzen"

            )
        }
    }


    override fun attack(bag: Bag, int: Int, enemies: MutableList<Enemy>, heros: MutableList<Hero>) {
        if (nanoAreUsed) {
            println("Die Nano Bots wurden schon benutzt, sie können nur 1x im Spiel eingesetzt werden.")
        }
        if (bag.bagIsUsed) {
            when (int) {
                1 -> punch(evilChoice(enemies))
                2 -> kick(evilChoice(enemies))
                3 -> traficContol(evilChoice(enemies))
                4 -> livingCable(evilChoice(enemies))
                5 -> nanoBots(heros, heroChoice(heros))
            }

        } else {
            when (int) {
                1 -> punch(evilChoice(enemies))
                2 -> kick(evilChoice(enemies))
                3 -> traficContol(evilChoice(enemies))
                4 -> livingCable(evilChoice(enemies))
                5 -> nanoBots(heros, heroChoice(heros))
                6 -> bag.useBag(heros)
            }
        }


    }

    /**
     * Jedes Fahrzeug im Umkreis beschleunigt und wird in Richtung des Gegners gelenkt
     * @param enemy
     */
    fun traficContol(enemy: Enemy) {
        var cars = (3..5).random()
        var buses = 1
        var mopets = 3

        println("OMG, schau dir die Fahrzeuge an! $cars Autos , $buses Bus und $mopets Roller beschleunigen sich wie von Zauberhand Richtung ${enemy.name}")
        if (enemy.name == "Dajjal") {
            buses = 0
            println("Oh nein, Dajjal konnte den Bus in Staub verwandeln ")
            cars = 3
            mopets = 2
        }

        repeat(cars) {
            var damage = 10
            damage += (((enemy.healthPower / 100) * (7..10).random()) / 100 * damagePower).toInt()


            if (enemy.healthPower > damage) {
                enemy.healthPower -= damage
            } else {
                enemy.healthPower = 0
                Thread.sleep(500)
                println("${enemy.name} wurde von einem Auto zerfetzt! Durch die Wucht des Aufpralls, sind seine umherfliegenden Knochensplitter \n" +
                        "selbst zu geschossen geworden und haben einem Passanten, den halben Kopf zerfetzt. Die daneben stehende Frau konnte nicht lange trauern,\n" +
                        "da ihr die platzende Schädeldecke ihres Mannes die Hauptschlagader aufgerissen hat")
                Thread.sleep(1500)
                return
            }
            println("Ein Auto hat ${enemy.name} getroffen und ihm $damage Schaden zugefügt")
        }

        if (buses > 0) {
            var damage = 20
            damage += (((enemy.healthPower / 100) * (15..25).random()) / 100 * damagePower).toInt()


            if (enemy.healthPower > damage) {
                enemy.healthPower -= damage
            } else {
                enemy.healthPower = 0
                println("${enemy.name} wurde frontal von dem Bus erwischt, es sah aus wie eine Wassermelone in die man eine Handgranate gesteckt hat.\n" +
                        "Das Blut hat sich in der Luft so sehr verteilt, das es unseren Helden als willkommene abkühlung dient  ")
                return
            }
            println("Ein Bus hat ${enemy.name}getroffen und ihm $damage Schaden zugefügt")
        }

        repeat(mopets) {
            var damage = 5
            damage += ((enemy.healthPower / 100) * (3..7).random()/100 * damagePower).toInt()

            if (enemy.healthPower > damage) {
                enemy.healthPower -= damage
            } else {
                enemy.healthPower = 0
                println("Absolut lächerlich, ${enemy.name} wurde von einem Moppet in zwei Teile gerissen, ober und unterkörper. \n" +
                        "${enemy.name} lebte zwar noch ein bisschen aber ist so ungünstig gelandet, das er an seinem in den Hals fliesenden Blut ertrunken oder erstickt ist,\n" +
                        " er hatte keine Lippen und keine Nase mehr im sich gegen das in den Hals laufende Blut zu schützen. ")
                println("nach 15min kam aber kein zucken mehr" )
                return
            }
            println("Ein Roller hat ${enemy.name}getroffen und ihm $damage Schaden zugefügt")
        }
    }

    /**
     * lässt sich nur 1x im Spiel für einen helden einsetzen
     * pro runde 2% Lebensenergie zurück
     * damagePower + 10%
     */
    fun nanoBots(heros: MutableList<Hero>, hero: Hero) {
        if (hero.otherHeroHaveNanos) {
            println("Nano Bots geht nur 1x im Spiel ")
        } else {
            hero.damagePower += (hero.damagePower / 100 * 10).toInt()
            println("${hero.name} hat durch die NanoBots 10% an Schlagkraft gewonnen")
            if (hero.healthPower > 0) {
                var healing = hero.healthPower / 100 * 2
                hero.healthPower += healing
            } else {
                println("Nicht einmal Nano Bots aus lauter kleinen Chuck Norris könnten deinem Held jetzt noch helfen ")
            }
            hero.nanoAreUsed = true
            for (hero in heros) {
                hero.otherHeroHaveNanos = true
            }
        }

    }

    fun livingCable(enemy: Enemy) {
        var randomRounds = (3..5).random()
        if (!enemy.cable) {
            println("Strom-, Telefon- , und wer weiß, was noch für Kabel, tauchen aus der Erde auf, kommen aus den Wänden der Häuser und von den Überlandleitungen ")
            enemy.cable = true
            cableCounter = randomRounds

        } else
            println("Du kannst diesen Angriff nicht 2x beim selben Gegner machen")
    }


}