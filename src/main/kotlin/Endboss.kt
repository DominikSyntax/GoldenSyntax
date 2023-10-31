class Endboss(override var name: String= "Dajjal", override var healthPower: Int=3000, override var damagePower: Int=100):Enemy(name,healthPower,damagePower) {
    /**
     * Verursacht Flächenschaden, d.h. trifft alle Helden gleichzeitig
     */
    fun one(heros:MutableList<Hero>){
        for (hero in heros){
            hero.healthPower -= (50..100).random()
        }

}

    /**
     * Trifft nur einen Helden, pro Runde HP des Helden -10 % solange bis die HP <= 20 % der Standart HP ist (also 200)
     */
    fun two (hero:Hero){
        if (hero.healthPower >= 200)
            hero.healthPower = (hero.healthPower*0.9).toInt()
        // muss noch irgendwie in jeder runde aufgerufen werden

    }


    /**
     * Ruft den UnderBoss zur Hilfe (geht nur 1 x im Spiel)
     */
    fun underBoss(){
        // add UnderBoss zur MutableList<Enemy>

    }

    /**
     *
     */
    /*fun armeOfDead(){
        // add zwischen 4 oder 10 Untote zur MutableList<Enemy>
       var armeInt:Int= (4..6).random()
        repeat(armeInt){
            enemies.add(Undead("Egon"))
        }

     */

    }

    fun five(){

    }

    fun six(){

    }


