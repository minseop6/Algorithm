package step13

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()
    val n = reader.readLine().toInt()

    val numbers = IntArray(10000001)
    for (i in 0 until n) {
        numbers[reader.readLine().toInt()]++
    }
    reader.close()

    numbers.indices.forEach {
        writer.write("$it\n".repeat(numbers[it]))
    }
    writer.close()
}
