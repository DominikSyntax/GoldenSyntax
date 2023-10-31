import java.lang.Exception
import java.lang.NumberFormatException

fun main() {




    // Ich brauche einen Runden-Zähler für Angriffe, die z.b. mehrere Runden eine Auswirkung haben
    var roundCounter:Int = 0



    var heroList:MutableList<Hero> = mutableListOf(NatureMutant(),ElectricMutant(),GunNut(), Scientist())
    var mySet:MutableSet<Hero> = mutableSetOf()




    println("Bitte such dir ein Team von 3 Helden aus um gegen Dajjal anzutreten")
    println("Du hast die Wahl aus \n" +
            "1 für ${heroList[0].name} \n" +
            "2 für ${heroList[1].name} \n" +
            "3 für ${heroList[2].name} \n" +
            "4 für ${heroList[3].name} \n")

    println()

    while (mySet.size<3) {
        println("Wen möchtest du zu deinem Team hinzufügen?")
        var userChoise:Int
        try {userChoise= readln().toInt()
        }catch (e:NumberFormatException){
            println("Bitte nur Zahlen eingeben")
            continue
        }

        if (userChoise < 1 || userChoise>4) {
            println("Keine gültige Auswahl")
        }else{
            var userHero: Hero = heroList[userChoise-1]
            mySet.add(userHero)
        }

        println("Dein Team besteht aus")
        for (hero in mySet)
            println(hero.name)
    }
/*
    //While (any hero oder Enemy HealthPower >0)
    fun round(heros:MutableList<Hero>,enemies:MutableList<Enemy>){
        for (hero in heros){
            println("Was soll $hero machen?")
            println("Du hast die Wahl aus :")
            for (action in hero.listOfMethoden){
                var count = 1
                println("$count für $action")
                count++
            }
            var userInt = readln().toInt()


            try {
                var action =hero.listOfMethoden[userInt]
                NatureMutant().
            }catch (e:Exception) {
                println("Ungültige Aktion $e")
            }
            if (enemies.size>1) {
                println("Okay, wir haben mehrere Gegner! Gegen wen soll die Attacke gehen?")
                for (enemy in enemies){
                    var count = 1
                    println("$count für $enemy" )
                    count++
                    }

                try {
                    var enemyChoise = enemies[readln().toInt()]
                }catch (e:Exception) {
                    println("Sorry, da war etwas nicht richtig. $e Fehler ")
                }
                hero.



            }else
                println("Ungültige Eingabe")
        }


    }

*/
}