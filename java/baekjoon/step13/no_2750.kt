package step13

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val sortedNumbers = (1..n).map { nextInt() }.sorted()
    sortedNumbers.forEach(::println)
}