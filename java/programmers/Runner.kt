fun main() {
    val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 2),
        intArrayOf(1, 4),
        intArrayOf(0, 8),
        intArrayOf(8, 7),
        intArrayOf(9, 10),
        intArrayOf(9, 11),
        intArrayOf(4, 3),
        intArrayOf(6, 5),
        intArrayOf(4, 6),
        intArrayOf(8, 9)
    )
    val result = 양과늑대().solution(
        intArrayOf(0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1),
        edges,
    )

    println(result)
}