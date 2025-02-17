fun main(){
    battleship().initialise()
}

class battleship {
    fun initialise(): MutableList<MutableList<Int>> {
        println("Initialisation du jeu")
        val zero = 0
        val initialRow: MutableList<Int> = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        val initializedBoard: MutableList<MutableList<Int>> = mutableListOf(initialRow, initialRow, initialRow, initialRow, initialRow, initialRow, initialRow, initialRow, initialRow, initialRow)
        return initializedBoard
    }
    fun randomBoats(){
        println("Placement des bateaux")

    }
}