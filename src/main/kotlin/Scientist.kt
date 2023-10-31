class Scientist(override var name: String = "Prof. Proton", override var healthPower: Int = 750,
                override var damagePower: Int = 75):Human(name,healthPower,damagePower) {
}