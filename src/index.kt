fun main(){
    val fcBarcelona = Equipe("FC Barcelona")
    fcBarcelona.ajouterJoueur()
    fcBarcelona.retirerJoueur()
    fcBarcelona.afficherComposition()
    println(fcBarcelona.calculerScoreEquipe())
}