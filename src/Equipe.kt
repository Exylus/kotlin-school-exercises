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

    fun ajouterJoueur(): MutableList<Joueur>{
        println("Veuillez entrer les informations du joueur\n Nom, Position, NbButs, nbPasses, cartonsJaunes, cartonsRouges")
        this.joueurs.add(Joueur(readln(), readln(), readln().toInt(), readln().toInt(), readln().toInt(), readln().toInt()))
        println("Le joueur a ete ajoute avec succes")
        return this.joueurs
    }

    fun retirerJoueur(): MutableList<Joueur> {
        for (joueur in this.joueurs) {
            println("${joueur.nom} => ${joueur.poste}")
        }
        println("Selectionner le joueur a retirer: ")
        joueurs.removeAll(joueurs.filter { it.nom == readln() })
        println("Le joueur a ete retire avec succes")

        return joueurs
    }

    fun afficherComposition(): MutableList<String> {
        var listeJoueurs: MutableList<String> = mutableListOf()
        for (joueur in this.joueurs) {
            listeJoueurs.add(joueur.nom)
        }
        if (listeJoueurs.isEmpty()) {
            println("Aucun joueur")
            return mutableListOf()
        }
            println("Liste des joueurs de l'equipe " + this.nom + "\n" + listeJoueurs.toString())
            return listeJoueurs;
    }

    fun calculerScoreEquipe(): Int {
        var score = 0
        for (joueur in joueurs) {
            score = joueur.nbButs * 3 + joueur.nbPasses - joueur.cartonsRouge * 3 - joueur.cartonsJaune
        }
        return score
    }
}