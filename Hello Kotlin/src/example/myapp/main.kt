package example.myapp

fun buildAquarium() {
    println("--- #buildAquarium ---")
    val aquarium1 = Aquarium()
    aquarium1.printSize()
    // default height and length
    val aquarium2 = Aquarium(width = 25)
    aquarium2.printSize()
    // default width
    val aquarium3 = Aquarium(height = 35, length = 110)
    aquarium3.printSize()
    // everything custom
    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()

    println("* aquarium6 *")
    val aquarium6 = Aquarium(length = 25, width = 25, height = 40)
    aquarium6.printSize()

    println("* TowerTank *")
    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()
}

fun makeFish() {
    println()
    println("--- #makeFish ---")
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}

fun testSeal() {
    println()
    println("--- #matchSeal ---")
    println(matchSeal(SeaLion()))
    println(matchSeal(Walrus()))
}

fun main() {
    buildAquarium()
    makeFish()
    testSeal()
}