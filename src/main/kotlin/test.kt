import java.lang.Exception
import java.lang.NumberFormatException



fun main() {
    var gaiaHero: NatureMutant = NatureMutant("Gaia")
    var tekkHero: ElectricMutant = ElectricMutant("Tekk")
    var jonnyHero: GunNut = GunNut()
    var profHero: Scientist = Scientist()
    var endboss: Endboss = Endboss()
    var bag = Bag()


    // Ich brauche einen Runden-Zähler für Angriffe, die z.b. mehrere Runden eine Auswirkung haben
    var roundCounter: Int = 1
    var heroList: MutableList<Hero> = mutableListOf(gaiaHero, tekkHero, jonnyHero, profHero)
    var enemies = mutableListOf<Enemy>(endboss)
    var myTeam: MutableList<Hero> =
        mutableListOf(gaiaHero, tekkHero, jonnyHero)                  // nur ein Beispiel zum testen !!!!!!!!!!!

    var badOnes = false
    var goodOnes = false

    while (goodOnes == false || badOnes == false){
        roundForGoods(bag,myTeam,enemies,roundCounter)
        roundForBads(myTeam,enemies,roundCounter)
        roundCounter++
        goodOnes = allGoodsAreDead(myTeam)
        badOnes = allBadsAreDead(enemies)
        if (goodOnes) {
            println("Keine weitere Runde mehr, die bösen haben endlich mal gewonnen.... ")
        }else if (badOnes) {
            println(
                "Nicht schon wieder ein Happy End, das mag ich nur bei TaiMassagen, die Helden haben zwar gewonnen doch was sie nicht gemerkt haben ist das ein Komet , \n" +
                        "doppelt so groß wie der, der die Dinos ausgelöscht hat, auf die Erde zugeflogen ist. \n" +
                        "Alle Menschen , und Tiere sind gestorben... Der ganze Planet ist explodiert... Aber hey, vorher haben die guten gewonnen , gut gemacht "
            )
        }
    }







}















