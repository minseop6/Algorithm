package step16

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val commandCount = nextLine().toInt()

    val commandSet = (1..commandCount).map {
        val command = nextLine().split(" ")
        Command(command.first().toInt(), command.lastOrNull()?.toInt())
    }.let { CommandSet(it) }

    val results = commandSet.run()

    println(results.joinToString("\n"))
}

data class CommandSet(
    private val commands: List<Command>,
) {
    private val stack: Stack<Int> = Stack()
    fun run(): List<Int> {
        return commands.mapNotNull { command -> command.run(stack) }
    }
}

data class Command(
    private val type: Int,
    private val value: Int?
) {
    private val commands: Map<Int, (Stack<Int>) -> Int?> = mapOf(
        1 to ::push,
        2 to ::pop,
        3 to ::getSize,
        4 to ::isEmpty,
        5 to ::peek
    )

    fun run(stack: Stack<Int>): Int? {
        return commands[type]?.invoke(stack)
    }

    private fun push(stack: Stack<Int>): Int? {
        stack.push(value)
        return null
    }

    private fun pop(stack: Stack<Int>): Int {
        return stack
            .takeIf { it.isNotEmpty() }
            ?.let { stack.pop() }
            ?: -1
    }

    private fun getSize(stack: Stack<Int>): Int {
        return stack.size
    }

    private fun isEmpty(stack: Stack<Int>): Int {
        return if (stack.isEmpty()) 1 else 0
    }

    private fun peek(stack: Stack<Int>): Int {
        return stack
            .takeIf { it.isNotEmpty() }
            ?.let { stack.peek() }
            ?: -1
    }
}