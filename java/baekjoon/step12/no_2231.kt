package step12

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val number = nextInt()
    val valueCandidates = (number downTo 1).mapNotNull { currentNumber ->
        val sum =
            currentNumber + currentNumber.toString()
                .split("")
                .filter(String::isNotBlank)
                .sumOf { it.toInt() }
        if (sum != number) {
            return@mapNotNull null
        }
        return@mapNotNull currentNumber
    }

    println(valueCandidates.minOrNull() ?: 0)
}
