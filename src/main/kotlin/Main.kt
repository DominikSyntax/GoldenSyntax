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

// Einen Rundenzähler
var roundCounter: Int = 1

// ständiges überprüfen, ob jemand tot ist (kann ich bestimmt noch ein paar mal aus dem code entfernen
var goodOnes: Boolean = false
var badOnes: Boolean =false

fun main() {

    greeting()
    myTeam= makeYouTeam(heroList)

    do  {
        roundForGoods(bag, myTeam, enemies, roundCounter)
        badOnes = allBadsAreDead(enemies)

        roundForBads(myTeam, enemies, roundCounter)
        goodOnes = allGoodsAreDead(myTeam)

        if (goodOnes) {
            println("Keine weitere Runde mehr, die bösen haben endlich mal gewonnen.... ")
        } else if (badOnes) {
            println(
                "Nicht schon wieder ein Happy End, das mag ich nur bei TaiMassagen, die Helden haben zwar gewonnen doch was sie nicht gemerkt haben ist das ein Komet , \n" +
                        "doppelt so groß wie der, der die Dinos ausgelöscht hat, auf die Erde zugeflogen ist. \n" +
                        "Alle Menschen , und Tiere sind gestorben... Der ganze Planet ist explodiert... Aber hey, vorher haben die guten gewonnen , gut gemacht "
            )
        }
        roundCounter++
    }while (goodOnes||badOnes)
}




