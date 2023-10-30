var heros:MutableList<Hero> = mutableListOf()

var enemies:MutableList<Enemy> = mutableListOf(Endboss())

fun main() {
    // Ich brauche einen Runden-Zähler für Angriffe, die z.b. mehrere Runden eine Auswirkung haben
    var roundCounter:Int = 0



    var heroMap:Map<Int,Hero> = mapOf(
        1 to NatureMutant(),
        2 to ElectricMutant(),
        // 3 to Human GunNut(),
        // 4 to Human Sientist(),
        // 5 to Wardroid()
    )





    println("Bitte such dir ein Team von 3 Helden aus um gegen Dajjal anzutreten")
    println("Du hast die Wahl aus $heroMap.")

    while (heros.size<3) {
        println("Wen möchtest du zu deinem Team hinzufügen?")
        var userChoise = readln().toInt()
        if (heroMap.containsKey(userChoise)) {
            var userHero: Hero = heroMap.values.elementAt(userChoise-1)
            heros.add(userHero)
        }else
            println("Keine gültige Auswahl")

        println("Dein Team besteht aus $heros")

    }

    //While (any hero oder Enemy HealthPower >0)
    fun round(heros:MutableList<Hero>,enemies:MutableList<Enemy>){
        for (hero in heros){
            println("Was soll $hero machen?")
            println("Du hast die Wahl aus ${hero.mapOfMethoden}")
            var userInt = readln().toInt()


            if (hero.mapOfMethoden.containsKey(userInt)){
                if (enemies.size>1) {
                    println("Okay, wir haben mehrere Gegner! Gegen wen soll die Attacke gehen?")
                    for (enemy in enemies){
                        var count = 1
                        println("$count + $enemy" )
                        count++
                    }
                    var enemyChoise = readln().toInt()

                    if (!enemies.contains(enemies[enemyChoise])){
                        println("Falsche Angabe")
                    }else
                        var akutEnemy = enemies[enemyChoise]
                }

                var methodeInput =hero.mapOfMethoden.values.elementAt(userInt-1)
                var attack= hero.mapOfMethoden.values.toList()
                attack[userInt]()

            }else
                println("Ungültige Eingabe")
        }


    }
}