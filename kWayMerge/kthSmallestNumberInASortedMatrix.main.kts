import java.util.*

// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/

// Given an N*N matrix where each row and column is sorted in ascending order, find the Kth smallest element in the matrix.

class Solution {
    data class Item(val value: Int, val arrayIdx: Int, val inArrayIdx: Int)

    // S: O(n) - where n is matrix row count
    // T: O(k log n) - where k is kth smallest element
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val minHeap = PriorityQueue<Item>(compareBy { it.value })

        matrix.forEachIndexed { index, list ->
            minHeap.add(Item(list[0], index, 0))
        }

        var numberCount = 0
        var result = 0
        while (minHeap.isNotEmpty()) {
            val current = minHeap.poll()
            numberCount++

            val (_, arrayIdx, inArrayIdx) = current
            val newInArrayIdx = inArrayIdx + 1
            if (matrix[arrayIdx].size > newInArrayIdx) {
                minHeap.add(Item(matrix[arrayIdx][newInArrayIdx], arrayIdx, newInArrayIdx))
            }

            if (numberCount == k) { 
                result = current.value
                return result
            }
        }
        
        return result
    }
}

fun main() {
    println(Solution().kthSmallest(arrayOf(intArrayOf(2, 6, 8), intArrayOf(3, 7, 10), intArrayOf(5, 8, 11)), 5) == 7)
}
