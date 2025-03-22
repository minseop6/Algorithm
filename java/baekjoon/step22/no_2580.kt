package step22

import java.io.BufferedReader
import kotlin.system.exitProcess

fun main() {
    val reader = BufferedReader(System.`in`.reader())
    val sudokuBoard = SudokuBoard(
        (1..9).map {
            reader.readLine().split(" ").map { it.toInt() }.toMutableList()
        }.toMutableList()
    )

    val sudokuBackTracker = SudokuBackTracker(sudokuBoard)
    sudokuBackTracker.search(0, 0)
}

data class SudokuBackTracker(
    private val sudokuBoard: SudokuBoard
) {
    fun search(x: Int, y: Int) {
        if (y >= 9) {
            sudokuBoard.print()
            exitProcess(0)
        }

        if (sudokuBoard.get(x, y) != 0) {
            next(x, y)
        } else {
            for (number in 1..9) {
                if (sudokuBoard.isPossible(x, y, number).not()) {
                    continue
                }

                sudokuBoard.set(x, y, number)
                next(x, y)
                sudokuBoard.set(x, y, 0)
            }
        }
    }

    private fun next(x: Int, y: Int) {
        if (x == 8) {
            search(0, y + 1)
        } else {
            search(x + 1, y)
        }
    }
}

data class SudokuBoard(
    private val values: MutableList<MutableList<Int>>
) {
    fun get(x: Int, y: Int): Int {
        return values[y][x]
    }

    fun set(x: Int, y: Int, value: Int) {
        values[y][x] = value
    }

    fun isPossible(x: Int, y: Int, value: Int): Boolean {
        for (i in 0 until 9) {
            if (values[y][i] == value || values[i][x] == value) {
                return false
            }
        }

        val startX = (x / 3) * 3
        val startY = (y / 3) * 3

        for (i in startY until startY + 3) {
            for (j in startX until startX + 3) {
                if (values[i][j] == value) {
                    return false
                }
            }
        }

        return true
    }

    fun print() {
        values.forEach { println(it.joinToString(" ")) }
    }
}