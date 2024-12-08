package step12

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val (cardCount, targetValue) = nextLine()
        .split(" ")
        .map { it.toInt() }
        .let { Pair(it[0], it[1]) }
    val cards = nextLine()
        .split(" ")
        .filter(String::isNotBlank)
        .map(String::toInt)

    var maxValue = Int.MIN_VALUE
    for (firstIndex in 0 until cardCount) {
        for (secondIndex in firstIndex + 1 until cardCount) {
            for (thirdIndex in secondIndex + 1 until cardCount) {
                val sum = cards[firstIndex] + cards[secondIndex] + cards[thirdIndex]
                if (sum <= targetValue) {
                    maxValue = maxOf(maxValue, sum)
                }
            }
        }
    }

    println(maxValue)
}
