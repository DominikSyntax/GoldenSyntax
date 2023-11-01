import java.lang.Exception
import java.lang.NumberFormatException
var heroList:MutableList<Hero> = mutableListOf(NatureMutant(),ElectricMutant(),GunNut(), Scientist())
var mySet:MutableSet<Hero> = mutableSetOf()


fun main() {
    // Ich brauche einen Runden-Zähler für Angriffe, die z.b. mehrere Runden eine Auswirkung haben
    var roundCounter:Int = 0

    makeYouTeam()

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
