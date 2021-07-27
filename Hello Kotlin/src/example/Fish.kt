package example

data class Fish (var name: String)

fun fishExamples() {
    val fish = Fish("splashy")  // all lowercase
    with (fish.name) {
        println(capitalize())
    }

    myWith (fish.name) {
        println(capitalize())
    }

    // "apply" returns the object after applying the function
    val fish2 = Fish(name = "splashy").apply {
        name = "sharky"
    }
    println(fish2.name)

    // "run" returns lambda's execution result itself
    // what is different with let??????
    // It seems to me that the difference is using "this" or "it"...

    println(fish.run { "Hello" }
        .run{ this + "fish" }
        .run{ length }
        .run{ this + 31 })
    println(fish)

    println(fish.let { "Hello" }
        .let{it + "fish" }
        .let{it.length }
        .let{it + 31})
    println(fish)


    // At the first call of "run", the argument may be parsed to
    // Fish.() -> String
    // while "let"'s be
    // (arg: Fish) -> String
}




fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}

fun main () {
    fishExamples()
}