package step14

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val sizeOfSetA = nextInt()
    val sizeOfSetB = nextInt()
    val setA = (0 until sizeOfSetA).map { nextInt() }.toSet()
    val setB = (0 until sizeOfSetB).map { nextInt() }.toSet()

    val result = setA.filter { !setB.contains(it) }.size + setB.filter { !setA.contains(it) }.size
    println(result)
}