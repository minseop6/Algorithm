package step13

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val numbers = (1..5).map { nextInt() }
    val average = numbers.sum() / 5
    val middleNumber = numbers.sorted()[2]

    println(average)
    println(middleNumber)
}