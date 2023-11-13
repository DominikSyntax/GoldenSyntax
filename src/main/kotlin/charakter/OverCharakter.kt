package charakter

open class OverCharakter(open var name: String, open var healthPower: Int, open var damagePower: Int) {

    open var isDead: Boolean =
        if (healthPower <= 0 ){
            true
        }else {
            false
        }


    open var standartHP = healthPower




}