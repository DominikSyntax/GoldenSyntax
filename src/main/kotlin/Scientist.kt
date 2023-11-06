class Scientist(
    override var name: String = "Prof. Proton", override var healthPower: Int = 750,
    override var damagePower: Int = 75
) : Human(name, healthPower, damagePower) {

    var rickIsUsed = false

    override fun printAllFunktion() {
        println(
            "1 -> Schlagen \n" +
                    "2 -> Treten \n" +
                    "3 ->  Fahrzeugkontrolle \n" +
                    "4 -> NanoBot Hilfe \n" +
                    "5 -> lebendige Kabel \n" +
                    "6 -> Rucksack benutzen"
        )
    }

    /**
     * Die Attack Funktion hat jeder Held, sie bekommt:
     * @param bag - einen gemeinsamen Rucksack
     * @param int - die Auswahl der Funktion nach printAll Funktion
     */
    override fun attack(bag: Bag ,int: Int,enemies:MutableList <Enemy>,heros:MutableList<Hero>) {

        when (int) {
            1 -> punch(evilChoice(enemies))
            2 -> kick(evilChoice(enemies))
            3 -> tankChocolate(heroChoice(heros))
            4 -> macGyver(evilChoice(enemies))
            5 -> rickAndMorty(enemies)
            6 -> bag.useBag(heros)
        }
    }

    fun tankChocolate(hero: Hero) {
        println("Der Professor hatte noch etwas Panzer Schokolade für ${hero.name}")
        if (!hero.usedTankChocolade) {
            hero.healthPower += 100
            hero.damagePower += 25
            println("${hero.name} ist ganz schön auf zündung, 100 Lebenspunkte und 25 Schadenskraft kommen hinzu")
            println()
            println("Das ist jetzt einmal gut gegangen, dir bist aber schon klar was Panzerschockolade ist? Beim nächsten mal hat ${hero.name} vielleicht nicht so ein Glück")
            hero.usedTankChocolade = true
        }else{
            println("Hatte ist dich nicht gewarnt? Du willst ${hero.name} zwei mal am selben Tag M E T H geben? \n" +
                    "Vielleicht rufe ich schon einmal bei deinem Bewährungshelfer an, während du noch spielst...")
            println()
            println("Ohje, ${hero.name} sieht auch gar nicht mal so gut aus ")
            Thread.sleep(1500)
            if (hero.healthPower >50) {
                hero.healthPower -= 50
                hero.damagePower -= 12
                println(" Oh man, 50 Punkte an Lebensenergie verloren und 12 Punkte schwächer ist ${hero.name} jetzt auch noch")
                println()
                Thread.sleep(1500)
            }else{
                println("${hero.name} hatte einen Herzinfarkt und ist raus aus dem rennen")
                hero.isDead = true
                hero.healthPower = 0
                println()
                println("Naja... wenigstens mit einem lächeln im gesicht")
            }
        }

    }

    fun macGyver(enemy: Enemy) {
        println(" Sieh nur, der Prof hat aus herumliegenden Knochenteilen, etwas benutztem Klebeband, einem Kabel, Alufolie und etwas Spucke etwas gebaut... ")
        Thread.sleep(1500)
        println("...")
        Thread.sleep(1000)
        println(
            "... OMG, es ist eine autonome Drohne mit kleinem CRISPR-CAS 9 Gentechnik Labor an Board. \n" +
                    "Sie kann beim Gegner die Start HP feststellen und ihm durch eine Genveränderung Lebenspunkte und Schadenskraft abziehen"
        )
        var abzug = enemy.standartHP / 100 * (7..9).random()
        var damageAbzug = enemy.damagePower / 100 * (10..12).random()
        if (enemy.healthPower <= abzug) {
            println()
            println("Für ${enemy.name} war das wohl zuviel")
            enemy.healthPower = 0
            enemy.isDead = true
            println()
        } else {
            enemy.healthPower -= abzug
            enemy.damagePower -= damageAbzug
            println()
            println("$abzug Abzug an Lebenspunkten und $damageAbzug Punkte Abzug an AngriffsKraft für ${enemy.name} ")
            println()
        }


    }

    fun rickAndMorty(enemies:MutableList<Enemy>) {
        var abzug:Int
        if (rickIsUsed) {
            println("Sorry, ich hab dir aber auch gesagt das es zuviel Energie benötigt")
            println()
            println("Wenn du so ein Schlaumi bist, hol doch deine Doppelgänger aus den anderen Dimensionen und greif die Gegner an.")

        }else{
            println("Der Prof. scheint auch jedes Klischee, eines verrückten Wissenschaftlers zu bedienen... einfallsreicher Programmierer ... Respekt ")
            println()
            Thread.sleep(1500)
            println("Hat er sich gerade ein paar Haare rausgerissen und in diese komische Waffe gesteckt? Was will er machen? Den Gegner mit Schuppen beschießen bis der zum Hautarzt muss?")
            println()
            Thread.sleep(1500)
            println("Er hat ein Loch ins Univerum geschossen...")
            println()
            Thread.sleep(1500)
            println("...")
            Thread.sleep(1500)
            println("Unzählige Professoren kommen durch das Loch auf unsere Seite und greifen die Gegner an ")
            for (enemy in enemies){
                abzug = enemy.healthPower/100 * (7..10).random()
                if (abzug <= 50){
                    println()
                    println("...tja, die anderen sind wohl auch nicht so häufig im Fitness Studio gewesen.")
                    println("$abzug Abzug an Lebenspunkten bei ${enemy.name}, besser als nix")
                }else if ((abzug > 50) && (abzug <= 150)){
                    println("... okay, die Anzahl machts, einige Rick's ..ähhh... ich meinte Professoren haben sich ${enemy.name} geschnappt")
                    println("Zusammen haben sie ihm immerhin $abzug Abzug an Lebensenergie beschert, ich hoffe bei den ganzen toten ist nicht unser Professor")
                }else{
                    println("Guck mal, wie viele sich auf ${enemy.name} werfen")
                    println("Sie haben ihr spannendes Wissenschaftler Leben für unser Erde geopfert, für ... naja für $abzug Punkte Abzug, sind es dann doch viele Leichen")

                }
                enemy.healthPower -= abzug
                println()
                Thread.sleep(1500)
                println("Der Prof hat den Jahres -Verbruch, eines mittelgroßen Landen, mit nur einen Schuss verbraucht. Diese Attacke kannst du für den Rest des Spieles nicht mehr nutzen")
                println()
                Thread.sleep(1500)
                rickIsUsed = true

            }

        }

    }
}

