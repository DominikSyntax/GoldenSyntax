
open class Enemy(open var name:String = String(),open var healthPower:Int = 1000, open var damagePower:Int = 100) {

    open fun showMyHP(){
        println(healthPower)
    }



}