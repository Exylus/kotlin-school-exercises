import kotlin.math.round
import kotlin.math.roundToInt

class Personne (name: String, weight: Double, height: Double){
    val name: String = name
    val weight: Double = weight
    val height: Double = height
    val imc = round(calculateIMC(weight, height) * 100) / 100

    fun calculateIMC (weight: Double, height: Double): Double{
        val imc = weight / (height * height)
        return imc
    }
    fun returnIMC(imc: Double): String{
        if (imc < 18.5){
            return "Poids inférieur à la normale"
        }
        else if (imc < 25){
            return "Poids normal"
        }
        else if (imc < 30){
            return "Surpoids"
        }
        else if (imc < 35){
            return "Obésité modérée"
        }
        else {
            return "Obésité"
        }
    }
}