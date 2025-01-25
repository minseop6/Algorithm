package step16

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val count = nextInt()
    val ledger = Ledger()
    (1..count).forEach { _ ->
        ledger.write(nextInt())
    }

    println(ledger.sum())
}

data class Ledger(
    private val stack: Stack<Int> = Stack()
) {
    fun write(value: Int) {
        if (value == 0) {
            stack.pop()
        } else {
            stack.push(value)
        }
    }

    fun sum(): Int {
        if (stack.isEmpty()) {
            return 0
        }
        return stack.sum()
    }
}
