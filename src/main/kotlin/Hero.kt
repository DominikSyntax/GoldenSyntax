open class Hero(open val name:String = String(),open var healthPower:Int = 1000) {

    open fun showMyHP(){
        println(healthPower)
    }


}