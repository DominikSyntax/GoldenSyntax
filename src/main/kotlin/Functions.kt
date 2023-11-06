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
- * isDead implimenteieren (überall)
-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   - -
 */






fun makeYouTeam(heroList: MutableList<Hero>): MutableList<Hero> {
    var myTeam: MutableSet<Hero> = mutableSetOf()
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

    while (myTeam.size < 3) {
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
            myTeam.add(userHero)
        }


        if (myTeam.size == 1) {
            println("Einen hast du, deine Wahl ist auf ${myTeam.last().name} gefallen, es fehlen noch 2")
        }
        if (myTeam.size == 2) {
            println(
                "Es ist unglaublich Bob, ich muss mir an den Kopf fassen, wir haben tatsächlich schon Zwei Helden. \n" +
                        "Du bist auf jeden Fall jetzt schon einer der besten Spieler ! Dein Neuzugang heißt ${myTeam.last().name}"
            )
        }
        preChoise = userChoise

    }
    println(" Geschafft! Dein Team besteht aus: ")
    for (hero in myTeam) {
        print("${hero.name}, ")
    }
    var myTeamList = myTeam.toMutableList()
    return myTeamList
}

fun heroChoice(heros:MutableList<Hero>):Hero {
    var chosenHero:Hero
    var heroInt:Int = 1
    println("Für diese Aktion, musst du dir einen Helden aussuchen")
    for (hero in heros){
        println("Gib die $heroInt für ${hero.name} ein")
        heroInt++
    }
    var userInputInt:Int = readln().toInt()
    chosenHero = heros[userInputInt-1]
    heroInt = 1
    return chosenHero
}

fun evilChoice(enemies:MutableList<Enemy>):Enemy {
    var chosenEnemy:Enemy
    var enemyInt:Int = 1
    println("Für diese Aktion, musst du dir einen Gegner aussuchen")
    for (enemy in enemies){
        println("Gib die $enemyInt für ${enemy.name} ein")
        enemyInt++
    }
    var userInputInt:Int = readln().toInt()
    chosenEnemy= enemies[userInputInt-1]
    return chosenEnemy

}

fun roundForGoods(bag: Bag, heros: MutableList<Hero>, enemies: MutableList<Enemy>, counter: Int) {

    println("Runde : $counter")
    println()
    println("Zuerst sind deine Helden dran")

    // hier noch eine einfache Abfrage, ob die Bag genutzt wurde

    for (hero in heros) {
        println("Du bist mit ${hero.name} am Zug")
        println("Was möchtest du machen, du hast die Wahl aus...")
        hero.printAllFunktion()
        var userChoiceFun = readln().toInt()
        if (hero.isDead) {
            println("Mit ${hero.name} ist nichts mehr anzufangen, das Weichei hat den Tod vorgezogen, anstatt sich seiner verantwortung zu stellen")
        } else {
            hero.attack(bag, userChoiceFun, enemies, heros)
        }
        println()
        Thread.sleep(1500)
    }
}
fun roundForBads(heros: MutableList<Hero>, enemies: MutableList<Enemy>, counter: Int){
    println("Die haben gut ausgeteilt, mal sehen was der Gegner macht in seiner $counter Runde... ")
    var copyOfEnemy:MutableList<Enemy> = enemies
    for (enemy in enemies){
        println("${enemy.name} ist am Zug")
        enemy.fight(copyOfEnemy, heros)
        println()
        Thread.sleep(1500)
    }

}


fun allGoodsAreDead(heros: MutableList<Hero>):Boolean{
    var allDead = false
    if (heros.all { it.isDead  }){
        allDead = true
    }
    return allDead

}
fun allBadsAreDead(enemies: MutableList<Enemy>):Boolean{
    var allDead = false
    if (enemies.all{it.isDead}){
        allDead = true
    }
    return allDead
}


/*fun evilfight(heros: MutableSet<Hero>, evils: MutableList<Enemy>) {

    for (badGuy in evils) {
        if (badGuy == Endboss()) {
            if (!badGuy.isDead) {
                var dice = (1..6).random()
                var randomHero = heros.random()

                when (dice) {
                    1 -> badGuy.
                    2 -> boss.selfAttack(randomHero)
                    3 -> boss.underBoss(evils)
                    4 -> boss.armeOfDead(evils)
                    5 -> boss.shield(evils.random())
                    6 -> boss.strongDamage(evils.random())
                }

            }



            }

*/

