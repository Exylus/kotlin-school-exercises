//Écrire le programme Bonjour.kt qui demande à l’utilisateur de saisir son nom et qui affiche un
//message personnalisé ( « bonjour durand »)
fun hello(){
    println("Please indicate your first name: ")
    val name = readln().toString()
    println("Hello $name.")
}

//Écrire un programme qui demande l’âge de l’utilisateur et lui indique s’il a droit au tarif réduit
//(moins de 26 ans)
fun reducedPrice(){
    println("Please enter your age: ")
    val age = readln().toInt()
    if (age < 26){
        println("You are eligible for a price reduction")
    }
}
//Ecrire un programme Compteur.php qui permet de compter et d’afficher les nombres de 1 jusqu’à
//20.
fun counter(){
    for (i in 1..20){
        println("$i")
    }
}

//Check si la valeur donnée est pair
fun isEven(n: Int): Boolean{
    if (n % 2 == 0){
        return true
    }
    else {
        return false
    }
}

fun multiple(n: Int){
    for (i in 1..10){
        println("$n * $i = ${i * n}")
    }
}

fun randomFind(){
    var number: Int
    val randomNumber = (0..10).random()
    var hasBeenFound = false
    var triesLeft = 7

    while (!hasBeenFound){
        if (triesLeft > 0){
            println("Tries left: $triesLeft")
            print("Try to guess the number: ")
            number = readln().toInt()
            triesLeft--
        }
        else {
            println("No more tries left.")
            break
        }
        if (number == randomNumber){
            hasBeenFound = true
            println("You found the random number!")
        }
        else if(number > randomNumber){
            println("The random number is lower.")
        }
        else {
            println("The random number is higher.")
        }
    }
}
fun numbersInfo(){
    val numbers: MutableList<Int> = mutableListOf()
    val tabPair: MutableList<Int> = mutableListOf()
    val tabImpair: MutableList<Int> = mutableListOf()

    for (i in 1..10) {
        numbers += (0..100).random()
        if (numbers[i - 1] % 2 == 0){
            tabPair += numbers[i - 1]
        }
        else {
            tabImpair += numbers[i - 1]
        }
    }
    println(numbers)
    val maxNumber = numbers.max()
    val minNumber = numbers.min()
    val sum = numbers.sum()
    println("The sum is $sum, the minimum is $minNumber, and the maximum is $maxNumber.")
    println(tabPair)
    println(tabImpair)
}

fun serie(n: Int): List<Int>{
    val maliste: MutableList<Int> = mutableListOf()
    for (i in 1..n){
        maliste.add(i)
    }
    return maliste
}

fun serieInverse(n: Int): List<Int>{
    val maliste: MutableList<Int> = mutableListOf()
    for (i in (1..n).reversed()){
        maliste.add(i)
    }
    return maliste
}

fun parity(numbers: MutableList<Int>): MutableList<MutableList<Int>> {
    val evenList: MutableList<Int> = mutableListOf()
    val oddList: MutableList<Int> = mutableListOf()

    for (i in 0..<numbers.size - 1) {
        if (isEven(numbers[i])) {
            evenList.add(numbers[i])
        } else {
            oddList.add(numbers[i])
        }
    }
    val parityList: MutableList<MutableList<Int>> = mutableListOf(evenList, oddList)
    return parityList
}

fun getTableau(quantity: Int, range: Int): MutableList<Int> {
    val tableau: MutableList<Int> = mutableListOf()
    for (i in 1..quantity) {
        tableau.add((1..range).random())
    }
    return tableau
}

fun listeDiviseurs(n: Int): MutableList<Int> {
    val tableau: MutableList<Int> = mutableListOf()
    for (i in 1..n){
        if (n % i == 0){
            tableau.add(i)
        }
    }
    return tableau
}

fun estPremier(n: Int): Boolean {
    if (listeDiviseurs(n).size != 2){
        return false
    }
    else {
        return true
    }
}

fun main(){
    println(parity(getTableau(10, 100)))
    println(listeDiviseurs(100))
}