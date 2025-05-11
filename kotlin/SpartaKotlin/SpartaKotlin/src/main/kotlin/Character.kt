open class Character {
    val damage = 10
    var healthPoint = 100
    fun attack(target: Character) {
        target.takeAttack(damage)
    }
    open fun takeAttack(damage: Int) {
        healthPoint -= damage
    }
}

class CharacterWithArmor: Character() {
    val defensePoint = 3
    override fun takeAttack(damage: Int) {
        val actualDamage = (damage - defensePoint)
        super.takeAttack(actualDamage)

    }
}