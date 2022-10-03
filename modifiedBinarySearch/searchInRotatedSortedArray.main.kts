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

        var start = 0
        var end = nums.lastIndex

        while (end >= start) {
            val mid = start + (end - start) / 2

            if (nums[mid] == target) {
                return mid
            } else if (nums[start] < nums[mid]) {
                // left side is properly sorted
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid - 1
                } else {
                    start = mid + 1
                }
            } else if (nums[end] > nums[mid]) {
                // right side is properly sorted
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid + 1
                } else {
                    end = mid - 1
                }
            } else {
                 if (nums[start] == target) return start
                if (nums[end] == target) return end
                return -1
            }
        }

        return -1
    }
}

fun main() {
    println(Solution().search(intArrayOf(4,5,6,7,0,1,2), 0) == 4)
    println(Solution().search(intArrayOf(4,5,6,7,0,1,2), 3) == -1)
    println(Solution().search(intArrayOf(1), 0) == -1)
    println(Solution().search(intArrayOf(1,3), 0) == -1)
    println(Solution().search(intArrayOf(4,5,6,7,8,1,2,3), 8) == 4)
    println(Solution().search(intArrayOf(3,1), 1) == 1)
}
