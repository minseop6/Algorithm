import java.util.LinkedList
import java.util.Queue

class 양과늑대 {
    private val tree = mutableMapOf<Int, Node>()
    private var answer = 0

    fun solution(info: IntArray, edges: Array<IntArray>): Int {
        info.forEachIndexed { index, isWolf ->
            tree[index] = Node(index, mutableListOf(), isWolf == 1)
        }
        edges.forEach { edge ->
            val index = edge[0]
            val node = tree[index]!!
            node.addNextNodeIndex(edge[1])
        }

        search(0, 0, 0, LinkedList())

        return answer
    }

    private fun search(
        currentIndex: Int,
        collectedSheepCount: Int,
        collectedWolfCount: Int,
        route: Queue<Node>
    ) {
        val currentNode = tree[currentIndex]!!
        val (currentSheepCount, currentWolfCount) = if (currentNode.isWolf) {
            collectedSheepCount to collectedWolfCount + 1
        } else {
            collectedSheepCount + 1 to collectedWolfCount
        }

        if (currentSheepCount <= currentWolfCount) {
            return
        }

        answer = maxOf(answer, currentSheepCount)

        val nextRoute = LinkedList(route)
        currentNode.nextNodeIndexes.forEach { nextNodeIndex ->
            nextRoute.add(tree[nextNodeIndex]!!)
        }

        repeat(nextRoute.size) {
            val nextNode = nextRoute.poll()
            search(nextNode.index, currentSheepCount, currentWolfCount, nextRoute)
            nextRoute.add(nextNode)
        }
    }
}

data class Node(
    val index: Int,
    val nextNodeIndexes: MutableList<Int>,
    val isWolf: Boolean,
) {
    fun addNextNodeIndex(nextIndex: Int) {
        nextNodeIndexes.add(nextIndex)
    }
}
