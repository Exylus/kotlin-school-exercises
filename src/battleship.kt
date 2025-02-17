fun main(){
    val game = battleship()  // Create one instance
    game.logBoards()         // Log the boards for that instance
}

class battleship {
    val playerOneBoard: MutableList<MutableList<Int>> = randomBoatCoordinates(initialise())
    val playerTwoBoard: MutableList<MutableList<Int>> = randomBoatCoordinates(initialise())

    fun logBoards() {
        println("Player 1's board:")
        for (row in playerOneBoard) {
            println(row)
        }
        println("Player 2's board:")
        for (row in playerTwoBoard) {
            println(row)
        }
    }

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

    private fun placeBoat(
        playerBoard: MutableList<MutableList<Int>>,
        startRow: Int,
        startCol: Int,
        boatSize: Int,
        alignment: String
    ) {
        println("Bateau de taille $boatSize en ($startRow, $startCol) sens $alignment")
        if (alignment == "vertical") {
            for (i in startRow until startRow + boatSize) {
                playerBoard[i][startCol] = 1
            }
        } else if (alignment == "horizontal") {
            for (i in startCol until startCol + boatSize) {
                playerBoard[startRow][i] = 1
            }
        }
    }

    private fun hasEnoughSpaceForBoat(
        playerBoard: MutableList<MutableList<Int>>,
        boatSize: Int,
        alignment: String,
        startRow: Int,
        startCol: Int
    ): Boolean {
        if (alignment == "vertical") {
            if (startRow + boatSize > playerBoard.size) return false
            for (i in 0 until boatSize) {
                if (playerBoard[startRow + i][startCol] != 0) return false
            }
        } else if (alignment == "horizontal") {
            if (startCol + boatSize > playerBoard[0].size) return false
            for (i in 0 until boatSize) {
                if (playerBoard[startRow][startCol + i] != 0) return false
            }
        }
        return true
    }

    fun randomBoatCoordinates(playerBoard: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
        val boats = randomizeBoatOrder()

        for (boatSize in boats) {
            var placed = false
            var attempts = 0
            while (!placed && attempts < 100) {
                val alignment = if ((1..2).random() % 2 == 0) "vertical" else "horizontal"
                val maxRow = if (alignment == "vertical") playerBoard.size - boatSize else playerBoard.size - 1
                val maxCol = if (alignment == "horizontal") playerBoard[0].size - boatSize else playerBoard[0].size - 1
                val startRow = (0..maxRow).random()
                val startCol = (0..maxCol).random()
                if (hasEnoughSpaceForBoat(playerBoard, boatSize, alignment, startRow, startCol)) {
                    placeBoat(playerBoard, startRow, startCol, boatSize, alignment)
                    placed = true
                }
                attempts++
            }
            if (!placed) {
                println("Impossible de placer $boatSize apres $attempts essais.")
            }
        }
        return playerBoard
    }
}
