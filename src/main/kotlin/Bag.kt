open class Bag {


    /**
     * Kann nur 1x pro Runde eingesetzt werden, anstelle einer anderen Funktion
     */
    open fun bag(heros:MutableList<Hero>) {
        var healingDrinkInt = 3
        var vitaminsInt = 1
        println("Im eurem Beutel befinden sich $healingDrinkInt Heiltränke und $vitaminsInt Vitamine." +
                " ")
        println("Bitte geben Sie 1 für Heiltrank und 2 für Vitamine ein")
        var userInput = readln().toInt()

        if (userInput == 1) {
            println("Welchen Helden möchtest du heilen? Bitte eingeben: Gaia, Tekk oder The Professor?")
            var userHeroInput = readln()
            if (heros.contains(Hero(userHeroInput))) {
                Hero(userHeroInput).healthPower += (Hero(userHeroInput).healthPower / 100 * 50).toInt()

            } else
                println("Das tut mir leid,  die Eingabe war nicht richtig ")

        }

        if (userInput == 2) {
            println("Okay, welchen Helden möchtest du einen Boost durch Vitamine verabreichen? Bitte eingeben Gaia ,Tekk oder The Professor?")
            var userHeroInput = readln()
            if (heros.contains(Hero(userHeroInput))) {
                Hero(userHeroInput).damagePower += Hero(userHeroInput).damagePower / 100 * 10

            } else
                println("Das tut mir leid,  die Eingabe war nicht richtig ")

        }

    }
}