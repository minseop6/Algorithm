package step13

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val coordinates = (0 until n).map {
        nextInt() to nextInt()
    }

    val sortedCoordinates = coordinates.sortedWith(compareBy({ it.second }, { it.first }))
    sortedCoordinates.forEach { println("${it.first} ${it.second}") }
}