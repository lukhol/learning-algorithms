#!/usr/bin/envkotlin kotlin
// https://leetcode.com/problems/binary-search/submissions/
// For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.

class Solution {
    // -1, 0, 3, 5, 9, 12
    // startIdx = 0, endIdx = 5, middleIdx = 2
    // startIdx = 0, endIdx = 2, middleIdx = 1
    // startIdx = 1, endIdx = 2, middleIdx = 1
    fun search(nums: IntArray, target: Int): Int {
        var startIdx = 0
        var endIdx = nums.lastIndex
        while (endIdx >= startIdx) {
            var middleIdx = (endIdx + startIdx) / 2  
            if (nums[middleIdx] == target) {
                return middleIdx
            } else if (target > nums[middleIdx]) {
                startIdx = middleIdx + 1
            } else if (target < nums[middleIdx]) {
                endIdx = middleIdx - 1
            }
        }
        
        return -1
    }
}

println(Solution().search(intArrayOf(-1,0,3,5,9,12), 2) == -1)
println(Solution().search(intArrayOf(-1,0,3,5,9,12), 9) == 4)
