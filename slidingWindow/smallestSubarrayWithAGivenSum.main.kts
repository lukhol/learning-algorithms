#!/usr/bin/env kotlin

// Given an array of positive numbers and a positive number ‘S’, find the length
// of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
// Return 0, if no such subarray exists.

fun findMinSubarray(s: Int, array: List<Int>): Int {
    var currentSum = 0
    var startIdx = 0
    var minLength = Int.MAX_VALUE

    // Extend sliding window (do not move startIndex) until max is greater or equal than max
    // else shrink (move startIndex)
    for (endIdx in array.indices) {
        currentSum += array[endIdx]
        if (currentSum >= s) {
            minLength = Math.min(minLength, endIdx - startIdx + 1)
        }

        while (currentSum - array[startIdx] >= s) {
            currentSum -= array[startIdx]
            minLength = Math.min(minLength, endIdx - startIdx)
            startIdx++
        }
    }

    return if (minLength == Int.MAX_VALUE) 0 else minLength
}

val result = findMinSubarray(7, listOf(2, 1, 5, 2, 3, 2))
assert(result == 2)

val result2 = findMinSubarray(7, listOf(2, 1, 5, 2, 8))
assert(result2 == 1)

val result3 = findMinSubarray(8, listOf(3, 4, 1, 1, 6))
assert(result3 == 3)

val result4 = findMinSubarray(8, listOf(1, 1, 1, 1, 2, 2))
assert(result4 == 6)

val result5 = findMinSubarray(8, listOf(1, 1, 1, 1))
assert(result5 == 0)

fun findMinSubarrayOriginalSolution(s: Int, array: List<Int>): Int {
    var currentSum = 0
    var startIdx = 0
    var minLength = Int.MAX_VALUE

    for (endIdx in array.indices) {
        currentSum += array[endIdx]

        while (currentSum >= s) {
            minLength = Math.min(minLength, endIdx - startIdx + 1)
            currentSum -= array[startIdx]
            startIdx++
        }
    }

    return if (minLength == Int.MAX_VALUE) 0 else minLength
}
