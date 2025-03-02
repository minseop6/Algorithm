package step22

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val number = nextInt()
    val length = nextInt()
    val numbers = (1..number).toList()

    val duplicateBackTracker = DuplicateBackTracker(numbers, length)
    val result = numbers.flatMap { duplicateBackTracker.search(listOf(it)) }
    val stringBuilder = StringBuilder()
    result.forEach { stringBuilder.append("${it.joinToString(" ")}\n") }
    println(stringBuilder.toString())
}

data class DuplicateBackTracker(
    private val numbers: List<Int>,
    private val maxLength: Int,
) {
    fun search(currentValues: List<Int>): List<List<Int>> {
        if (isMaxLength(currentValues)) {
            return listOf(currentValues)
        }

        return numbers
            .flatMap { number -> search(currentValues + number) }
            .filter(::isMaxLength)
    }

    private fun isMaxLength(currentValues: List<Int>): Boolean {
        return currentValues.size == maxLength
    }
}