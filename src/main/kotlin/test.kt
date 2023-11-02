import java.lang.Exception
import java.lang.NumberFormatException
var enemyChoice: Enemy = Enemy()
var heroChoice: Hero = Hero()
var goodChoice: MutableSet<Hero> = mutableSetOf()
var badChoice: MutableList<Enemy> = mutableListOf()

fun main() {
    var gaiaHero: NatureMutant = NatureMutant("Gaia")
    var tekkHero: ElectricMutant = ElectricMutant("Tekk")
    var jonnyHero: GunNut = GunNut()
    var profHero: Scientist = Scientist()


    // Ich brauche einen Runden-Zähler für Angriffe, die z.b. mehrere Runden eine Auswirkung haben
    var roundCounter: Int = 0
    var heroList: MutableList<Hero> = mutableListOf(gaiaHero, tekkHero, jonnyHero, profHero)
    var enemies = mutableListOf<Enemy>(Endboss("Dajjal"), Undead("Malte"))
    var mySet: MutableSet<Hero> =
        mutableSetOf(gaiaHero, tekkHero, jonnyHero)                  // nur ein Beispiel zum testen !!!!!!!!!!!

    mySet = makeYouTeam(heroList)
    var bag = Bag()

    rounds(bag, mySet, enemies, roundCounter)
}

fun rounds(bag: Bag, heros: MutableSet<Hero>, enemies: MutableList<Enemy>, counter: Int) {
    println("Runde : $counter")
    for (hero in heros) {
        println("Du bist am Zug mit ${hero.name}")
        println("Was möchtest du machen, du hast die Wahl aus...")
        hero.printAllFunktion()
        var userChoiceFun = readln().toInt()


        println("Bei wem oder welcher Gruppe soll $userChoiceFun angewandt werden? Angriffe funktionieren nur bei Gegnern oder ggf. einer Gruppe von Gegnern und Heilung nur bei Helden oder deinem Team von von Helden")

        for (hero in heros) {
            println(hero.name)
        }
        for (enemy in enemies) {
            println(enemy.name)
        }
        println("Wer darf es nun sein? Gib den Namen ein oder -Helden- für dein Team , bzw -Gegner- für alle Gegner auf dem Feld")
        var userChoicePerson = readln()
        choice(userChoicePerson,enemies,heros)
        hero.attack(userChoiceFun,heroChoice,enemyChoice,badChoice,goodChoice)


    }

}






