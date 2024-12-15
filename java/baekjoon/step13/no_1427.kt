package step13

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val numbers = nextLine()
        .map { it.toString().toInt() }
        .toIntArray()

    println(numbers.sortedDescending().joinToString(""))
}