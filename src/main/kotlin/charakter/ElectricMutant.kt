package charakter

/**
 * Tekk ist das Kücken, mit gerade einmal 22 Jahren. Dafür ist er aber auch deutlich schneller als die Anderen
 * Er kann alles, was mit Technik zu tun hat kontrollieren
 */
import Bag
import Enemy
import evilChoice
import heroChoice

class ElectricMutant(
    override var name: String = "Tekk",
    override var healthPower: Int = 1000,
    override var damagePower: Int = 100
) : Hero(name, healthPower, damagePower) {

    override var nanoAreUsed = false
    override var otherHeroHaveNanos =false
    override var endbossFluch: Boolean = false


    override fun printInfo(){
        println("""
            _________        _______           ___  __            ___  __       
            |\___   ___\     |\  ___ \         |\  \|\  \         |\  \|\  \     
            \|___ \  \_|     \ \   __/|        \ \  \/  /|_       \ \  \/  /|_   
                 \ \  \       \ \  \_|/__       \ \   ___  \       \ \   ___  \  
                  \ \  \       \ \  \_|\ \       \ \  \\ \  \       \ \  \\ \  \ 
                   \ \__\       \ \_______\       \ \__\\ \__\       \ \__\\ \__\
                    \|__|        \|_______|        \|__| \|__|        \|__| \|__|                        
                                             
 __   _    _    __   _  _     _       _      
 //_//_`  /_`/ /// //_//_`  //_`  /|// /| | |
// //_,  /  /_///_// \/_,  /._/  / |/_/ |/|/ 
            
        """.trimIndent())
        super.printInfo()
        println("... einen starken Elektro Mutanten. Mit der Fähigkeit alles was irgendwie mit Technik zu tun hat zu kontrollieren. ")
    }
    override fun printAllFunktion(bag: Bag) {
        if (bag.bagIsUsed) {
            println("Der Rucksack ist in dieser Runde nicht mehr verfügbar")
            println(
                "1 -> Schlagen \n" +
                        "2 -> Treten \n" +
                        "3 -> Fahrzeugkontrolle \n" +
                        "4 -> NanoBot Hilfe \n" +
                        "5 -> lebendige Kabel \n"
            )
        } else if (bag.bagIsUsed && nanoAreUsed) {
            println(
                "" +
                        "1 -> Schlagen \n" +
                        "2 -> Treten \n" +
                        "3 -> Fahrzeugkontrolle \n" +
                        "4 -> NanoBot NICHT VERFÜGBAR \n" +
                        "5 -> lebendige Kabel \n"
            )
        } else if (nanoAreUsed) {
            println(
                "1 -> Schlagen \n" +
                        "2 -> Treten \n" +
                        "3 -> Fahrzeugkontrolle \n" +
                        "4 -> NanoBot NICHT VERFÜGBAR \n" +
                        "5 -> lebendige Kabel \n" +
                        "6 -> Rucksack benutzen"
            )
        } else {
            println(
                "1 -> Schlagen \n" +
                        "2 -> Treten \n" +
                        "3 -> Fahrzeugkontrolle \n" +
                        "4 -> NanoBot Hilfe \n" +
                        "5 -> lebendige Kabel \n" +
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
                4 -> nanoBots(heros,heroChoice(heros))
                5 -> livingCable(enemies)
            }

        } else {
            when (int) {
                1 -> punch(evilChoice(enemies))
                2 -> kick(evilChoice(enemies))
                3 -> traficContol(evilChoice(enemies))
                4 -> nanoBots(heros,heroChoice(heros))
                5 -> livingCable(enemies)
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
            var damage = 0
            damage += (((enemy.healthPower / 100) * (7..10).random())/100 * damagePower).toInt()
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
            damage += (((enemy.healthPower / 100) * (15..25).random())/100 * damagePower).toInt()

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
     * pro runde 2% Lebensenergie zurück
     * damagePower + 10%
     */
    fun nanoBots(heros: MutableList<Hero>, hero: Hero) {
        if (hero.otherHeroHaveNanos){
            println("Nano Bots geht nur 1x im Spiel ")
        }else {
            hero.damagePower += (hero.damagePower / 100 * 10).toInt()
            println("${hero.name} hat durch die NanoBots 10% an Schlagkraft gewonnen")
            if (hero.healthPower>0) {
                var healing = hero.healthPower / 100 * 2
                hero.healthPower += healing
            }else {
                println("Nicht einmal Nano Bots aus lauter kleinen Chuck Norris könnten deinem Held jetzt noch helfen ")
            }
            hero.nanoAreUsed = true
            for  (hero in heros) {
                hero.otherHeroHaveNanos = true
            }
        }

    }

    fun livingCable(enemies: MutableList<Enemy>) {
        println("Strom-, Telefon- , und wer weiß, was noch für Kabel, tauchen aus der Erde auf, kommen aus den Wänden der Häuser und von den Überlandleitungen ")
        for (enemy in enemies) {
            var deduction: Int = ((7..25).random()/100 * damagePower).toInt()
            var deductionTwo = ((25..50).random()/100 * damagePower).toInt()

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