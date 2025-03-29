package step23

fun main() = with(System.`in`.bufferedReader()) {
    val formulaDP = FormulaDP()
    while (true) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        if (formulaDP.isEndCondition(a, b, c)) {
            break
        }
        formulaDP.run(a, b, c)
    }
}

class FormulaDP {
    private val dp: Array<Array<IntArray>> = Array(21) { Array(21) { IntArray(21) } }

    init {
        for (a in 0..20) {
            for (b in 0..20) {
                for (c in 0..20) {
                    dp[a][b][c] = if (a == 0 || b == 0 || c == 0) {
                        1
                    } else if (a < b && b < c) {
                        dp[a][b][c - 1] + dp[a][b - 1][c - 1] - dp[a][b - 1][c]
                    } else {
                        dp[a - 1][b][c] + dp[a - 1][b - 1][c] + dp[a - 1][b][c - 1] - dp[a - 1][b - 1][c - 1]
                    }
                }
            }
        }
    }

    fun isEndCondition(a: Int, b: Int, c: Int): Boolean {
        return a == -1 && b == -1 && c == -1
    }

    fun run(a: Int, b: Int, c: Int) {
        val result = if (a <= 0 || b <= 0 || c <= 0) {
            1
        } else if (a > 20 || b > 20 || c > 20) {
            dp[20][20][20]
        } else {
            dp[a][b][c]
        }

        println("w($a, $b, $c) = $result")
    }
}