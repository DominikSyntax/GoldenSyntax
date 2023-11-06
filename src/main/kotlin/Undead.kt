class Undead(name: String, override var healthPower: Int=200, override var damagePower: Int=25):Enemy(name,healthPower,damagePower) {


    override fun fight(enemies: MutableList<Enemy>, heros: MutableList<Hero>) {
        var dice = listOf(1,2).random()
        var randomHero = heros.random()

        when (dice) {
            1 -> bite(randomHero)
            2 -> hold(randomHero)
        }
    }

    fun bite(hero: Hero){
        var damage = (((25..50).random())/100 * damagePower).toInt()
        if (hero.healthPower > damage){
            println("$name hat ${hero.name} gebissen und dadurch $damage Schaden verursacht.")
            hero.healthPower -= damage
            println()
            Thread.sleep(1500)
        }else{
            println("So ein kleiner Biss war schon zuviel für ${hero.name}")
            hero.healthPower = 0
            hero.isDead
            println()
            Thread.sleep(1500)
        }
    }

    fun hold(hero: Hero){
        var minusDamagePower = (((7..10).random()/100) * damagePower).toInt()
        if (hero.damagePower > minusDamagePower){
            println("$name hält ${hero.name} fest, die Angriffskraft wurde um $minusDamagePower reduziert")
            hero.damagePower -= minusDamagePower
            println()
            Thread.sleep(1500)
        }else{
            println("${hero.name} ist zwar nicht tot aber hat auch keine kraft zum angreifen")
            hero.damagePower = 0
            println()
            Thread.sleep(1500)
        }
    }

}