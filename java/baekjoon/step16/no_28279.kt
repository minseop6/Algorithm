package step16

import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.`out`.bufferedWriter()
    val commandCount = reader.readLine().toInt()
    val commands = (1..commandCount).map { DequeueCommand.from(reader.readLine()) }
    reader.close()

    val processor = DequeueProcessor()
    val result = processor.process(commands)
    result.forEach {
        writer.write("$it\n")
    }

    writer.close()
}

data class DequeueProcessor(
    private val dequeue: Deque<Int> = LinkedList(),
    private val result: MutableList<Int> = mutableListOf()
) {
    fun process(commands: List<DequeueCommand>): List<Int> {
        commands.map { command ->
            when (command.command) {
                1 -> offerFirst(command.value)
                2 -> offerLast(command.value)
                3 -> pollFirst()
                4 -> pollLast()
                5 -> size()
                6 -> isEmpty()
                7 -> peekFirst()
                8 -> peekLast()
            }
        }
        return result
    }

    private fun offerFirst(value: Int) {
        dequeue.offerFirst(value)
    }

    private fun offerLast(value: Int) {
        dequeue.offerLast(value)
    }

    private fun pollFirst() {
        result.add(dequeue.pollFirst() ?: -1)
    }

    private fun pollLast() {
        result.add(dequeue.pollLast() ?: -1)
    }

    private fun size() {
        result.add(dequeue.size)
    }

    private fun isEmpty() {
        result.add(if (dequeue.isEmpty()) 1 else 0)
    }

    private fun peekFirst() {
        result.add(dequeue.peekFirst() ?: -1)
    }

    private fun peekLast() {
        result.add(dequeue.peekLast() ?: -1)
    }
}

data class DequeueCommand(val command: Int, val value: Int) {
    companion object {
        fun from(rawCommand: String): DequeueCommand {
            val currentCommand = rawCommand.split(" ")
            val command = currentCommand.first().toInt()
            val number = if (currentCommand.size > 1) currentCommand.last().toInt() else 0
            return DequeueCommand(command, number)
        }
    }
}