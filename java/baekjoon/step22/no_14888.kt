package step22

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val count = nextLine().toInt()
    val numbers = nextLine().split(" ").map { it.toInt() }
    val operatorsCount = nextLine().split(" ").map { it.toInt() }
    val operators = Operators(
        plus = operatorsCount[0],
        minus = operatorsCount[1],
        multiply = operatorsCount[2],
        divide = operatorsCount[3],
    )

    val backTracker = FormulaBackTracker(numbers, operators)
    backTracker.search(numbers[0], 1)
    backTracker.printResult()
}

data class FormulaBackTracker(
    private val numbers: List<Int>,
    private val operators: Operators,
) {
    private var maxValue = Int.MIN_VALUE
    private var minValue = Int.MAX_VALUE

    fun search(value: Int, count: Int) {
        if (count == numbers.size) {
            maxValue = maxOf(maxValue, value)
            minValue = minOf(minValue, value)
        }

        for (operation in Operators.Operation.entries) {
            if (operators.hasRemainOperator(operation).not()) {
                continue
            }

            operators.useOperator(operation)
            val calculatedValue = operators.operate(value, numbers[count], operation)
            search(calculatedValue, count + 1)
            operators.rollbackOperator(operation)
        }
    }

    fun printResult() {
        println(maxValue)
        println(minValue)
    }
}

data class Operators(
    private val plus: Int,
    private val minus: Int,
    private val multiply: Int,
    private val divide: Int,
) {
    private var remainPlus = plus
    private var remainMinus = minus
    private var remainMultiply = multiply
    private var remainDivide = divide

    fun operate(value: Int, number: Int, operation: Operation): Int {
        return when (operation) {
            Operation.PLUS -> value + number
            Operation.MINUS -> value - number
            Operation.MULTIPLY -> value * number
            Operation.DIVIDE -> value / number
        }
    }

    fun hasRemainOperator(operation: Operation): Boolean {
        return when (operation) {
            Operation.PLUS -> remainPlus > 0
            Operation.MINUS -> remainMinus > 0
            Operation.MULTIPLY -> remainMultiply > 0
            Operation.DIVIDE -> remainDivide > 0
        }
    }

    fun useOperator(operation: Operation) {
        when (operation) {
            Operation.PLUS -> remainPlus--
            Operation.MINUS -> remainMinus--
            Operation.MULTIPLY -> remainMultiply--
            Operation.DIVIDE -> remainDivide--
        }
    }

    fun rollbackOperator(operation: Operation) {
        when (operation) {
            Operation.PLUS -> remainPlus++
            Operation.MINUS -> remainMinus++
            Operation.MULTIPLY -> remainMultiply++
            Operation.DIVIDE -> remainDivide++
        }
    }

    enum class Operation {
        PLUS,
        MINUS,
        MULTIPLY,
        DIVIDE,
    }
}