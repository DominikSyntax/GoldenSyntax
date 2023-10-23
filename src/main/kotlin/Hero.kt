open class Hero(open var name:String = String(),open var healthPower:Int = 1000, open var speed:Int=100) {


    open fun showMyHP(){
        println(healthPower)
    }


}