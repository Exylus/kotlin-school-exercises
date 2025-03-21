fun main(){
    val FCbarcelona = Equipe("FC Barcelona", mutableListOf(), 0, 0, 0)
    FCbarcelona.ajouterJoueur(FCbarcelona.joueurs)
    FCbarcelona.retirerJoueur(FCbarcelona.joueurs)
    println(FCbarcelona.calculerScoreEquipe())


}