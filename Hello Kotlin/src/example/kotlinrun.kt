package example

fun runExample() {
    // anonymous object
    val runnable = object: Runnable {
        override fun run() {
            println("I'm a Runnable")
        }
    }
    JavaRun.runNow(runnable)

    // in kotlin, we can write SAM implementation
    // without creating impl class or override declaration

    // JavaRun#runNow has only an SAM type argument: Runnable
    // and we can pass the implementation of the SAM
    // just by passing lambda which implements the SAM method
    JavaRun.runNow{
        println("Passing a lambda as a Runnable")
    }
}

fun main() {
    runExample()
}