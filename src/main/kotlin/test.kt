import java.lang.Exception
import java.lang.NumberFormatException


fun main() {
    var gaiaHero:NatureMutant = NatureMutant("Gaia")
    var tekkHero:ElectricMutant = ElectricMutant("Tekk")
    var jonnyHero:GunNut = GunNut()
    var profHero:Scientist = Scientist()





    // Ich brauche einen Runden-Zähler für Angriffe, die z.b. mehrere Runden eine Auswirkung haben
    var roundCounter:Int = 0
    var heroList:MutableList<Hero> = mutableListOf()
    var mySet:MutableSet<Hero> = mutableSetOf()

    mySet = makeYouTeam(heroList)
    fun rounds(bag: Bag,heros:MutableSet<Hero>,enemys:MutableList<Enemy>,counter:Int){
        println("Runde : $roundCounter")
        for (hero in heros){
            println("Du bist am Zug mit ${hero.name}")
            println("Was möchtest du machen, du hast die Wahl aus...")
        }

    }

}


