fun main(){
    battleship().randomBoatCoordinates()
}

class battleship {
    val playerOneBoard: MutableList<MutableList<Int>> = initialise()

    companion object {
        fun initialise(): MutableList<MutableList<Int>> {
            println("Initialisation du jeu")
            val initializedBoard: MutableList<MutableList<Int>> = mutableListOf()
            for (i in 0 until 10) {
                // Create a new row for each iteration
                val row = MutableList(10) { 0 }
                initializedBoard.add(row)
            }
            return initializedBoard
        }
    }

    fun randomizeBoatOrder(): MutableList<Int> {
        val carrier = 5
        val battleship = 4
        val cruiser = 3
        val submarine = 3
        val destroyer = 2
        val boats: MutableList<Int> = mutableListOf(carrier, battleship, cruiser, submarine, destroyer)
        boats.shuffle()
        return boats
    }

    private fun placeBoat(startRow: Int, startCol: Int, boatSize: Int, alignment: String){
        println("Bateau de taille $boatSize en ($startRow, $startCol) sens $alignment")
        if (alignment == "vertical"){
            for (i in startRow until startRow + boatSize){
                playerOneBoard[i][startCol] = 1
            }
        } else if (alignment == "horizontal"){
            for (i in startCol until startCol + boatSize){
                playerOneBoard[startRow][i] = 1
            }
        }
    }

    private fun hasEnoughSpaceForBoat(
        boatSize: Int,
        alignment: String,
        startRow: Int,
        startCol: Int
    ): Boolean {
        if (alignment == "vertical") {
            if (startRow + boatSize > playerOneBoard.size) return false
            for (i in 0 until boatSize) {
                if (playerOneBoard[startRow + i][startCol] != 0) return false
            }
        } else if (alignment == "horizontal") {
            if (startCol + boatSize > playerOneBoard[0].size) return false
            for (i in 0 until boatSize) {
                if (playerOneBoard[startRow][startCol + i] != 0) return false
            }
        }
        return true
    }

    fun randomBoatCoordinates() {
        val boats = randomizeBoatOrder()

        for (boatSize in boats) {
            var placed = false
            // Attempt to place the boat until successful (or a max attempt threshold)
            var attempts = 0
            while (!placed && attempts < 100) {
                val alignment = if ((1..2).random() % 2 == 0) "vertical" else "horizontal"
                val maxRow = if (alignment == "vertical") playerOneBoard.size - boatSize else playerOneBoard.size - 1
                val maxCol = if (alignment == "horizontal") playerOneBoard[0].size - boatSize else playerOneBoard[0].size - 1
                val startRow = (0..maxRow).random()
                val startCol = (0..maxCol).random()
                if (hasEnoughSpaceForBoat(boatSize, alignment, startRow, startCol)) {
                    placeBoat(startRow, startCol, boatSize, alignment)
                    placed = true
                }
                attempts++
            }
            if (!placed) {
                println("Impossible de placer $boatSize apres $attempts essais.")
            }
        }
        // Print the final board
        for (row in playerOneBoard) {
            println(row)
        }
    }
}
