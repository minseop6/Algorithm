package step16

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val cardCount = nextInt()
    val cards = (1..cardCount).map { it }
    val queue = LinkedList(cards)

    while (queue.size > 1) {
        queue.poll()
        queue.poll()?.let { queue.offer(it) }
    }

    println(queue.poll())
}