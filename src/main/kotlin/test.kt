import java.lang.Exception
import java.lang.NumberFormatException


fun main() {
    var gaiaHero:NatureMutant = NatureMutant("Gaia")







    // Ich brauche einen Runden-Zähler für Angriffe, die z.b. mehrere Runden eine Auswirkung haben
    var roundCounter:Int = 0
    var heroList:MutableList<Hero> = mutableListOf()
    var mySet:MutableSet<Hero> = mutableSetOf()

    mySet = makeYouTeam(heroList)


}


