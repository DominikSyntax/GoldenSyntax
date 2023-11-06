class GunNut(
    override var name: String = "Jonny Rambo",
    override var healthPower: Int = 1500,
    override var damagePower: Int = 150
) : Human(name, healthPower, damagePower) {

    override fun attack(int: Int,hero: Hero,enemy: Enemy,enemies:MutableList <Enemy>,heros:MutableSet<Hero>) {

        when (int) {
            1 -> punch(enemy)
            2 -> kick(enemy)
            3 -> bazooka(enemy)
            4 -> machineGun(enemy)
            5 -> airstrike(enemies)
            6 -> bag.useBag(heros)
        }
    }

    fun bazooka(enemy: Enemy) {
        if (enemy.healthPower > 150) {
            enemy.healthPower -= 150
        } else
            enemy.healthPower = 0

    }

    fun machineGun(enemy: Enemy){
        var bullets = (12..34).random()
        var damage = 0
        for (bullet in 1..bullets){
            damage += (5..10).random()
            if (enemy.healthPower > damage){
                enemy.healthPower -= damage
            }else {
                enemy.healthPower = 0
                break
            }
        }
        println("$bullets haben ${enemy.name} bei dem Maschienengewähr Angriff getroffen , mit einem Gesamtschaden von $damage")
    }

    fun airstrike(enemies:MutableList<Enemy>){
        println("$name hat Luftunterstützung angefordert....")
        var damage:Int
        for (enemy in enemies){
            damage = (enemy.standartHP/100) * (9..35).random().toInt()
            if (damage >= enemy.healthPower ){
                println("Der Luftschlag war zuviel für ${enemy.name}")
                println()
                Thread.sleep(1500)
                enemy.healthPower = 0
                enemy.isDead = true
            }else {
                if (damage <= 35) {
                    println("${enemy.name} hatte Glück und nur ein kleiner Splitter abbekommen. $damage Schaden ")
                    println()
                } else if (damage <= 150 && damage > 35) {
                    println("${enemy.name} hat einige Tiefe Fleischwunden. $damage Schaden ")
                    println()
                } else if (damage > 150) {
                    println("Der Luftschlag hat ${enemy.name} hart getroffen. $damage Schaden ")
                    println()
                }
                enemy.healthPower -= damage
                Thread.sleep(1500)
            }
        }
    }


}