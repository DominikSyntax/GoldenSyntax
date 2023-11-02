import java.lang.NumberFormatException

// Die Funktionen für die main.kt hier drin, hab ich auf alle erdenklichen Fehler getesten(nur die erste bis jetzt, in der zweiten könnten noch Fehler sein)




/*
-   -   -   -   -   -   -   -   -   -   TO DO's   -   -   -   -   -   -   -   -   -   -   -   -   -   -
- * Alle Personenklassen brauchen noch eine val startHP, um die Aufgabe zu lösen (Endgegner Funktion) -
-                                                                                                     -
- * heilen heißt natürlich nur 100% der start HP! aber um  fäir zu bleiben darf alles was über die    -
-   100 % geht auch nur eine zeit darüber bestehen                                                    -
-                                                                                                     -
- * Underboss braucht noch 1 Funktionen                                                               -
- * Damit das mit den Runden klappt, brauche ich wahrscheinlich, einen return wert für die Runden     -
-   auf die ich von außen zugreifen kann. In der Runden- Schleife (sobald es sie richtig gibt)        -
- * ich glaube es ist besser die Namen der Helden , nicht in der Klasse festzulegen, sodern später    -
-   in der main.kt                                                                                    -
- * ElectricMutant und Scientist brauchen noch Funktionen                                             -
-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   - -
 */






fun makeYouTeam(heroList: MutableList<Hero>):MutableSet<Hero> {
    var mySet: MutableSet<Hero> = mutableSetOf()
    println("Bitte such dir ein Team von 3 Helden zusammen, um gegen ${Endboss("Dajjal").name} anzutreten")
    println(
        "Du hast die Wahl aus \n" +
                "1 für ${heroList[0].name} \n" +
                "2 für ${heroList[1].name} \n" +
                "3 für ${heroList[2].name} \n" +
                "4 für ${heroList[3].name} \n"
    )

    println()

    println(
        "Wen möchtest du zu deinem Team hinzufügen? Bitte gib die Zahl ein, die vor deinem Helden steht. \n" +
                "Du kannst jeden nur Einmal in dein Team wählen, unsere Helden sind schließlich Unikate!"
    )

    println()

    var userChoise: Int = 0
    var preChoise: Int = 0

    while (mySet.size < 3) {
        try {
            userChoise = readln().toInt()
        } catch (e: NumberFormatException) {
            println("Wat is los mit dir Einstein? Ich hatte gesagt Zahlen! Das sind die Dinger mit denen man rechnet.")
            continue
        }

        if (userChoise == preChoise) {
            println(
                "Ich weiß, so ein Text RPG braucht mehr als deine $userChoise Sekunden Aufmerksamkeitsspanne. Oder was wolltest du mir mit dieser Zahl sagen? \n" +
                        "Ich bleibe heute einfach mal freundlich und sage dir, dass du dieses Unikat von Held schon ausgewählt hast."
            )
            println()
            println(" Hier ein kleiner Livehack, so kommst du mit der Anzahl der Unikate nicht mehr so oft durcheinader....")
            println(
                " 0 < Unikat Anzahl < 2   \n" +
                        "Triff eine andere Wahl, am besten eine Richtige"
            )
        }

        if (userChoise < 1 || userChoise > 4) {
            println(
                "Okay, du hast schon einmal verstanden, was eine Zahl ist. Schafft nicht jeder auf anhieb :( \n" +
                        "Aber jetzt genug des Lobes, leider kommt die Zahl , die du wolltest, gar nicht in der Liste vor. \n" +
                        "Ich glaub an dich, schnapp dir alle deine $userChoise Imaginären Freunde (oder wo du diese Zahl auch her hast) \n" +
                        "und schaut euch, vielleicht zusammen die Liste nochmal an und triff die richtige Wahl."
            )
        } else {
            var userHero: Hero = heroList[userChoise - 1]
            mySet.add(userHero)
        }


        if (mySet.size == 1) {
            println("Einen hast du, deine Wahl ist auf ${mySet.last().name} gefallen, es fehlen noch 2")
        }
        if (mySet.size == 2) {
            println(
                "Es ist unglaublich Bob, ich muss mir an den Kopf fassen, wir haben tatsächlich schon Zwei Helden. \n" +
                        "Du bist auf jeden Fall jetzt schon einer der besten Spieler ! Dein Neuzugang heißt ${mySet.last().name}"
            )
        }
        preChoise = userChoise

    }
    println(" Geschafft! Dein Team besteht aus: ")
    for (hero in mySet) {
        print("${hero.name}, ")
    }
    return mySet
}

 fun choice(wen: String, enemies: MutableList<Enemy>, mySet: MutableSet<Hero>) {

     if (enemies.contains(Enemy(wen))) {
        enemyChoice = Enemy(wen)
     }else if (mySet.contains(Hero(wen))) {
        heroChoice = Hero(wen)
     }else if (wen == "Helden") {
        goodChoice = mySet
     }else if (wen == "Gegner") {
         badChoice = enemies
     }else
         println("So schwer kann es doch nicht sein, du musst ja nicht einmal selber kämpfen. Nur einen Namen richtig eingeben")


}

