/**
 * Die Heldin Gaia ist ein Natur-Mutant, das bedeutet, Sie hat die Kraft, alles was mit der Natur zu tun hat, zu beeinflussen.
 * Wind, Pflanzen und sogar die Erde selbst hören auf Sie.
 */
class NatureMutant(
    override var name: String,
    override var healthPower: Int = 1000,
    override var damagePower: Int = 100,
) : Hero(name, healthPower, damagePower) {
    override fun printAllFunktion() {
        super.printAllFunktion()
        println("3 -> thunderStorm : Lässt ein Gewitter aufziehen und Blitze auf die Gegner nieder \n" +
                "4 -> poisonRoots:    ")
    }

    /**
     * Die Methode thunderStorm soll zwischen 1 und 3 Blitze auf den Gegner schleudern
     * @param enemy
     * @return enemy.healthPower
     */
    fun thunderStorm(enemys: MutableList<Enemy>) {
        for (enemy in enemys) {
            if (enemy.healthPower > 0) {
                println("Es ziehen dunkle Wolken auf ...")
                var shocksInt = (1..3).random()
                var abzug = (25..50).random()

                repeat(shocksInt) {
                    if (enemy.healthPower >= abzug) {
                        println("Ein Blitz hat ${enemy.name} getroffen, $abzug Punkte wurden von seiner HP abgezogen")
                        enemy.healthPower -= abzug
                    } else {
                        println("Die Blitze haben Ihm den Rest gegeben")
                        println("${enemy.name} hat keine Lebensenergie mehr")
                        enemy.healthPower = 0
                    }
                }
            }else
                println("Die Leiche von ${enemy.name} hat Glück, Tote ziehen keine Blitze an ")
        }









        /**
         * Die Methode Gift Wurzeln, schränkt die Bewegung des Gegners ein, er hat nur die Möglichkeit, sich zu befreien, zu heilen oder einen gegenangriff zu starten, der aber nur 50 % seiner normalen Stärke hat.
         * Zusätzlich verursacht diese Methode zwischen 3 und 5 Runden einen Gift-Schaden von je 7 % Lebensenergie.
         *@param enemy
         */
        fun poisonRoots(enemy: Enemy, round: Int) {
            var roundStart = round
            // random rounds, die die Lebenspunkte abgezogen werden
            var randomRounds = (1..5).random()

            println("Die Wurzeln haben ${enemy.name} fest im Giff, für ${randomRounds + 1} Runden werden ihm Lebenspunkte abgezogen")

            var endRound = round + randomRounds

            while (roundStart < round + randomRounds) {
                var abzug = 0
                if (enemy.healthPower == 0) {
                    println("${enemy.name} hat keine Lebenspunkte mehr")
                    break
                } else if (enemy.healthPower <= 200) {
                    println("${enemy.name} hat unter 200 Lebenspunkte, ab jetzt ziehen die Wurzeln nur noch 15 Lebenspunkte ab")
                    abzug += 15
                } else {
                    abzug += enemy.healthPower / 100 * 7
                    println("${enemy.name} hat über 200 Lebenspunkte, ihm werden 7% Lebensenergie abgezogen")
                }
                if (enemy.healthPower >= abzug) {
                    enemy.healthPower -= abzug
                } else {
                    enemy.healthPower = 0
                }
                roundStart++
            }
            if (enemy.healthPower > 0) {
                for (i in round..round) {
                    enemy.damagePower / 100 * 50
                    println("${enemy.name} ist geschwächt, er hat nur die hälfte seiner Angriffskraft ")
                }
            }
        }

        /**
         *
         */
        fun healing(heros: MutableList<Hero>) {
            for (hero in heros) {
                hero.healthPower += hero.healthPower / 100 * (7..10).random()
            }

        }
    }