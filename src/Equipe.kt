class Equipe {
    var nom: String = ""
    var joueurs: MutableList<Joueur> = mutableListOf()
    var nbVictoires:Int = 0
    var nbDefaites: Int = 0
    var nbNuls: Int = 0

    constructor()

    constructor(nom: String, joueurs: MutableList<Joueur>, nbVictoires: Int, nbDefaites: Int, nbNuls: Int) {
        this.nom = nom
        this.joueurs = joueurs
        this.nbVictoires = nbVictoires
        this.nbDefaites = nbDefaites
        this.nbNuls = nbNuls
    }

    fun ajouterJoueur(joueurs: MutableList<Joueur>): MutableList<Joueur>{
        println("Veuillez entrer les informations du joueur\n Nom, Position, NbButs, nbPasses, cartonsJaunes, cartonsRouges")
        joueurs.add(Joueur(readln(), readln(), readln().toInt(), readln().toInt(), readln().toInt(), readln().toInt()))
        return joueurs
    }

    fun retirerJoueur(joueurs: MutableList<Joueur>): MutableList<Joueur> {
        for (joueur in joueurs) {
            println("${joueur.nom} => ${joueur.poste}")
        }
        println("Selectionner le joueur a retirer: ")
        joueurs.removeAll(joueurs.filter { it.nom == readln() })

        return joueurs
    }

    fun afficherComposition(nom : String): MutableList<Joueur> {
        return joueurs
    }

    fun calculerScoreEquipe(): Int {
        var score = 0
        for (joueur in joueurs) {
            score = joueur.nbButs * 3 + joueur.nbPasses - joueur.cartonsRouge * 3 - joueur.cartonsJaune
        }
        return score
    }
}