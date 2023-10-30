class Undead():Enemy(name = "UndeadMale", healthPower = 200, damagePower = 25) {
    fun bite(hero: Hero){
        hero.healthPower -= (((25..50).random())/100 * damagePower).toInt()
    }

    fun hold(hero: Hero){
        hero.damagePower -= 10
    }
}