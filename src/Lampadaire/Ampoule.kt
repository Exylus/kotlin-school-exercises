open class Ampoule(
    private val nom: String,
    private val probaPanne: Int
) : Eclairage {

    protected var etat: Int = 0

    override fun allumer() {
        if (etat == -1) return
        if ((0..100).random() < probaPanne) {
            etat = -1
        } else {
            etat = 10
        }
    }

    override fun eteindre() {
        if (etat != -1) etat = 0
    }

    override fun intensifier() {
        if (etat != -1 && etat < 10) etat++
    }

    override fun diminuer() {
        if (etat != -1 && etat > 0) etat--
    }

    override fun etat(): Int = etat

    override fun toString(): String = "${this::class.simpleName} : $etat"
}