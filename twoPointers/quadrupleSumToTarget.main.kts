#!/usr/bin/env kotlin

// Given an array of unsorted numbers and a target number, find all unique
// quadruplets in it, whose sum is equal to the target number.

// S: O(n)
// T: O(n log n) + O(n^3) = O(n^3)
fun searchQuarduplets(arr: MutableList<Int>, target: Int): List<List<Int>> {
    arr.sort()
    val result = arrayListOf<List<Int>>()

    fun searchPairs(firstIdx: Int, secondIdx: Int) {
        var leftIdx = secondIdx + 1
        var rightIdx = arr.lastIndex

        while (rightIdx > leftIdx) {
            val sum = arr[firstIdx] + arr[secondIdx] + arr[leftIdx] + arr[rightIdx]
            if (sum == target) {
                result.add(listOf(arr[firstIdx], arr[secondIdx], arr[leftIdx], arr[rightIdx]))
                leftIdx++
                rightIdx--
                while (rightIdx > leftIdx && arr[leftIdx] == arr[leftIdx + 1]) {
                    leftIdx++
                }
                while (rightIdx > leftIdx && arr[rightIdx] == arr[rightIdx - 1]) {
                    rightIdx--
                }
            } else if (sum > target) {
                rightIdx--
            } else {
                leftIdx++
            }
        }
    }

    for(firstIdx in 0 until arr.size - 3) {
        val first = arr[firstIdx]
        if (firstIdx > 0 && first == arr[firstIdx - 1]) {
            continue
        }

        for (secondIdx in firstIdx + 1 until arr.size - 2) {
            val second = arr[secondIdx]
            if (secondIdx > 0 && second == arr[secondIdx - 1]) {
                continue
            }

            searchPairs(firstIdx, secondIdx)
        }
    }

    return result
}

val result = searchQuarduplets(arrayListOf(4, 1, 2, -1, 1, -3), 1)
println(result == arrayListOf(arrayListOf(-3, -1, 1, 4), arrayListOf(-3, 1, 1, 2)))

val result2 = searchQuarduplets(arrayListOf(2, 0, -1, 1, -2, 2), 2)
println(result2 == arrayListOf(arrayListOf(-2, 0, 2, 2), arrayListOf(-1, 0, 1, 2)))
