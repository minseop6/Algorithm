package step22

import java.util.*
import kotlin.math.abs

fun main() = with(Scanner(System.`in`)) {
    val count = nextInt()
    var result = 0
    for (x in 0 until count) {
        val board = Board(count)
        board.set(x, 0)
        val backTracker = NQueenBackTracker(count)
        backTracker.search(x, 0, board)
        result += backTracker.getSucceedCount()
    }

    println(result)
}

data class NQueenBackTracker(private val queenCount: Int) {
    private var succeedCount = 0

    fun getSucceedCount(): Int {
        return succeedCount
    }

    fun search(x: Int, y: Int, board: Board): Boolean {
        for (currentY in 0 until y) {
            if (board.getXIndexByYIndex(currentY) == x || abs(x - board.getXIndexByYIndex(currentY)) == y - currentY) {
                return false
            }
        }

        if (y + 1 == queenCount) {
            succeedCount++
            return true
        }

        for (nextX in 0 until queenCount) {
            board.set(nextX, y + 1)
            search(nextX, y + 1, board)
        }

        return false
    }
}

data class Board(private val size: Int) {
    private val rows = Array(size) { 0 }

    fun getXIndexByYIndex(y: Int): Int {
        return rows[y]
    }

    fun set(x: Int, y: Int) {
        rows[y] = x
    }
}
