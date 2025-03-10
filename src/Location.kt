class Location(name: String, category: String, nbKilometers: Int, nbDays: Int) {
    init {
        println(totalAmount(category, nbKilometers, nbDays))
    }

    fun category (category : String) : Int {
        var price : Int = 0
        when(category){
            "E" -> price = 30
            "C" -> price = 50
            "L" -> price = 70
            else -> price = 0
        }
        return price
    }

    fun parseCategory (price: Int) : Boolean {
        if (price == 0) {
            return false
        }
        return true
    }

    fun rentalAmount(price : Int, nbDays : Int) : Int {
        return price * nbDays
    }

    fun additionnalFee(nbDays: Int, nbKilometers: Int) : Double {
        val fee = 0.5 * (nbKilometers - (nbDays * 100))
        if (fee < 0) {
            return 0.0
        }
        return fee
    }

    fun totalAmount(category : String, nbKilometers: Int, nbDays: Int) : Double {
        if (parseCategory(category(category))) {
            return (rentalAmount(category(category), nbDays)+additionnalFee(nbKilometers, nbDays))
        }
        else return 0.0
    }
}
