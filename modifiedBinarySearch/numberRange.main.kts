#!/usr/bin/envkotlin kotlin
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

// S: O(1)
// T: O(2logn) = O(logn)
class Solution {

    // Given an array of numbers sorted in ascending order, find the range of a given number 'key'.
    // The range of the 'key' will be the first and last position of the 'key' in the array.
    // Write a function to return the range of the 'key'. If the ‘key’ is not present return [-1, -1].

    // target = 8
    // 0, 1, 2, 3, 4, 5
    // 5, 7, 7, 8, 8, 10
    // startIdx = 0, endIdx = 5, middleIdx = 2
    // startIdx = 2, endIdx = 5, middleIdx = 3
    // Now target can be to the left and to the right of middle
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val maxIdx = search(nums, target, true)
        if (maxIdx == -1) return intArrayOf(-1, -1)
        val minIdx = search(nums, target, false)
        return intArrayOf(minIdx, maxIdx)
    }

    private fun search(nums: IntArray, target: Int, findMaxIndex: Boolean): Int {
        var index = -1
        var startIdx = 0
        var endIdx = nums.lastIndex

        while (endIdx >= startIdx) {
            val middleIdx = (startIdx + endIdx) / 2
            if (target > nums[middleIdx]) {
                startIdx = middleIdx + 1
            } else if (target < nums[middleIdx])  {
                endIdx = middleIdx - 1
            } else {
                // Target was found. We need to store it because in the next step we are going
                // +/- 1 from middleIdx and current can be last/first occurrence.
                index = middleIdx
                if (findMaxIndex) {
                    startIdx = middleIdx + 1
                } else {
                    endIdx = middleIdx - 1
                }
             }
        }

        return index
    }
}

fun main() {
    val expected = intArrayOf(3, 4)
    val actual = Solution().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8)
    println(expected.contentEquals(actual))

    val expected1 = intArrayOf(-1, -1)
    val actual1 = Solution().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6)
    println(expected1.contentEquals(actual1))

    val expected2 = intArrayOf(0, 0)
    val actual2 = Solution().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 5)
    println(expected2.contentEquals(actual2))
}

main()
