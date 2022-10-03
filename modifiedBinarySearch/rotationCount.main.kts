// Given an array of numbers which is sorted in ascending order and is rotated ‘k’ times around a pivot, find ‘k’.
// You can assume that the array does not have any duplicates.

class Solution {
    fun countRotations(nums: IntArray): Int {
        TODO()
    }
}

fun main() {
    println(Solution().countRotations(intArrayOf(10, 15, 1, 3, 8)) == 2)
    println(Solution().countRotations(intArrayOf(4, 5, 7, 9, 10, -1, 2)) == 5)
    println(Solution().countRotations(intArrayOf(1, 3, 8, 10)) == 0)
}
