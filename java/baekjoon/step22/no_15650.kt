package step22

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val number = nextInt()
    val length = nextInt()
    val numbers = (1..number).toList()

    val ascendingBackTracker = AscendingBackTracker(numbers, length)
    val result = numbers.flatMap { ascendingBackTracker.search(setOf(it)) }
    result.forEach { println(it.joinToString(" ")) }
}

data class AscendingBackTracker(
    private val numbers: List<Int>,
    private val maxLength: Int,
) {
    fun search(currentValues: Set<Int>): List<List<Int>> {
        if (currentValues.size == maxLength) {
            return listOf(currentValues.toList())
        }

        return getFilteredNumbers(currentValues)
            .flatMap { number -> search(currentValues + number) }
            .filter { it.size == maxLength }
    }

    private fun getFilteredNumbers(currentValues: Set<Int>): List<Int> {
        return numbers.filter {
            val isNotContained = currentValues.contains(it).not()
            val isGreaterThanLastValue = currentValues.last() < it
            isNotContained && isGreaterThanLastValue
        }
    }
}