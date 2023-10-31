class GunNut(
    override var name: String = "Jonny Rambo",
    override var healthPower: Int = 1500,
    override var damagePower: Int = 150
) : Human(name, healthPower, damagePower) {

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


}