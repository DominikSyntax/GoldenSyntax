package charakter

import Bag
import Enemy
import Funktions.RED_TEXT
import Funktions.STANDARTCOLOR
import Funktions.evilChoice

class GunNut(
    override var name: String = "Jonny Rambo",
    override var healthPower: Int = 1500,
    override var damagePower: Int = 150
) : Human(name, healthPower, damagePower) {

    override var isDead: Boolean = false

    override var nanoAreUsed = false
    override var otherHeroHaveNanos = false
    override var endbossFluch: Boolean = false
    override var witchPoisen = false
    override var standartHP: Int = healthPower
    override val standartDP: Int = damagePower


    override fun printInfo() {
        println(
            """
            ================================================================================================================
            =====    ====    ====  =======  ==  =======  ==  ====  =======       ======  =====  =====  ==      ======    ===
            ======  ====  ==  ===   ======  ==   ======  ==   ==   =======  ====  ====    ====   ===   ==  ===  ====  ==  ==
            ======  ===  ====  ==    =====  ==    =====  ===  ==  ========  ====  ===  ==  ===  =   =  ==  ====  ==  ====  =
            ======  ===  ====  ==  ==  ===  ==  ==  ===  ===  ==  ========  ===   ==  ====  ==  == ==  ==  ===  ===  ====  =
            ======  ===  ====  ==  ===  ==  ==  ===  ==  ====    =========      ====  ====  ==  =====  ==      ====  ====  =
            ======  ===  ====  ==  ====  =  ==  ====  =  =====  ==========  ====  ==        ==  =====  ==  ===  ===  ====  =
            =  ===  ===  ====  ==  =====    ==  =====    =====  ==========  ====  ==  ====  ==  =====  ==  ====  ==  ====  =
            =  ===  ====  ==  ===  ======   ==  ======   =====  ==========  ====  ==  ====  ==  =====  ==  ===  ====  ==  ==
            ==     ======    ====  =======  ==  =======  =====  ==========  ====  ==  ====  ==  =====  ==      ======    ===
            ================================================================================================================
            
        """.trimIndent()
        )
        super.printInfo()
        println("... zwar nur einen Menschen, aber einen absoluten Waffen Spezialisten ")
    }

    override fun printAllFunktion(bag: Bag) {
        if (bag.bagIsUsed) {
            println(
                "1 -> Schlagen \n" +
                        "2 -> Treten \n" +
                        "3 -> Bazooka \n" +
                        "4 -> Maschinengewähr \n" +
                        "5 -> Luftschlag \n"
            )
        } else {
            println(
                "1 -> Schlagen \n" +
                        "2 -> Treten \n" +
                        "3 -> Bazooka \n" +
                        "4 -> Maschinengewähr \n" +
                        "5 -> Luftschlag \n" +
                        "6 -> Rucksack benutzen"
            )
        }
    }

    override fun attack(bag: Bag, int: Int, enemies: MutableList<Enemy>, heros: MutableList<Hero>) {
        if (bag.bagIsUsed) {
            when (int) {
                1 -> punch(evilChoice(enemies))
                2 -> kick(evilChoice(enemies))
                3 -> bazooka(evilChoice(enemies))
                4 -> machineGun(evilChoice(enemies))
                5 -> airstrike(enemies)
            }
        } else {
            when (int) {
                1 -> punch(evilChoice(enemies))
                2 -> kick(evilChoice(enemies))
                3 -> bazooka(evilChoice(enemies))
                4 -> machineGun(evilChoice(enemies))
                5 -> airstrike(enemies)
                6 -> bag.useBag(heros)
            }
        }

    }

    fun bazooka(enemy: Enemy) {
        println("$name muss auch immer übertreiben, ich will gar nicht wissen wo er diese Bazooka versteckt hat, mir ist sie vorher nicht aufgefallen..... ")
        val hitOrNot = listOf(1, 2, 3,2,3,3,1,1,2,3,)
        var isItAHitorNot = hitOrNot.random()
        var damage = 0

        when (isItAHitorNot) {
            1 -> {
                damage = (100..150).random()
                println(".... Volltreffer! ${enemy.name} wurde mit voller Wucht getroffen...  ")

            }

            2 -> {
                val target = listOf(3,1,2,3)
                var hit = target.random()
                println("... voll daneben, ${enemy.name} konnte dem Geschoss ausweichen.")
                when (hit) {
                    1 -> {
                        println(
                            "Dieses ist weiter geflogen und hat ein älteres Pärchen, welches sich gerade in Sicherheit bringen wollte, in 1000 blutige \n" +
                                    "Einzelteile zerlegt. Die Hände der beiden liegen aber fest zusammenhaltend auf der Straße... ${RED_TEXT}total Romantisches Ende fürt die zwei  $STANDARTCOLOR \uD83E\uDD70"
                        )
                    }

                    2 -> {
                        println(
                            "Dieses ist weiter geflogen und hat und hat ein gerade ankommendes Auto der Polizei in die Luft gejagt. \n" +
                                    "Man sieht in den Flammen noch das ein oder andere zerlaufende und schreiende Gesicht... naja, lange wird das gejammer wohl nicht mehr dauern, sieht echt warm aus in dem Auto"
                        )
                    }

                    3 -> {
                        println("Dieses ist weiter geflogen und ist in ein Gebäude in der Nähe eingeschlagen...")
                        Thread.sleep(500)
                        val buildings = listOf(1,2,1,3,3)
                        var hitBuilding = buildings.random()

                        when (hitBuilding) {
                            1 -> {
                                println(
                                    "... Brennende Menschen springen aus den Fenstern, in der Hoffnung draußen wäre es besser. \n" +
                                            "Durch den Einschlag wurde aber die Gasleitung in der Nähe beschädigt und die brennenden Menschen lösen eine riesen Explosion aus , die auch umher rennende Menschen in flammen aufgehen lässt."
                                )
                            }

                            2 -> {
                                println("...Zum Glück ein leerstehendes")
                            }

                            3 -> {
                                println(
                                    "... oh nein, sieht aus als wäre es eine Schule gewesen. Die Eltern, die gerade Ihre Kinder in Sicherheit bringen wollten, \n" +
                                            "können nun erstmal die schreienden und brennenden Menschen , die aus dem Haus rennen, löschen und hoffen das ihr Kind unter den wenigen überlebenden ist.  "
                                )
                            }
                        }
                    }
                }

            }

            3 -> {
                var splitter = (2..7).random()
                var splitterdamage = (10..25).random()
                println("... ${enemy.name} wurde nur von $splitter Splittern getroffen.")
                damage = splitter * splitterdamage
            }
        }
        Thread.sleep(1000)
        if (enemy.healthPower < damage) {
            enemy.healthPower = 0
            enemy.isDead = true
            println("... Das war zuviel für ${enemy.name}. Wer rechnet auch mit einer Bazooka ")

        } else {
            enemy.healthPower -= damage
            println(
                "... Bazookas hauen ganz schön rein, falls die Erde den Kampf übersteht, hol ich mir auch eine \n" +
                        "Achso, ${enemy.name} werden $damage Lebenspunkte abgezogen "
            )

        }
    }

    fun machineGun(enemy: Enemy) {
        println("$name holt sein aufgemotztes Maschinen Gewehr raus zud hält auf ${enemy.name} drauf.... ")
        Thread.sleep(1000)
        println("... der Lauf glüht, das Magazin mit 150 Schuss ist innerhalb von 30 Sekunden leer....")
        var bullets = (7..34).random()
        println("$bullets haben ${enemy.name} getroffen !")

        var damage = (5..15).random()
        var totalDamage = (((bullets * damage) / 100) * damagePower).toInt()
        if (enemy.healthPower < totalDamage) {
            enemy.healthPower = 0
            enemy.isDead = true
            println("Das waren wohl zuviele Kugeln, der Körper ist total zerfetzt und nichteinmal ${enemy.name}'s Mutter würde in dieser Pampe noch etwas erkennen.")
        } else {
            enemy.healthPower -= totalDamage
            println(" Das waren ein paar schwere treffer, $totalDamage Lebenspunkte werden ${enemy.name} abgezogen")
        }

    }

    fun airstrike(enemies: MutableList<Enemy>) {
        println("$name hat Luftunterstützung angefordert....")
        var damage: Int
        for (enemy in enemies) {
            damage = ((enemy.standartHP / 100) * (9..35).random() / 100 * damagePower).toInt()
            if (damage >= enemy.healthPower) {
                println("Der Luftschlag war zuviel für ${enemy.name}")
                println()
                Thread.sleep(1500)
                enemy.healthPower = 0
                enemy.isDead = true
            } else {
                if (damage <= 35) {
                    damage = (5..35).random()
                    println("${enemy.name} hatte Glück und nur ein kleiner Splitter abbekommen. $damage Schaden ")
                    println()
                } else if (damage <= 150 && damage > 35) {
                    println("${enemy.name} hat einige Tiefe Fleischwunden. $damage Schaden ")
                    println()
                } else if (damage > 150) {
                    println("Der Luftschlag hat ${enemy.name} hart getroffen. $damage Schaden ")
                    println()
                }
                enemy.healthPower -= damage
                Thread.sleep(1500)
            }
        }
    }


}