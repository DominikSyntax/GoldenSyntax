
fun main() {
    var heroOne = NatureMutant("Domi")
    var enemyOne = Endboss("Malte")
    var roundCounter = 1


    while (enemyOne.healthPower>0){
        heroOne.poisonRoots(enemyOne,roundCounter)
        println(enemyOne.healthPower)
        heroOne.thunderStorm(enemyOne)
        println(enemyOne.healthPower)
        println("Das war Runde $roundCounter")
        roundCounter++
    }
}


