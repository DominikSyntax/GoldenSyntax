class Undead(name: String, override var healthPower: Int=200, override var damagePower: Int=25):Enemy(name,healthPower,damagePower) {
    fun bite(hero: Hero){
        hero.healthPower -= (((25..50).random())/100 * damagePower).toInt()
    }

    fun hold(hero: Hero){
        hero.damagePower -= 10
    }

}