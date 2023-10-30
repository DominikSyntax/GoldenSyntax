open class Hero(open var name:String = String(),open var healthPower:Int = 1000, open var damagePower:Int=100) {

    open var mapOfMethoden:Map<Int,Any> = mutableMapOf(1 to showMyHP(),2 to punch(Enemy()),3 to kick(Enemy()))

    final fun showMyHP(){
        println("$name hat noch $healthPower Lebenspunkte")
    }

    final fun punch(enemy: Enemy){
        enemy.healthPower -= ((5..15).random()/100 *damagePower).toInt()
    }

    final fun kick(enemy: Enemy){
        enemy.healthPower -= ((10..35).random()/100 *damagePower).toInt()
    }

}