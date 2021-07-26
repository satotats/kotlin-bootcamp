package generics

import java.math.BigDecimal
import kotlin.Number

open class WaterSupply(var needsProcessing: Boolean)

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessing = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessing = false
    }
}

class Aquarium<out T: WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
//        if (waterSupply.needsProcessing) {
//            cleaner.clean(waterSupply)
//        }
//        println("water added")
    }

    inline fun <reified R: WaterSupply> hasWaterSupplyOfType() = waterSupply is R
}

fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${!aquarium.waterSupply.needsProcessing}")
}

fun genericsExample() {
    val aquarium = Aquarium(TapWater())
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")
    aquarium.waterSupply.addChemicalCleaners()
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")

    val aquarium2 = Aquarium(TapWater())
    addItemTo(aquarium2)

    val cleaner = TapWaterCleaner()
    val aquarium3 = Aquarium(TapWater())
    aquarium3.addWater(cleaner)

    val aquarium4 = Aquarium(TapWater())
    isWaterClean<TapWater>(aquarium4)
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

fun main() {
    genericsExample()

}
interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) = waterSupply.addChemicalCleaners()
}

class OutNumber<out T: Any>(val num: T) {
//    fun print (num: T) = println(num) // compile error
}
interface InNumber<in T: Number> {
    fun print(num: T)
}
class InNumberImpl<in T: Number>: InNumber<T> {
    override fun print (num: T) = println(num)
//    fun get(): T? = null // compile error
}

fun aaa() {
    // not compile error
    var ob2:OutNumber<Any> = OutNumber(BigDecimal.TEN)

    // compile error
    //    var ob3:OutNumber<BigDecimal> = OutNumber(Any())

    // not compile error
    var ii2: InNumberImpl<Int> = InNumberImpl<Number>()
    // compile error
    //    var ii3: InNumberImpl<Number> = InNumberImpl<Int>()
}
