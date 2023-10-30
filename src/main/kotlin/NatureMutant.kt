/**
 * Die Heldin Gaia ist ein Natur-Mutant, das bedeutet, Sie hat die Kraft, alles was mit der Natur zu tun hat, zu beeinflussen.
 * Wind, Pflanzen und sogar die Erde selbst hören auf Sie.
 */
class NatureMutant():Hero(name = "Gaia",healthPower=1000, damagePower = 100) {


    /**
     * Die Methode thunderStorm soll zwischen 1 und 3 Blitze auf den Gegner schleudern
     * @param enemy
     */
    fun thunderStorm(enemy: Enemy){
        println("Es ziehen dunkle Wolken auf über Gaia und ihren Freunden...")
        var shocksInt = (1..3).random()

        repeat(shocksInt){
            enemy.healthPower -= enemy.healthPower/100 * (7..12).random()
        }
    }




    /**
     * Die Methode Gift Wurzeln, schränkt die Bewegung des Gegners ein, er hat nur die Möglichkeit, sich zu befreien, zu heilen oder einen gegenangriff zu starten, der aber nur 50 % seiner normalen Stärke hat.
     * Zusätzlich verursacht diese Methode zwischen 3 und 5 Runden einen Gift-Schaden von je 7 % Lebensenergie.
     *@param enemy
     */
    fun poisonRoots(enemy: Enemy){

        // random rounds, die die Lebenspunkte abgezogen werden
        var randomRounds:Int = (3..5).random()
        var deduction = enemy.healthPower/100 * 7


        //  enemy damagePower -50 % für 1 Runde



    }

    /**
     *
     */
    fun healing(heros:MutableList<Hero>){
        for (hero in heros){
            hero.healthPower += hero.healthPower/100 * (7..10).random()
        }

    }
}