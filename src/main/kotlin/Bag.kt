open class Bag {


    /**
     * Kann nur 1x pro Runde eingesetzt werden, anstelle einer anderen Funktion
     */
    open fun bag(heros:MutableSet<Hero>) {
        var healingDrinkInt = 3
        var vitaminsInt = 1
        println("Im eurem Beutel befinden sich $healingDrinkInt Heiltränke und $vitaminsInt Vitamine.")
        println()
        println("Ein Heiltrank erhöht die Lebenspunkte eines Helden um die Hälfte seiner ursprünglichen HP. \n " +
                "Die Vitaminen geben einem Helden dauerhaft 10 % mehr Schadenskraft")
        println()
        println("Du kannst die Dinge, aus deinem Beutel, nur bei lebendigen Helden anwenden. Wir haben leider niemanden , der unsere gefallenen Freunde zurück holt.")

        println("Bitte geben Sie 1 für Heiltrank und 2 für Vitamine ein")
        var userInput = readln().toInt()

        if (userInput == 1) {
            println("Welchen Helden möchtest du heilen?")
            println()
            var counter = 1
            for (hero in heros){
                if (hero.isDead){
                    println("Für ${hero.name} kommt jede hilfe zu spät")
                }else {
                    println("$counter für ${hero.name}")
                    counter++
                }
            }
             counter =1

            var userHeroInput = readln().toInt() +1

            if (heros.size > userHeroInput) {
                println(" So viele Helden hast du gar nicht")

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