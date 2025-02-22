package step16

import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val dataStructureCount = reader.readLine().toInt()
    val dataStructures = reader.readLine().split(" ").map { DataStructure(it.toInt()) }
    val initialValues = reader.readLine().split(" ").map { it.toInt() }

    val queueStack = QueueStack.from(dataStructures, initialValues)
    val count = reader.readLine().toInt()
    val result = reader.readLine().split(" ").map { value ->
        queueStack.run(value.toInt())
    }

    println(result.joinToString(" "))

    reader.close()
}

data class QueueStack(
    private val values: Deque<Int> = LinkedList()
) {
    companion object {
        fun from(dataStructures: List<DataStructure>, initialValues: List<Int>): QueueStack {
            val queueStack = QueueStack()
            dataStructures.zip(initialValues).forEach { (dataStructure, value) ->
                if (dataStructure.isQueue()) {
                    queueStack.addFirst(value)
                }
            }
            return queueStack
        }
    }

    fun run(value: Int): Int {
        add(value)
        return pollFirst()
    }

    private fun addFirst(value: Int) {
        values.addFirst(value)
    }

    private fun add(value: Int) {
        values.add(value)
    }

    private fun pollFirst(): Int {
        return values.pollFirst()
    }
}

class DataStructure(
    private val type: Type,
) {
    constructor(rawType: Int) : this(
        type = when (rawType) {
            1 -> Type.STACK
            else -> Type.QUEUE
        }
    )

    fun isQueue(): Boolean {
        return type == Type.QUEUE
    }

    enum class Type {
        STACK, QUEUE
    }
}
