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

    //greeting()

    myTeam = mutableListOf(gaiaHero,tekkHero,jonnyHero)     //makeYouTeam(heroList)

    while (!allGoodsAreDead(myTeam) && !allBadsAreDead(enemies)) {
        roundForGoods(bag, myTeam, enemies, roundCounter)

        roundForBads(myTeam, enemies, roundCounter)
        for (hero in myTeam)
            displayHp(hero)
        for (enemy in enemies)
            displayHp(enemy)

        roundCounter++
    }
    ending(myTeam, enemies)

}




