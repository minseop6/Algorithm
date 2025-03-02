package step22

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val number = nextInt()
    val length = nextInt()
    val numbers = (1..number).toList()

    val backTracker = DeduplicateBackTracker(numbers, length)

    val result = numbers.flatMap { backTracker.search(setOf(it)) }

    result.forEach { println(it.joinToString(" ")) }
}

data class DeduplicateBackTracker(
    private val numbers: List<Int>,
    private val maxLength: Int,
) {
    fun search(currentValues: Set<Int>): List<List<Int>> {
        if (currentValues.size == maxLength) {
            return listOf(currentValues.toList())
        }

        return numbers.mapNotNull { number ->
            if (currentValues.contains(number)) {
                return@mapNotNull null
            }
            search(currentValues + number)
        }.flatten()
    }
}