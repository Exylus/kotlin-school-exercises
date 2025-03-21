class Joueur {
    var nom: String = ""
    var poste: String = ""
    var nbButs: Int = 0
    var nbPasses: Int = 0
    var cartonsJaune: Int = 0
    var cartonsRouge: Int = 0

    constructor()

    constructor(nom: String, poste: String, nbButs: Int, nbPasses: Int, cartonsJaune: Int, cartonsRouge: Int){
        this.nom = nom
        this.poste = poste
        this.nbButs = nbButs
        this.nbPasses = nbPasses
        this.cartonsJaune = cartonsJaune
        this.cartonsRouge = cartonsRouge
    }

    fun marquerBut(): Int = this.nbButs++

    fun fairePasse(): Int = this.nbPasses++

    fun recevoirCartonJaune(): Int = this.cartonsJaune++

    fun recevoirCartonRouge(): Int = this.cartonsRouge++

    fun afficherStats(){
        println("Nom: " + this.nom)
        println("Poste: " + this.poste)
        println("Nombre de Buts: " + this.nbButs)
        println("Nombre de Passes: " + this.nbPasses)
        println("CartonsJaune: " + this.cartonsJaune)
        println("CartonsRouge: " + this.cartonsRouge)
    }
}