package example

import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.findAnnotation

@ImAPlant class Plant {
    @get:OnGet
    val isGrowing: Boolean = true
    @set:OnSet
    var needsFood: Boolean = false

    fun trim(){}
    fun fertilize(){}
}

fun testAnnotations() {
    val classObj = Plant::class
    for (m in classObj.annotations) {
        println(m.annotationClass.simpleName)
    }

    val myAnnotationObject = classObj.findAnnotation<ImAPlant>()
    println(myAnnotationObject)
}
fun main() {
    testAnnotations()
    labels()
}

annotation class ImAPlant
@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet
@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

fun labels() {
    outerLoop@ for (i in 1..100) {
        print("$i ")
        for (j in 1..100) {
            if (i > 10) continue@outerLoop  // breaks to outer loop
//            if (i > 10) break@outerLoop  // breaks to outer loop
        }
    }
}

// https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/join-to-string.html