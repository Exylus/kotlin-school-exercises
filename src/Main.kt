fun main() {
    testDevice(AmpouleIncandescente(), "Ampoule Incandescente")
    testDevice(AmpouleLed(), "Ampoule LED")
    testDevice(AmpouleTube(), "Tube Neon")
    testDevice(Luminaire(::AmpouleIncandescente), "Luminaire Incandescent")
}

fun testDevice(device: Eclairage, name: String) {
    println("Test: $name")
    var cycles = 0
    do {
        device.allumer()
        var previousState: Int
        do {
            previousState = device.etat()
            device.diminuer()
        } while (device.etat() > 0 && device.etat() != previousState)
        cycles++
    } while (cycles < 1000 && device.etat() != -1)

    println("$name à complété $cycles cycles\n")
}