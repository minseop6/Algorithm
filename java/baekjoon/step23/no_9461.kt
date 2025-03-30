package step23

fun main() = with(System.`in`.bufferedReader()) {
    val padovanSequenceDP = PadovanSequenceDP()
    val count = readLine().toInt()
    val numbers = (1..count).map { readLine().toInt() }
    numbers.forEach { number ->
        padovanSequenceDP.run(number)
    }
}

class PadovanSequenceDP {
    private val dp = LongArray(101)

    init {
        for (i in 1..100) {
            dp[i] = when (i) {
                1, 2, 3 -> 1
                else -> dp[i - 2] + dp[i - 3]
            }
        }
    }

    fun run(number: Int) {
        println(dp[number])
    }
}