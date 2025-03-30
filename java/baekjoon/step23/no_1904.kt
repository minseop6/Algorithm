package step23

fun main() = with(System.`in`.bufferedReader()) {
    val number = readLine().toInt()
    val binarySequenceDP = BinarySequenceDP(number)
    val count = binarySequenceDP.find()
    println(count)
}

data class BinarySequenceDP(
    val number: Int,
) {
    private val dp = IntArray(number + 1)

    init {
        for (i in 1..number) {
            dp[i] = when (i) {
                1, 2 -> i
                else -> (dp[i - 2] + dp[i - 1]) % 15746
            }
        }
    }

    fun find(): Int {
        return dp[number]
    }
}