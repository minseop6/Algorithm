package step8

import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val numberOfTestCases = nextInt()
    val coins = listOf(25, 10, 5, 1)
    val results = (1..numberOfTestCases).map {
        val change = Change(nextInt())
        val counts = coins.map { coin -> change.calculateChange(coin) }
        counts.joinToString(" ")
    }
    println(results.joinToString("\n"))
}

data class Change(
    private var change: Int,
) {
    fun calculateChange(coinValue: Int): Int {
        val count = change / coinValue
        change %= coinValue
        return count
    }
}