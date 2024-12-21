package step14

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextLine().toInt()
    val accessRecords = AccessRecords()
    (0 until n)
        .forEach { _ ->
            val (name, status) = nextLine().split(" ")
            accessRecords.record(name, status)
        }

    val result = accessRecords.getWorkingEmployees().joinToString("\n")
    println(result)
}

class AccessRecords {
    private val employees = mutableMapOf<String, Boolean>()

    fun record(name: String, status: String) {
        employees[name] = isEnter(status)
    }

    fun getWorkingEmployees(): List<String> {
        return employees
            .filter { it.value }
            .keys
            .sortedDescending()
    }

    private fun isEnter(status: String): Boolean {
        return status == "enter"
    }
}