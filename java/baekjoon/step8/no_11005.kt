package step8

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val params = nextLine().split(" ")
    val number = params[0]
    val radix = params[1].toInt()
    var remain = number.toInt()
    val result = mutableListOf<String>()
    while (remain > 0) {
        val digit = remain % radix
        remain /= radix
        result.add(toRadixNumber(digit))
    }
    println(result.reversed().joinToString(""))
}

private fun toRadixNumber(number: Int): String {
    return when (number) {
        in 10..35 -> (number + 'A'.code - 10).toChar().toString()
        else -> number.toString()
    }
}