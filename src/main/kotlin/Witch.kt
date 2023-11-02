class Witch(override var name: String , override var healthPower: Int= 1500,
            override var damagePower: Int =100 ):Enemy(name,healthPower,damagePower) {


    /**
     * Die Hexe betet Dajjal an, dieser wird dadurch stärker (also + damagePower) und bekommt HP+
     * schön wäre es, wenn er in der Zeit, wo die Hexe betet, auf Sie aufpasst und Schaden abwendet
     */
    fun prayToTheBoss(boss:Endboss):Int{
        val rounds = (2..4).random()
        boss.damagePower += 25
        boss.healthPower += 50
        return rounds
    }


    fun poisen(hero: Hero):Int{
        var rounds: Int = (1..3).random()
        hero.healthPower -= 25
        return rounds

    }

    fun powerToTheBadGuys(enemys:MutableList<Enemy>){

        for (enemy in enemys){
            var bonusPower = (10..20).random()
            enemy.damagePower += bonusPower
            println("Die Hexe hat durch einen Zauber, ${enemy.name} $bonusPower Punkte für die Schadenskraft gegeben")
        }

    }

    fun four(){

    }
}