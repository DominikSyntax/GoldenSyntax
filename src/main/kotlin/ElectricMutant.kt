/**
 * Tekk ist das Kücken, mit gerade einmal 22 Jahren. Dafür ist er aber auch deutlich schneller als die Anderen
 * Er kann alles, was mit Technik zu tun hat kontrollieren
 */

class ElectricMutant():Hero(name = "Tekk", healthPower = 1000, damageValue = 100) {

    /**
     * Jedes Fahrzeug im Umkreis beschleunigt und wird in Richtung des Gegners gelenkt
     * @param enemy
     */
    fun traficContol(enemy: Enemy){
        var cars = (3..5).random()
        var buses = 1
        var mopets = 3

        println("OMG, schau dir die Fahrzeuge an! $cars Autos , $buses Bus und $mopets Roller beschleunigen sich wie von Zauberhand Richtung ${enemy.name}")
        if (enemy.name.contains("Dajjal")) {
            buses = 0
            println("Oh nein, Dajjal konnte den Bus in Staub verwandeln ")
            cars = 3
            mopets = 2
        }

        repeat(cars){
            var damage  = (enemy.healthPower/100 * (7..10).random())
            enemy.healthPower -= damage
            println("Ein Auto hat ${enemy.name} getroffen und ihm $damage Schaden zugefügt")
        }

        if (buses>0) {
            enemy.healthPower -= (enemy.healthPower/100 * (15..25).random())
        }

        repeat(mopets){
            var damage  = (enemy.healthPower/100 * (3..7).random())
            enemy.healthPower -= damage
        }
    }

}