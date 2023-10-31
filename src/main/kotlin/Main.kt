
fun main() {
    var heroOne = NatureMutant("Domi")
    var heroTwo = ElectricMutant("Domi unter Strom")
    var enemyOne = Endboss()
    var roundCounter = 1

    heroOne.poisonRoots(enemyOne,roundCounter)
    println("Das war Runde $roundCounter")

    /*while (enemyOne.healthPower>0){
        for (i in roundCounter..roundCounter){
            var twoPerCent= (heroOne.healthPower/100 *2).toInt()
            heroOne.healthPower += twoPerCent
            println("${heroOne.name} hat $twoPerCent Lebenspunkte durch die Nano Bots bekommen")
        }




        heroTwo.traficContol(enemyOne)
        heroOne.thunderStorm(enemyOne)
        println(enemyOne.healthPower)
        println("Das war Runde $roundCounter")
        roundCounter++
    }*/
}


