fun main() {
    val result = 이모티콘할인행사().solution(
        arrayOf(
            intArrayOf(40, 10000),
            intArrayOf(25, 10000),
        ),
        intArrayOf(7000, 9000)
    )

    result.forEach { print("$it ") }
}