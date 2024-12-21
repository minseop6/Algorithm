package step14

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val cardCount = nextInt()
    val cards = mutableMapOf<Int, Int>()
    (0 until cardCount).forEach { _ ->
        val cardNumber = nextInt()
        cards[cardNumber] = cards.getOrDefault(cardNumber, 0) + 1
    }
    val questionCount = nextInt()
    val result = (0 until questionCount).map {
        val question = nextInt()
        cards[question] ?: 0
    }.joinToString(" ")

    println(result)
}