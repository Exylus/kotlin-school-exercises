fun main(){
    var lesPersonnes = mutableListOf<Personne>()
    lesPersonnes.add(Personne("Nekena", 53.0, 1.58))
    lesPersonnes.add(Personne("Erwan", 115.0, 1.7))
    lesPersonnes.add(Personne("Enzo", 51.0, 1.68))
    lesPersonnes.add(Personne("Kellyane", 51.0, 1.64))
    lesPersonnes.add(Personne("Maili", 94.0, 1.64))
    lesPersonnes.add(Personne("Antoine", 58.0, 1.75))

    var cumulTaille = 0.0
    for ( unePersonne in lesPersonnes){
        println("${unePersonne.name} a un imc de ${unePersonne.imc}")
        cumulTaille += unePersonne.height
    }
    println("La taille moyenne est de ${cumulTaille/lesPersonnes.size}")
}