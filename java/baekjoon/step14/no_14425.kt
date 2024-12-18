package step14

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val (stringCount, inspectionStringCount) = nextLine().split(" ").map { it.toInt() }
    val strings = (0 until stringCount).map { nextLine() }.toSet()
    val inspectionStrings = (0 until inspectionStringCount).map { nextLine() }

    val result = inspectionStrings.filter { inspectionString ->
        strings.contains(inspectionString)
    }.size

    println(result)
}