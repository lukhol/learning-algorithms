import java.util.PriorityQueue

// Given ‘M’ sorted arrays, find the K’th smallest number among all the arrays.
//

data class Item(val value: Int, val arrayIndex: Int, val inArrayIndex: Int)

fun findKthSmallest(lists: List<IntArray>, k: Int): Int {
    val resultMaxHeap = PriorityQueue<Item>(compareByDescending { it.value })
    val processingHeap = PriorityQueue<Item>(compareByDescending { it.value })

    lists.forEachIndexed { index, it ->
        if (it.isNotEmpty()) {
            processingHeap.add(Item(it[0], index, 0))
        }
    }

    while (processingHeap.isNotEmpty()) {
        val current = processingHeap.poll()
        resultMaxHeap.add(current)
        if (resultMaxHeap.size > k) {
            resultMaxHeap.poll()
        }

        val (_, arrayIndex, inArrayIndex) = current
        if (lists[arrayIndex].size > inArrayIndex + 1) {
            processingHeap.add(Item(lists[arrayIndex][inArrayIndex + 1], arrayIndex, inArrayIndex + 1))
        }
    }

    return resultMaxHeap.poll().value
}

fun test1() {
    val l1 = intArrayOf(2, 6, 8)
    val l2 = intArrayOf(3, 6, 7)
    val l3 = intArrayOf(1, 3, 4)
    val lists = arrayListOf(l1, l2, l3)

    // 1, 2, 3, 3, 4, 6, 6, 7, 8
    println(findKthSmallest(lists, 5) == 4)
}

fun test2() {
    val l1 = intArrayOf(5, 8, 9)
    val l2 = intArrayOf(1, 7)
    val lists = arrayListOf(l1, l2)

    // 1, 2, 3, 3, 4, 6, 6, 7, 8
    println(findKthSmallest(lists, 3) == 7)
}

test1()
test2()
