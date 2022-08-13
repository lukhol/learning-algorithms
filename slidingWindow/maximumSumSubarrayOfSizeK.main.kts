#!/usr/bin/env kotlin

// Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.

// S: O(1)
// T: O(n)
fun maximumSumSubarrayOfSizeK(array: List<Int>, k: Int): List<Int> {
    var resultStart = 0
    var resultEnd = 0

    var startIdx = 0
    var maxSum = 0
    var currentSum = 0

    for (endIdx in array.indices) {
        currentSum += array[endIdx]

        if (endIdx - startIdx == k - 1) {
            if (currentSum > maxSum) {
                maxSum = currentSum
                resultStart = startIdx
                resultEnd = endIdx
            }

            currentSum -= array[startIdx]
            startIdx++
        }
    }


    return array.subList(resultStart, resultEnd + 1)
}

val result = maximumSumSubarrayOfSizeK(listOf(2, 1, 5, 1, 3, 2), 3)
assert(result == listOf(5, 1, 3))

val result2 = maximumSumSubarrayOfSizeK(listOf(2, 3, 4, 1, 5), 2)
assert(result2 == listOf(3, 4))


// Original question and answer
// T: O(nk)
// S: O(1)
fun maximumSumSubarrayOfSizeKResult(array: List<Int>, k: Int): Int {
    var maxSum = 0

    for (i in 0 .. array.size - k) {
        var windowSum = 0
        for (j in i until i + k) {
            windowSum += array[j]
        }

        maxSum = Math.max(maxSum, windowSum)
    }

    return maxSum
}

val result3 = maximumSumSubarrayOfSizeKResult(listOf(2, 1, 5, 1, 3, 2), 3)
assert(result3 == 9)

val result4 = maximumSumSubarrayOfSizeKResult(listOf(2, 3, 4, 1, 5), 2)
assert(result4 == 7)
