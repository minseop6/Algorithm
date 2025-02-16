package step16

import java.util.*
import kotlin.math.abs

fun main() = with(Scanner(System.`in`)) {
    val n = nextLine().toInt()
    val balloons = nextLine().split(" ").mapIndexed { index, number ->
        Balloon(index + 1, number.toInt())
    }.toMutableList()

    val balloonGameProcessor = BalloonGameProcessor(balloons)

    val result = (1..n).map { balloonGameProcessor.process() }

    println(result.joinToString(" "))
}

data class BalloonGameProcessor(
    private val dequeue: MutableList<Balloon>
) {
    fun process(): Int {
        val currentBalloon = dequeue.removeFirst()

        val processFunction = if (currentBalloon.isPositive()) {
            ::processPositiveNumber
        } else {
            ::processNegativeNumber
        }

        if (dequeue.isNotEmpty()) {
            processFunction.invoke(currentBalloon.number)
        }

        return currentBalloon.index
    }

    private fun processNegativeNumber(number: Int) {
        repeat(abs(number)) {
            dequeue.add(0, dequeue.removeLast())
        }
    }

    private fun processPositiveNumber(number: Int) {
        repeat(number - 1) {
            dequeue.add(dequeue.removeFirst())
        }
    }
}

data class Balloon(
    val index: Int,
    val number: Int,
) {
    fun isPositive() = number > 0
}