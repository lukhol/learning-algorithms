// https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/description/

fun main() {
    println(Solution().findLeastNumOfUniqueInts(intArrayOf(5, 5, 4), 1) == 1)
    println(Solution().findLeastNumOfUniqueInts(intArrayOf(4, 3, 1, 1, 3, 3, 2), 3) == 2)
}

class Solution {
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
        val map = hashMapOf<Int, Int>()
        arr.forEach {
            map.compute(it) { _, value ->
                if (value == null) 1 else value + 1
            }
        }

        val minHeap = PriorityQueue<Map.Entry<Int, Int>> { a, b -> a.value - b.value }
        minHeap.addAll(map.entries)

        var removed = 0
        while (removed != k) {
            val current = minHeap.peek()
            if (removed + current.value <= k) {
                minHeap.poll()
                removed += current.value
            } else {
                break
            }
        }

        return minHeap.size
    }
}
