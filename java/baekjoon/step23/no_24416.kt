package step23

fun main() = with(System.`in`.bufferedReader()) {
    val number = readLine().toInt()
    val fibonacciDP = FibonacciDP()
    val fibonacciRecursive = FibonacciRecursive()
    fibonacciDP.search(number)
    fibonacciRecursive.search(number)
    print("${fibonacciRecursive.getRunningCount()} ${fibonacciDP.getRunningCount()}")
}

class FibonacciDP {
    private var runningCount = 0
    private val dp = IntArray(41)

    fun search(number: Int): Int {
        if (number == 1 || number == 2) {
            return 1
        }

        for (i in 3..number) {
            runningCount++
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        return dp[number]
    }

    fun getRunningCount(): Int {
        return runningCount
    }
}

class FibonacciRecursive {
    private var runningCount: Int = 0
    fun search(number: Int): Int {
        if (number == 1 || number == 2) {
            runningCount++
            return 1
        }

        return search(number - 1) + search(number - 2)
    }

    fun getRunningCount(): Int {
        return runningCount
    }
}
