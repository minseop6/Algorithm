package step14

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val (count, questionCount) = nextLine().split(" ").map { it.toInt() }
    val encyclopedia = Encyclopedia()
    (0 until count).forEach { _ -> encyclopedia.register(nextLine()) }
    val result = (0 until questionCount).map {
        val question = nextLine()
        val isIndexQuestion = question.toIntOrNull() != null
        if (isIndexQuestion) {
            encyclopedia.findByIndex(question.toInt())
        } else {
            encyclopedia.findByName(question.toString())
        }
    }

    result.forEach(::println)
}

data class Encyclopedia(
    private val pocketMonsterMap: MutableMap<String, Int> = mutableMapOf(),
    private val pocketMonsters: MutableList<String> = mutableListOf(),
) {
    fun register(pocketMonster: String) {
        pocketMonsterMap[pocketMonster] = pocketMonsterMap.size + 1
        pocketMonsters.add(pocketMonster)
    }

    fun findByName(pocketMonster: String): String {
        return (pocketMonsterMap[pocketMonster] ?: 0).toString()
    }

    fun findByIndex(index: Int): String {
        return pocketMonsters[index - 1]
    }
}