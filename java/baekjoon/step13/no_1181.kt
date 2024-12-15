package step13

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val words = (0 until n).map { next() }.distinct()

    words.sortedWith(compareBy({ it.length }, { it })).forEach { println(it) }
}