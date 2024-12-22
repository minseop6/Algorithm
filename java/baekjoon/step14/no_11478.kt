package step14

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val string = nextLine()
    val length = string.length

    val substringSet = mutableSetOf<String>()
    for (i in 0 until length) {
        for (j in 0 until length - i) {
            substringSet.add(string.substring(j, j + i + 1))
        }
    }

    println(substringSet.size)
}