
fun main() {
    var heroOne = NatureMutant("Domi")
    var heroTwo = ElectricMutant("Domi unter Strom")
    var enemyOne = Endboss()
    var roundCounter = 1


    while (enemyOne.healthPower>0){

        heroTwo.traficContol(enemyOne)
        heroOne.thunderStorm(enemyOne)
        println(enemyOne.healthPower)
        println("Das war Runde $roundCounter")
        roundCounter++
    }
}


