package step16

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val results = mutableListOf<String>()
    while (true) {
        val string = nextLine()
        if (string == ".") {
            break
        }

        val result = ParenthesisParser(string).parse()
        results.add(result)
    }

    println(results.joinToString("\n"))
}

data class ParenthesisParser(
    private val string: String,
    private val stack: Stack<String> = Stack()
) {
    fun parse(): String {
        string
            .split("")
            .filter(String::isNotBlank)
            .forEach { char ->
                when (char) {
                    "(", "[" -> stack.push(char)
                    ")" -> {
                        if (stack.isEmpty() || stack.peek() != "(") {
                            return "no"
                        }
                        stack.pop()
                    }

                    "]" -> {
                        if (stack.isEmpty() || stack.peek() != "[") {
                            return "no"
                        }
                        stack.pop()
                    }
                }
            }

        return if (stack.isEmpty()) {
            "yes"
        } else {
            "no"
        }
    }
}