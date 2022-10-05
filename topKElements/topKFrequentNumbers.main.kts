// https://leetcode.com/problems/top-k-frequent-elements/description/

// Given an unsorted array of numbers, find the top `K` frequently occurring numbers in it.

class Solution {

    data class Item(val number: Int, val count: Int)

    fun topKFrequent(nums: IntArray, k: Int): List<Int> {
        val map = hashMapOf<Int, Int>()
        for (num in nums) {
            map.compute(num) { _, prev -> if (prev == null) 1 else prev + 1 }
        }

        val heap = PriorityQueue<Item> { a, b -> b.count - a.count }
        for (entry in map) {
            heap.add(Item(entry.key, entry.value))
        }

        val result = IntArray(k)
        for (i in 0 until k) {
            result[i] = heap.poll().number
        }

        return result.toList()
    }
}

fun main() {
    println(Solution().topKFrequent(intArrayOf(1, 3, 5, 12, 11, 12, 11), 2) == listOf(11, 12))
    println(Solution().topKFrequent(intArrayOf(5, 12, 11, 3, 1), 2) == listOf(1, 12))
}
