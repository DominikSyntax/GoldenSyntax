class GunNut(
    override var name: String = "Jonny Rambo",
    override var healthPower: Int = 1500,
    override var damagePower: Int = 150
) : Human(name, healthPower, damagePower) {

    override fun printAllFunktion() {
        println(
            "1 -> Schlagen \n" +
                    "2 -> Treten \n" +
                    "3 ->  Bazooka \n" +
                    "4 -> Maschinengewähr \n" +
                    "5 -> Luftschlag \n" +
                    "6 -> Rucksack benutzen"

        )
    }

    override fun attack(bag: Bag,int: Int,enemies:MutableList <Enemy>,heros:MutableList<Hero>) {

        when (int) {
            1 -> punch(evilChoice(enemies))
            2 -> kick(evilChoice(enemies))
            3 -> bazooka(evilChoice(enemies))
            4 -> machineGun(evilChoice(enemies))
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
        println("$bullets Kugeln haben ${enemy.name} bei dem Maschienengewähr Angriff getroffen , mit einem Gesamtschaden von $damage")
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