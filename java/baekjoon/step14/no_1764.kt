package step14

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val (neverSeenCount, neverListenCount) = nextLine().split(" ").map { it.toInt() }

    val neverSeenPeople = (0 until neverSeenCount).map { nextLine() }.toSet()
    val neverListenPeople = (0 until neverListenCount).map { nextLine() }

    val result = neverListenPeople.filter { neverSeenPeople.contains(it) }.sorted()

    println(result.size)
    result.forEach(::println)
}