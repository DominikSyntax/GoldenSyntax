import charakter.*

fun main() {
    var gaiaHero: NatureMutant = NatureMutant("Gaia")           //zuerst muss jeder einmal initalisiert werden
    var tekkHero: ElectricMutant = ElectricMutant("Tekk")
    var jonnyHero: GunNut = GunNut()
    var profHero: Scientist = Scientist()
    var endboss: Endboss = Endboss()
    var bag = Bag()


    var roundCounter: Int = 1

    var heroList: MutableList<Hero> = mutableListOf(gaiaHero, tekkHero, jonnyHero, profHero)
    var enemies = mutableListOf<Enemy>(endboss)
    var goodOnes: Boolean = false
    var badOnes: Boolean =false


    greeting()                                              // Hier fängt das Spiel an 1
    var myTeam: MutableList<Hero> = makeYouTeam(heroList)


    do  {
        roundForGoods(bag, myTeam, enemies, roundCounter)
        roundForBads(myTeam, enemies, roundCounter)
        goodOnes = allGoodsAreDead(myTeam)
        badOnes = allBadsAreDead(enemies)
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
1


}




