import java.util.*

// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/
// 
// Given `M` sorted arrays, find the smallest range that includes at least one number from each of the `M` lists.

class Solution {
    // Lenght of the range has to be the shortest possible
    // If there are multiple ranges with the same lenght, then that one starting earlier should be returned
    // lenght = max - min + 1
    // 4, 0, 5 -> [0, 5] -> 6
    // 4, 9, 5 -> [4, 9] -> 6
    // 10, 9, 5 -> [5, 10] -> 6
    // 10, 9, 18 -> [9, 18] -> 10
    // 10, 12, 18
    // 15, 12, 18
    // 15, 20, 18
    // 24, 20, 18
    // 24, 20, 22

    // I want to always have 3 elements on the heap
    // Smallest should be accessible on a heap - minHeap
    
    data class Item(val y: Int, val x: Int) {
        fun valueInArray(nums: List<List<Int>>): Int = nums[y][x]
    }

    // S: O(m) where m is numbers of rows (length of nums array)
    // T: O(n log m) where n is total number of elements in all arrays from nums array 
    fun smallestRange(nums: List<List<Int>>): IntArray {
        val minHeap = PriorityQueue<Item>(compareBy { nums[it.y][it.x] })
        var biggest = Int.MIN_VALUE
        var resultRange = intArrayOf()

        // Insert all first elements from each row
        for (y in 0 .. nums.lastIndex) {
            val row = nums[y]
            biggest = Math.max(row[0], biggest)
            minHeap.add(Item(y, 0))
        }

        while (minHeap.size == nums.size) {
            val smallestCoords = minHeap.poll()
            val smallest = nums[smallestCoords.y][smallestCoords.x]
    
            if (resultRange.isEmpty() || Math.abs(biggest - smallest) < Math.abs(resultRange[1] - resultRange[0])) {
                resultRange = intArrayOf(smallest, biggest)
            }

            val (y, x) = smallestCoords
            if (nums[y].size > x + 1) {
                biggest = Math.max(biggest, nums[y][x + 1])
                minHeap.add(Item(y, x + 1))
            }
        }

        return resultRange
    }
}

fun main() {
    val nums = listOf(
    	listOf(4,10,15,24,26),
        listOf(0,9,12,20),
        listOf(5,18,22,30)
    )
    println(Solution().smallestRange(nums).contentEquals(intArrayOf(20, 24)))
}
