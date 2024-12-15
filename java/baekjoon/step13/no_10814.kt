package step13

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val members = (0 until n).map { Member(it, nextInt(), next()) }

    members.sortedWith(compareBy({ it.age }, { it.id })).forEach {
        println(it.getAgeAndName())
    }
}

data class Member(
    val id: Int,
    val age: Int,
    val name: String,
) {
    fun getAgeAndName(): String {
        return "$age $name"
    }
}