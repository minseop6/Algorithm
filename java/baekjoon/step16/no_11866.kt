package step16

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val sequence = nextInt()
    val numbers = (1..n).map { it }
    val queue = LinkedList(numbers)

    val result = mutableListOf<Int>()
    while (queue.isNotEmpty()) {
        for (i in 1 until sequence) {
            queue.offer(queue.poll())
        }
        result.add(queue.poll())
    }

    println("<${result.joinToString(", ")}>")
}