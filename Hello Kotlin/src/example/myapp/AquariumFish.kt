package example.myapp


class Shark: FishColor,
    FishAction by PrintingFishAction("hunt and eat fish") {
    override val color = "gray"
}

class Plecostomus(fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor {
    override fun eat() {
        println("eat algae")
    }
}

interface FishAction {
    fun eat()
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

interface FishColor  {
    val color: String
}

object GoldColor : FishColor {
    override val color = "gold"
}

sealed class Seal
class SeaLion : Seal()
class Walrus : Seal()

fun matchSeal(seal: Seal): String {
    return when(seal) {
        is Walrus -> "walrus"
        is SeaLion -> "sea lion"
    }
}
