/**
 * Die Heldin Gaia ist ein Natur-Mutant, das bedeutet, Sie hat die Kraft, alles Erdenkliche was mit der natur zu tun hat, zu beeinflussen.
 * Wind, Pflanzen und sogar die Erde selbst hören auf Sie.
 */
class NatureMutant(name: String, healthPower:Int, speed:Int):Hero(name,healthPower,speed) {

    override var name: String = "Gaia"


    /**
     * Die Methode Gift Wurzeln, schränkt die Bewegung des Gegners ein, er hat nur die Möglichkeit, sich zu befreien, zu heilen oder einen gegenangriff zu starten, der aber nur 25 % seiner normalen Stärke hat.
     * Zusätzlich verursacht diese Methode zwischen 3 und 5 Runden einen Gift-Schaden von je 7 % Lebensenergie.
     *@param enemy
     */
    fun poisonRoots(enemy: Enemy){

        // random rounds, die die Lebenspunkte abgezogen werden
        var randomRounds:Int = (3..5).random()
        var deduction = enemy.healthPower/100 * 7


        // if enemy Angriff() = Angiff()-75 % für 1 Runde


        // enemy.speed = 30
        enemy.speed = 30

    }
}