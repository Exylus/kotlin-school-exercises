fun hello(){
    println("Please indicate your first name: ")
    val name = readln().toString()
    println("Hello $name.")
}

fun reducedPrice(){
    println("Please enter your age: ")
    val age = readln().toInt()
    if (age < 26){
        println("You are eligible for a price reduction")
    }
}

fun counter(){
    for (i in 1..20){
        println("$i")
    }
}

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

fun parity(numbers: MutableList<Int>): Array<MutableList<Int>> {
    val parityList: MutableList<Int> = mutableListOf()
    val evenList: MutableList<Int> = mutableListOf()
    val oddList: MutableList<Int> = mutableListOf()
    for (i in 0..numbers.size - 1){
        if (isEven(numbers[i])) {
            evenList.add(numbers[i])
        }
        else {
            oddList.add(numbers[i])
        }
    }
    val parity: Array<MutableList<Int>> = arrayOf(evenList, oddList)
    return parity
}

fun getTableau(): MutableList<Int>{
    val tableau: MutableList<Int> = mutableListOf()
    for (i in 1..10){
        tableau.add((1..100).random())
    }
    return tableau
}
fun main(){
    println(serieInverse(10))
    println(parity(getTableau()))
}