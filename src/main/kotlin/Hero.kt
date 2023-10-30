open class Hero(open var name:String = String(),open var healthPower:Int = 1000, open var damagePower:Int=100) {


    open fun showMyHP(){
        println("$name hat noch $healthPower Lebenspunkte")
    }

    open fun punch(enemy: Enemy){
        enemy.healthPower -= ((5..15).random()/100 *damagePower).toInt()
    }

    open fun kick(enemy: Enemy){
        enemy.healthPower -= ((10..35).random()/100 *damagePower).toInt()
    }

}