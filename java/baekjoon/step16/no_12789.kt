package step16

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val count = nextLine().toInt()
    val ticketNumbers = (1..count).map { nextInt() }
    val snackQueue = SnackQueue()
    ticketNumbers.forEach(snackQueue::next)

    println(if (snackQueue.isSorted()) "Nice" else "Sad")
}

data class SnackQueue(
    private val stack: Stack<Int> = Stack(),
    private val sortedTickets: MutableList<Int> = mutableListOf(),
) {
    fun next(ticketNumber: Int) {
        when {
            stack.isEmpty() || stack.peek() - 1 >= ticketNumber -> comparePriorities(ticketNumber)
            stack.peek() < ticketNumber -> rearrange(ticketNumber)
        }
    }

    fun isSorted(): Boolean {
        while (stack.isNotEmpty()) {
            val ticketNumber = stack.pop()
            sortedTickets.add(ticketNumber)
        }
        return sortedTickets.zipWithNext().all { (prev, next) -> prev < next }
    }

    private fun comparePriorities(currentTicketNumber: Int) {
        val ticketNumber = sortedTickets.lastOrNull() ?: 0
        if (ticketNumber + 1 == currentTicketNumber) {
            sortedTickets.add(currentTicketNumber)
        } else {
            stack.push(currentTicketNumber)
        }
    }

    private fun rearrange(currentTicketNumber: Int) {
        if (stack.isNotEmpty() && stack.peek() < currentTicketNumber) {
            val ticketNumber = stack.pop()
            sortedTickets.add(ticketNumber)
            rearrange(currentTicketNumber)
        }
    }
}
