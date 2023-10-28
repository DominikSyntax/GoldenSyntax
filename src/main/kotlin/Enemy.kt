
open class Enemy(open var name:String = String(),open var healthPower:Int = 1000, open var speed:Int=100) {

    open fun showMyHP(){
        println(healthPower)
    }

    open fun punch(enemy: Enemy){
        enemy.healthPower-=(5..15).random()
    }

    open fun kick(enemy: Enemy){
        enemy.healthPower-=(10..35).random()
    }

}