package step22

import java.io.BufferedReader
import kotlin.math.abs
import kotlin.math.min
import kotlin.system.exitProcess

fun main() {
    val reader = BufferedReader(System.`in`.reader())
    val count = reader.readLine().toInt()
    val performanceTable = PerformanceTable(
        Array(count) { reader.readLine().split(" ").map { it.toInt() }.toTypedArray() }
    )


    val footballTeamBackTracker = FootballTeamBackTracker(
        performanceTable,
        count,
    )

    footballTeamBackTracker.search(0, 0)
    reader.close()
    footballTeamBackTracker.printResult()
}

data class FootballTeamBackTracker(
    private val performanceTable: PerformanceTable,
    private val numberOfPeople: Int,
) {
    private val visited: Array<Boolean> = Array(numberOfPeople) { false }
    private var minValue = Int.MAX_VALUE
    fun search(currentIndex: Int, depth: Int) {
        if (minValue == 0) {
            printResult()
        }

        if (depth == numberOfPeople / 2) {
            minValue = min(minValue, performanceTable.calculateByVisited(visited))
            return
        }

        for (i in currentIndex until numberOfPeople) {
            if (visited[i]) {
                continue
            }

            visited[i] = true
            search(currentIndex + 1, depth + 1)
            visited[i] = false
        }
    }

    fun printResult() {
        println(minValue)
        exitProcess(0)
    }
}

data class PerformanceTable(
    private val values: Array<Array<Int>>
) {
    fun calculateByVisited(visited: Array<Boolean>): Int {
        var team1 = 0
        var team2 = 0

        for (i in 0 until visited.size - 1) {
            for (j in i + 1 until visited.size) {
                if (visited[i] && visited[j]) {
                    team1 += values[i][j] + values[j][i]
                } else if (visited[i].not() && visited[j].not()) {
                    team2 += values[i][j] + values[j][i]
                }
            }
        }
        return abs(team1 - team2)
    }
}