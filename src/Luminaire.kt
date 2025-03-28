class Luminaire(private val createBulb: () -> Eclairage) : Eclairage {
    private val ampoules = List(4) { createBulb() }

    override fun allumer() = ampoules.forEach { it.allumer() }
    override fun eteindre() = ampoules.forEach { it.eteindre() }
    override fun intensifier() = ampoules.forEach { it.intensifier() }
    override fun diminuer() = ampoules.forEach { it.diminuer() }

    override fun etat(): Int {
        return if (ampoules.all { it.etat() == -1 }) -1
        else ampoules.filter { it.etat() != -1 }.maxOfOrNull { it.etat() } ?: 0
    }

    override fun toString(): String = "${this::class.simpleName} : ${etat()}"
}