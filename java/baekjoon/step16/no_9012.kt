package step16

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val count = nextLine().toInt()

    val results = (1..count).map {
        val stack = Stack<String>()
        val parenthesisString = nextLine()
        val parenthesises = parenthesisString.split("").filter { it.isNotEmpty() }

        parenthesises.forEach { parenthesis ->
            when {
                parenthesis == "(" -> stack.push(parenthesis)
                stack.isEmpty() -> return@map "NO"
                else -> stack.pop()
            }
        }

        if (stack.isEmpty()) {
            "YES"
        } else {
            "NO"
        }
    }

    println(results.joinToString("\n"))
}