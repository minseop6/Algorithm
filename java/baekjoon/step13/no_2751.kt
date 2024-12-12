package step13

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val numbers = (1..n).map { nextInt() }
    println(numbers.sorted().joinToString("\n"))
}