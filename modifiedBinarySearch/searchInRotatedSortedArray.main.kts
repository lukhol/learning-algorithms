// https://leetcode.com/problems/search-in-rotated-sorted-array/

// Given an array of numbers which is sorted in ascending order and also rotated
// by some arbitrary number, find if a given ‘key’ is present in it.

// Write a function to return the index of the ‘key’ in the rotated array. If the ‘key’ is 
// not present, return -1. You can assume that the given array does not have any duplicates.

// S: O(1)
// T: O(3logn) = O(logn)
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return -1
        if (nums.size == 1) {
            return if (nums.first() == target) 0 else -1
        }

        fun findIdxOfBiggestElement(): Int {
            var start = 0
            var end = nums.lastIndex

            var max = Int.MIN_VALUE
            var maxIdx = -1

            while (end >= start) {
                val mid = start + (end - start) / 2
                if (nums[mid + 1] > nums[mid]) {
                    start = mid + 1
                } else {
                    end = mid - 1
                }

                if (nums[mid] > max) {
                    max = nums[mid]
                    maxIdx = mid
                }
            }

            return maxIdx
        }

        val biggerValueIdx = findIdxOfBiggestElement()
        val firstPartIds = binarySearch(nums, target, 0, biggerValueIdx)
        return if (firstPartIds != -1) firstPartIds
        else binarySearch(nums, target, biggerValueIdx + 1, nums.lastIndex)
    }

    private fun binarySearch(nums: IntArray, target: Int, initialStart: Int, initialEnd: Int): Int {
        var start = initialStart
        var end = initialEnd

        while (end >= start) {
            val mid = start + (end - start) / 2

            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] > target) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }

        return -1
    }
}

fun main() {
    println(Solution().search(intArrayOf(4,5,6,7,0,1,2), 0) == 4)
    println(Solution().search(intArrayOf(4,5,6,7,0,1,2), 3) == -1)
    println(Solution().search(intArrayOf(1), 0) == -1)
}
