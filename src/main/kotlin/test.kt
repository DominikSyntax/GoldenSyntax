import charakter.*


fun main() {

    val heroOne:Hero = NatureMutant("Hure",1000,100)
    val hurensohn :Endboss = Endboss("Hurensohn")
    var counter = 1



    do {
        println("Runde : $counter")
        absatz()
        displayHpHero(heroOne)
        displayHpEnemy(hurensohn)
        absatz()
        heroOne.kick(hurensohn)
        hurensohn.selfAttack(heroOne)
        heroOne.punch(hurensohn)
        heroOne.punch(hurensohn)
        println(heroOne.healthPower)
        println(hurensohn.healthPower)

        counter++

    }while (heroOne.healthPower > 0 && hurensohn.healthPower > 0)


}















