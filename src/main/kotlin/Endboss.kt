class Endboss():Enemy(name = "Dajjal", healthPower = 3000, damagePower = 100) {
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
    fun four(){

    }

    fun five(){

    }

    fun six(){

    }
}
