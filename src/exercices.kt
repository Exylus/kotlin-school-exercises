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

fun parity(n: Int){
    if (n % 2 == 0){
        println("$n is even")
    }
    else {
        println("$n is odd")
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

fun main(){
    randomFind()
}