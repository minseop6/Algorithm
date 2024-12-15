package step13

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val originCoordinates = (0 until n).map { nextInt() }
    val coordinates = Coordinates(originCoordinates)

    val result = originCoordinates.map { coordinate ->
        coordinates.getCompressionCoordinate(coordinate)
    }.joinToString(" ")

    println(result)
}

data class Coordinates(
    private val coordinates: List<Int>
) {
    private val coordinateMap = coordinates
        .distinct()
        .sorted()
        .withIndex()
        .associate { (index, value) -> value to index }

    fun getCompressionCoordinate(coordinate: Int): Int {
        return coordinateMap[coordinate] ?: 0
    }
}
