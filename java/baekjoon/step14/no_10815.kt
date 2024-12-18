package step14

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val heldCardCount = nextInt()
    val heldCards = (0 until heldCardCount).map { nextInt() }.toSet()
    val predicateCardCount = nextInt()
    val predicateCards = (0 until predicateCardCount).map { nextInt() }

    val result = predicateCards.map { predicateCard ->
        if (heldCards.contains(predicateCard)) {
            1
        } else {
            0
        }
    }.joinToString(" ")

    println(result)
}