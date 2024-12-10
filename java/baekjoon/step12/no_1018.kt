package step12

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val y = nextInt()
    val x = nextInt()

    val board = Array(y) { next() }
    var minValue = Int.MAX_VALUE
    for (xIndex in 0..x - 8) {
        for (yIndex in 0..y - 8) {
            val section = board
                .slice(yIndex..yIndex + 7)
                .map { it.slice(xIndex..xIndex + 7) }

            minValue = minOf(
                countSquaresToBeFilled('W', section),
                countSquaresToBeFilled('B', section),
                minValue
            )
        }
    }

    println(minValue)
}

private fun countSquaresToBeFilled(color: Char, section: List<String>): Int {
    var currentColor = color
    var count = 0
    for (yIndex in 0..7) {
        val line = section[yIndex]
        for (xIndex in 0..7) {
            if (line[xIndex] != currentColor) {
                count += 1
            }
            currentColor = changeColor(currentColor)
        }
        currentColor = changeColor(currentColor)
    }
    return count
}

private fun changeColor(color: Char): Char {
    return if (color == 'W') 'B' else 'W'
}