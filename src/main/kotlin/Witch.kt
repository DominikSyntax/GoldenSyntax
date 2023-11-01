class Witch(override var name: String ="Agnes Waterhouse", override var healthPower: Int= 1500,
            override var damagePower: Int =100 ):Enemy(name,healthPower,damagePower) {


    /**
     * Die Hexe betet Dajjal an, dieser wird dadurch stärker (also + damagePower) und bekommt HP+
     * schön wäre es, wenn er in der Zeit, wo die Hexe betet, auf Sie aufpasst und Schaden abwendet
     */
    fun prayToTheBoss(boss:Endboss){
        boss.damagePower += 25
        boss.healthPower += 150
    }
}