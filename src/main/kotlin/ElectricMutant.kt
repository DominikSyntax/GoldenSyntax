/**
 * Tekk ist das Kücken, mit gerade einmal 22 Jahren. Dafür ist er aber auch deutlich schneller als die Anderen
 * Er kann alles, was mit Technik zu tun hat kontrollieren
 */
import Bag

class ElectricMutant(
    override var name: String = "Tekk",
    override var healthPower: Int = 1000,
    override var damagePower: Int = 100
) : Hero(name, healthPower, damagePower) {

    override fun printAllFunktion() {
        println(
            "1 -> Schlagen \n" +
                    "2 -> Treten \n" +
                    "3 ->  Fahrzeugkontrolle \n" +
                    "4 -> NanoBot Hilfe \n" +
                    "5 -> lebendige Kabel \n" +
                    "6 -> Rucksack benutzen"

        )
    }


    override fun attack(bagIsUsed:Boolean,bag:Bag, int: Int, enemies: MutableList<Enemy>, heros: MutableList<Hero>) {
        var isBagUsed = false
        when (int) {
            1 -> punch(evilChoice(enemies))
            2 -> kick(evilChoice(enemies))
            3 -> traficContol(evilChoice(enemies))
            4 -> nanoBots(heroChoice(heros))
            5 -> livingCable(enemies)
            6 -> bag.useBag(heros)
        }
        if (int==6){
            isBagUsed = true
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
            var damage = 0
            damage += ((enemy.healthPower / 100) * (7..10).random()).toInt()
            if (damage == 0) {
                println("Es geht aufs Ende zu mit ${enemy.name}")
                damage = 5
            }
            if (enemy.healthPower > damage) {
                enemy.healthPower -= damage
            } else {
                enemy.healthPower = 0
                println("${enemy.name} wurde besiegt")
                return
            }
            println("Ein Auto hat ${enemy.name} getroffen und ihm $damage Schaden zugefügt")
        }

        if (buses > 0) {
            var damage = 0
            damage += ((enemy.healthPower / 100) * (15..25).random()).toInt()

            if (damage == 0) {
                println("Es geht aufs Ende zu mit ${enemy.name}")
                damage = 15
            }
            if (enemy.healthPower > damage) {
                enemy.healthPower -= damage
            } else {
                enemy.healthPower = 0
                println("${enemy.name} wurde besiegt")
                return
            }
            println("Ein Bus hat ${enemy.name}getroffen und ihm $damage Schaden zugefügt")
        }

        repeat(mopets) {
            var damage = 0
            damage += ((enemy.healthPower / 100) * (3..7).random()).toInt()
            if (damage == 0) {
                println("Es geht aufs Ende zu mit ${enemy.name}")
                damage = 5
            }
            if (enemy.healthPower > damage) {
                enemy.healthPower -= damage
            } else {
                enemy.healthPower = 0
                println("${enemy.name} wurde besiegt")
                return
            }
            println("Ein Roller hat ${enemy.name}getroffen und ihm $damage Schaden zugefügt")
        }
    }

    /**
     * lässt sich nur 1x im Spiel für einen helden einsetzen
     * pro runde 2% Lebensenergie zurück, für 20 Runden
     * damagePower + 10%
     */
    fun nanoBots(hero: Hero) {
        hero.damagePower += (hero.damagePower / 100 * 10).toInt()
        println("${hero.name} hat durch die NanoBots 10% an Schlagkraft gewonnen")

    }

    fun livingCable(enemies: MutableList<Enemy>) {
        println("Strom-, Telefon- , und wer weiß, was noch für Kabel, tauchen aus der Erde auf, kommen aus den Wänden der Häuser und von den Überlandleitungen ")
        for (enemy in enemies) {
            var deduction: Int = (7..25).random()
            var deductionTwo = (25..50).random()

            if (enemy.damagePower > deduction) {
                enemy.damagePower -= deduction
                println(" ... einige Kabel halten ${enemy.name} fest. Seine Angiffskraft sinkt um $deduction Punkte...")
            } else {
                println("... einige Kabel halten ${enemy.name} fest. Seine Angiffskraft sind ist auf 0 gesunken... ")
                enemy.damagePower = 0
            }
            if (enemy.healthPower > deductionTwo) {
                enemy.healthPower -= deductionTwo
                println(".. oh, da war wohl ein Starkstromkabel mit dabei. ${enemy.name} hat $deductionTwo Punkte Lebenskraft abgezogen")
            } else {
                println(".. oh, das war wohl ein Starkstromkabel zuviel ${enemy.name} ist in Rauch aufgegangen. ")
                enemy.damagePower = 0
            }


        }

    }

}