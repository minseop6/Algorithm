package step16

import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()
    val count = reader.readLine().toInt()

    val integerQueue = IntegerQueue()
    val result = (1..count).mapNotNull {
        val (command, number) = CommandParser.parse(reader.readLine())
        integerQueue.execute(command, number)
    }
    reader.close()

    result.forEach {
        writer.write("$it\n")
    }
    writer.close()
}

data class CommandParser(
    val command: String,
    val number: Int
) {
    companion object {
        fun parse(rawCommand: String): Pair<String, Int> {
            val currentCommand = rawCommand.split(" ")
            val command = currentCommand.first()
            val number = if (currentCommand.size > 1) currentCommand.last().toInt() else 0
            return Pair(command, number)
        }
    }
}

data class IntegerQueue(
    private val queue: Queue<Int> = LinkedList()
) {
    private val commandMap = mapOf(
        "push" to { number: Int -> push(number) },
        "pop" to { pop() },
        "size" to { size() },
        "empty" to { empty() },
        "front" to { front() },
        "back" to { back() }
    )

    fun execute(command: String, number: Int): Int? {
        return commandMap[command]?.invoke(number)
    }

    private fun push(number: Int): Int? {
        queue.add(number)
        return null
    }

    private fun pop(): Int {
        return queue.poll() ?: -1
    }

    private fun size(): Int {
        return queue.size
    }

    private fun empty(): Int {
        return if (queue.isEmpty()) 1 else 0
    }

    private fun front(): Int {
        return queue.peek() ?: -1
    }

    private fun back(): Int {
        return queue.lastOrNull() ?: -1
    }
}