/**
 * Tekk ist das Kücken, mit gerade einmal 22 Jahren. Dafür ist er aber auch deutlich schneller als die Anderen
 * Er kann alles, was mit Technik zu tun hat kontrollieren
 */

class ElectricMutant(override var name:String = "Tekk",override var healthPower:Int = 1000,override var damagePower:Int = 100):Hero(name, healthPower, damagePower) {

    override fun printAllFunktion() {
        super.printAllFunktion()
        println(
            "3 -> thunderStorm : Lässt ein Gewitter aufziehen und Blitze auf die Gegner nieder \n" +
                    "4 -> poisonRoots:    "
        )
    }


    override fun attack(int: Int,hero: Hero,enemy: Enemy,enemies:MutableList <Enemy>,heros:MutableSet<Hero>) {

        when (int) {
            1 -> punch(enemy)
            2 -> kick(enemy)
            3 -> traficContol(enemy)
            4 -> poisonRoots(enemy)
            5 -> healing(heros)
        }
    }

    /**
     * Jedes Fahrzeug im Umkreis beschleunigt und wird in Richtung des Gegners gelenkt
     * @param enemy
     */
    fun traficContol(enemy: Enemy){
        var cars = (3..5).random()
        var buses = 1
        var mopets = 3

        println("OMG, schau dir die Fahrzeuge an! $cars Autos , $buses Bus und $mopets Roller beschleunigen sich wie von Zauberhand Richtung ${enemy.name}")
        if (enemy.name =="Dajjal") {
            buses = 0
            println("Oh nein, Dajjal konnte den Bus in Staub verwandeln ")
            cars = 3
            mopets = 2
        }

        repeat(cars){
            var damage  = 0
            damage +=  ((enemy.healthPower/100) * (7..10).random()).toInt()
            if (damage==0){
                println("Es geht aufs Ende zu mit ${enemy.name}")
                damage = 5
            }
            if (enemy.healthPower > damage){
                enemy.healthPower -= damage
            }else {
                enemy.healthPower = 0
                println("${enemy.name} wurde besiegt")
                return
            }
            println("Ein Auto hat ${enemy.name} getroffen und ihm $damage Schaden zugefügt")
        }

        if (buses>0) {
            var damage = 0
            damage += ((enemy.healthPower/100) * (15..25).random()).toInt()

            if (damage==0){
                println("Es geht aufs Ende zu mit ${enemy.name}")
                damage = 15
            }
            if (enemy.healthPower > damage){
                enemy.healthPower -= damage
            }else {
                enemy.healthPower = 0
                println("${enemy.name} wurde besiegt")
                return
            }
            println("Ein Bus hat ${enemy.name}getroffen und ihm $damage Schaden zugefügt")
        }

        repeat(mopets){
            var damage  = 0
            damage += ((enemy.healthPower/100) * (3..7).random()).toInt()
            if (damage==0){
                println("Es geht aufs Ende zu mit ${enemy.name}")
                damage = 5
            }
            if (enemy.healthPower > damage){
                enemy.healthPower -= damage
            }else {
                enemy.healthPower = 0
                println("${enemy.name} wurde besiegt")
                return
            }
            println("Ein Roller hat ${enemy.name}getroffen und ihm $damage Schaden zugefügt")
        }
    }

    /**
     * lässt sich nur 1x im Spiel für einen helden einsetzen
     * pro runde 2% Lebensenergie zurück, für 20 Runden
     * damagePower + 10%
     */
    fun nanoBots(hero:Hero){
        hero.damagePower += (hero.damagePower/100 *10).toInt()
        println("${hero.name} hat durch die NanoBots 10% an Schlagkraft gewonnen")

    }

}