import Funktions.*
import charakter.*

// ALLE HELDEN
var gaiaHero: NatureMutant = NatureMutant()           //zuerst muss jeder einmal initalisiert werden
var tekkHero: ElectricMutant = ElectricMutant()
var jonnyHero: GunNut = GunNut()
var profHero: Scientist = Scientist()
var heroList: MutableList<Hero> = mutableListOf(gaiaHero, tekkHero, jonnyHero, profHero)
var myTeam: MutableList<Hero> = mutableListOf()

// Der Rucksack
var bag = Bag()

// DER ENDBOSS (den Nebenboss brauche ich hier noch nicht)
var endboss: Endboss = Endboss()
var enemies = mutableListOf<Enemy>(endboss)

// Einen Rundenzähler und noch ein paar für Angriffe
var roundCounter: Int = 1
var rootCounter: Int = 0
var cableCounter: Int = 0

fun main() {

    greeting()

    myTeam = makeYouTeam(heroList)


    while (!allBadsAreDead(enemies) && !allGoodsAreDead(myTeam)){
        chuckNorris(roundCounter)

        roundForGoods(bag, myTeam, enemies, roundCounter)
        if (allBadsAreDead(enemies)){
            break
        }



        roundForBads(myTeam, enemies, roundCounter)
        if (allGoodsAreDead(myTeam)) {
            break
        }


        roundCounter++
    }
    endPrint(myTeam, enemies)

}






