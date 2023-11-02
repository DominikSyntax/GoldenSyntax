open class Hero(open var name:String = String(),open var healthPower:Int = 1000, open var damagePower:Int=100) {





    open fun printAllFunktion(){
        println("1 -> punch: fügt einem Gegner zwischen 5 und 15 Punkten Schaden hinzu (bei 100% Damage Power) \n" +
                "2 -> kick: fügt einem Gegner zwischen 10 und 35 Punkten Schaden hinzu (bei 100% Damage Power)")
    }

    open fun punch(enemy: Enemy){
        enemy.healthPower -= ((5..15).random()/100 *damagePower).toInt()
    }
    open fun kick(enemy: Enemy){
        enemy.healthPower -= ((10..35).random()/100 *damagePower).toInt()
    }

}