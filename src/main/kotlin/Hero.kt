open class Hero(open var name:String = String(),open var healthPower:Int = 1000, open var damagePower:Int=100) {
    open var isDead:Boolean =false
    open val standartHP = 1000
    open var usedTankChocolade = false

    open fun attack(int: Int,hero: Hero,enemy: Enemy,enemies:MutableList <Enemy>,heros:MutableSet<Hero>){

        when (int) {
            1 -> punch(enemy)
            2 -> kick(enemy)

        }

    }


    open fun printAllFunktion(){
        println("1 -> punch: fügt einem Gegner Schaden hinzu  \n" +
                "2 -> kick: fügt einem Gegner Schaden hinzu ")
    }

    fun punch(enemy: Enemy){
        var abzug= ((5..15).random()/100 *damagePower).toInt()
        enemy.healthPower -= abzug
        println("${enemy.name} wurden durch den Schlag von $name $abzug Lebenspunkte abgezogen")
    }
    fun kick(enemy: Enemy){
        var abzug= ((10..35).random()/100 *damagePower).toInt()
        enemy.healthPower -= abzug
        println("${enemy.name} wurden durch den Tritt von $name $abzug Lebenspunkte abgezogen")
    }

}