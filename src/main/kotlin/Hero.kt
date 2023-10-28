open class Hero(open var name:String = String(),open var healthPower:Int = 1000, open var damageValue:Int=100) {


    open fun showMyHP(){
        println(healthPower)
    }

    open fun punch(enemy: Enemy){
        enemy.healthPower -= ((5..15).random()/100 *damageValue).toInt()
    }

    open fun kick(enemy: Enemy){
        enemy.healthPower -= ((10..35).random()/100 *damageValue).toInt()
    }


    // To DO : Falls die Eingabe nicht richtig war nochmal nachhaken ob der User eine richtige Eingabe machen möchte
    open fun bag(heros:MutableList<Hero>){
        var healingInt = 3
        var vitamins = 1
        println("Bitte geben Sie 1 für Heiltrank und 2 für Vitamine ein")
        var userInput = readln().toInt()

        if (userInput==1){
            println("Welchen Helden möchtest du heilen? Bitte eingeben: Gaia, Tekk oder The Professor?")
            var userHeroInput =readln()
            if (heros.contains(Hero(userHeroInput))){
                Hero(userHeroInput).healthPower += (Hero(userHeroInput).healthPower/100 *50).toInt()

            }else
                println("Das tut mir leid,  die Eingabe war nicht richtig ")

        }

        if (userInput==2){
            println("Okay, welchen Helden möchtest du einen Boost durch Vitamine verabreichen? Bitte eingeben Gaia ,Tekk oder The Professor?" )
            var userHeroInput = readln()
            if (heros.contains(Hero(userHeroInput))){
                Hero(userHeroInput).damageValue += Hero(userHeroInput).damageValue/100 * 10

            }else
                println("Das tut mir leid,  die Eingabe war nicht richtig ")

        }

    }
   /* constructor(name: String,healthPower: Int,speed: Int,level:Int): this(name,healthPower,speed){
        this.name=name
        this.healthPower=healthPower
        this.speed=speed

    }*/

}