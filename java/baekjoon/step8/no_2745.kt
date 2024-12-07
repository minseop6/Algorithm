package step8

import java.util.*
import kotlin.math.pow

fun main() = with(Scanner(System.`in`)) {
    val params = nextLine().split(" ")
    val numbers = params[0].split("").filter { it.isNotBlank() }.reversed()
    val radix = params[1].toInt()
    val result = numbers.mapIndexed { index, number ->
        radix.toDouble().pow(index.toDouble()) * toNumber(number)
    }.sum().toInt()

    println(result)
}

private fun toNumber(number: String): Int {
    return when (number) {
        in "A".."Z" -> number[0] - 'A' + 10
        else -> number.toInt()
    }
}