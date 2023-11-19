import Funktions.*
import charakter.*


fun main() {

    var myboss:Endboss = Endboss("Dominik")
    displayHp(myboss)
    displayDp(myboss)

    myboss.healthPower -= 55
    myboss.damagePower -= 10
    displayHp(myboss)
    displayDp(myboss)

    myboss.healthPower -= 55
    myboss.damagePower -= 10
    displayHp(myboss)
    displayDp(myboss)


}
















