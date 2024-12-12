package step13

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val numberOfCandidates = nextInt()
    val numberOfWinners = nextInt()
    val candidates = (1..numberOfCandidates).map { nextInt() }
    val sortedCandidates = candidates.sortedDescending()
    println(sortedCandidates[numberOfWinners - 1])
}