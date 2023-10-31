val alphabetShapes = mapOf(
    'a' to listOf(
        "  AA  ",
        " A  A ",
        "AAAAA ",
        "A   A",
        "A   A"
    ),
    'b' to listOf(
        "BBBB ",
        "B   B",
        "BBBB ",
        "B   B",
        "BBBB "
    ),
    'c' to listOf(
        " CCC ",
        "C    ",
        "C    ",
        "C    ",
        " CCC "
    ),
    'd' to listOf(
        "DDDD ",
        "D   D",
        "D   D",
        "D   D",
        "DDDD "
    ),
    'j' to listOf(
        "   J  ",
        "   J  ",
        "   J  ",
        "J  J  ",
        " J J  "
    ),
    'l' to listOf(
        "L    ",
        "L    ",
        "L    ",
        "L    ",
        "LLLLL"
    ),
    'r' to listOf(
        "RRRR ",
        "R   R",
        "RRRR ",
        "R R  ",
        "R  RR"
    ),
    's' to listOf(
        " SSS ",
        "S    ",
        " SSS ",
        "    S",
        " SSS "
    ),
    'h' to listOf(
        "H   H",
        "H   H",
        "HHHHH",
        "H   H",
        "H   H"
    ),
    'e' to listOf(
        "EEEEE",
        "E    ",
        "EEE  ",
        "E    ",
        "EEEEE"
    )
)



fun createBigLetter(letter: Char): String {
    val shape: List<String> = alphabetShapes[letter.lowercaseChar()]?: return " "
    return shape.joinToString("\n")
}



fun main() {
    val word = "Dajjal's Rache"
    for (letter in word) {
        var big = createBigLetter(letter)
        println(big)
        println()
    }

    println("DDDD " + " "+ "  AA  "  + "   J  "  + "   J  " )
    println("D   D" + " A  A "  + "   J  "  + "   J  " )
    println("D   D" + "AAAAAA" + "   J  "  + "   J  " )
    println("D   D" + "A    A"  + "J  J  "  + "J  J  " )
    println("DDDD " + "A    A"  + " J J  "  + " J J  " )


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


