#!/usr/bin/env kotlin

// Given an array with positive numbers and a target number, find all of
// its contiguous subarrays whose product is less than the target number.

// T: O(n^2)
// S: O(n)
fun findSubArrays(arr: List<Int>, target: Int): List<List<Int>> {
    val result: MutableList<List<Int>> = arrayListOf()
    var windowSize = 1

    while (windowSize < arr.size) {
        var product = 1
        var startIdx = 0

        for (endIdx in arr.indices) {
            product *= arr[endIdx]
            // end = 0, start = 0

            if (endIdx - startIdx == windowSize - 1) {
                if (startIdx > 0) {
                    product /= arr[startIdx - 1]
                }
                startIdx++

                if (product < target) {
                    val subResult = arrayListOf<Int>()
                    for (idx in (startIdx - 1) .. endIdx) {
                        subResult.add(arr[idx])
                    }
                    result.add(subResult)
                }
            }
        }

        windowSize++
    }

    return result
}

val result = findSubArrays(arrayListOf(2, 5, 3, 10), 30)
println(result == listOf(
    listOf(2), listOf(5), listOf(3), listOf(10), listOf(2, 5), listOf(5, 3)
))

val result2 = findSubArrays(arrayListOf(8, 2, 6, 5), 50)
println(result2 == arrayListOf(
    listOf(8), listOf(2), listOf(6), listOf(5), listOf(8, 2), listOf(2, 6), listOf(6, 5)
))
