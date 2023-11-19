import Funktions.*
import charakter.*


fun main() {

    var myboss:Endboss = Endboss("Dominik")


    myboss.healthPower -= 55
    myboss.damagePower -= 10

    displayHp(myboss)



    myboss.healthPower -= 10
    myboss.damagePower -= 40

    displayHp(myboss)


    myboss.healthPower -= 55
    myboss.healthPower -= 55
    myboss.healthPower -= 55

    displayHp(myboss)






}
















