package step12

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    var count = 0
    var number = 665
    while (count < n) {
        number++
        if (number.toString().contains("666")) {
            count++
        }
    }
    println(number)
}