import java.util.*

class 두큐합같게만들기 {
    fun solution(array1: IntArray, array2: IntArray): Int {
        val values1 = array1.toList().map { it.toLong() }
        val values2 = array2.toList().map { it.toLong() }
        val values = values1 + values2
        val accumulatedValue = values.sum()
        if (accumulatedValue % 2 != 0L) {
            return -1
        }
        val expectedSumOfValue = (accumulatedValue / 2)
        if (!values.predicate(expectedSumOfValue)) {
            return -1
        }

        val queue1: Queue<Long> = LinkedList()
        val queue2: Queue<Long> = LinkedList()
        queue1.addAll(values1)
        queue2.addAll(values2)

        var answer = 0
        var accumulatedQueue1Value = queue1.sum()
        var accumulatedQueue2Value = queue2.sum()
        while (accumulatedQueue1Value != expectedSumOfValue || accumulatedQueue2Value != expectedSumOfValue) {
            if (accumulatedQueue1Value - accumulatedQueue2Value > 0) {
                val value = queue1.poll()
                accumulatedQueue2Value += value
                accumulatedQueue1Value -= value
                queue2.add(value)
            } else {
                val value = queue2.poll()
                accumulatedQueue1Value += value
                accumulatedQueue2Value -= value
                queue1.add(value)
            }
            answer++
        }

        return answer
    }

    private fun List<Long>.predicate(expectedValue: Long): Boolean {
        var leftPoint = 0
        var rightPoint = 0
        var accumulatedValue = 0L
        while (leftPoint < this.size && rightPoint < this.size) {
            if (accumulatedValue < expectedValue)  {
                accumulatedValue += this[rightPoint]
                rightPoint++
            } else if(accumulatedValue == expectedValue) {
                if (this.filterIndexed { index, _ -> index !in leftPoint until rightPoint }.sum() == expectedValue) {
                    return true
                }
                accumulatedValue -= this[leftPoint]
                leftPoint++
            } else {
                accumulatedValue -= this[leftPoint]
                leftPoint++
            }
        }
        return false
    }
}