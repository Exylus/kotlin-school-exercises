fun main(){
    val FCbarcelona = Equipe("FC Barcelona", mutableListOf(), 0, 0, 0)
    FCbarcelona.ajouterJoueur()
    FCbarcelona.retirerJoueur()
    FCbarcelona.afficherComposition()
    println(FCbarcelona.calculerScoreEquipe())


}