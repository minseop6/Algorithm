package step8

import java.util.*
import kotlin.math.pow

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val numberOfTimes = nextInt()
    var numberOfPointOnLine = 2
    repeat(numberOfTimes) {
        numberOfPointOnLine += 2.0.pow(it.toDouble()).toInt()
    }
    val totalPointCount = numberOfPointOnLine.toDouble().pow(2.0).toInt()
    println(totalPointCount)
}