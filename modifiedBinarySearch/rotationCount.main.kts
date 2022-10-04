// Given an array of numbers which is sorted in ascending order and is rotated ‘k’ times around a pivot, find ‘k’.
// You can assume that the array does not have any duplicates.

// It seems that it's enough to just find max number index and add 1 to it
// Always go to the side that is not properly sorted but keep last index from properly sorted size
class Solution {
    fun countRotations(nums: IntArray): Int {
        var start = 0
        var end = nums.lastIndex
        var maxValueIdx = -1
        var maxValue = Int.MIN_VALUE

        fun updateMaxValue(idx: Int) {
            if (nums[idx] > maxValue) {
                maxValue = nums[idx]
                maxValueIdx = idx
            }
        }

        while (end >= start) {
            val mid = start + (end - start ) / 2
            if (nums[start] <= nums[mid]) {
                // Left side is properly sorted
                start = mid + 1
                updateMaxValue(mid)
            } else {
                // Right side is properly sorted
                updateMaxValue(end)
                end = mid - 1
            }
        }

        return (maxValueIdx + 1) % nums.size
    }
}

fun main() {
    println(Solution().countRotations(intArrayOf(10, 15, 1, 3, 8)) == 2)
    println(Solution().countRotations(intArrayOf(4, 5, 7, 9, 10, -1, 2)) == 5)
    println(Solution().countRotations(intArrayOf(1, 3, 8, 10)) == 0)
    println(Solution().countRotations(intArrayOf(10, 1, 2, 3)) == 1)
}
