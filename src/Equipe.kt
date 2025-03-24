class Equipe {
    var nom: String = ""
    var joueurs: MutableList<Joueur> = mutableListOf()
    var nbVictoires:Int = 0
    var nbDefaites: Int = 0
    var nbNuls: Int = 0

    constructor()

    constructor(nom: String, joueurs: MutableList<Joueur> = mutableListOf(), nbVictoires: Int = 0, nbDefaites: Int = 0, nbNuls: Int = 0) {
        this.nom = nom
        this.joueurs = joueurs
        this.nbVictoires = nbVictoires
        this.nbDefaites = nbDefaites
        this.nbNuls = nbNuls
    }

    fun ajouterJoueur(): MutableList<Joueur>{
        println("Veuillez entrer les informations du joueur\n Nom & position: ")
        this.joueurs.add(Joueur().creerJoueur(readln(), readln()))
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
        println("Liste des joueurs de l'equipe " + this.nom + ": ")
        if (listeJoueurs.isEmpty()) {
            println("Aucun joueur")
            return mutableListOf()
        }
            println(listeJoueurs)
            return listeJoueurs;
    }

    fun calculerScoreEquipe(): Int {
        var score = 0
        for (joueur in joueurs) {
            score += joueur.nbButs * 3 + joueur.nbPasses - joueur.cartonsRouge * 3 - joueur.cartonsJaune
        }
        return score
    }
}