#!/usr/bin/env kotlin

// Given an array arr of unsorted numbers and a target sum, count all triplets
// in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three
// different indices. Write a function to return the count of such triplets.

// 0. Sort the array
// 1. Iterate over the array from 0 to length - 3 inclusive using for loop
// 2. Maintain two pointers from i + to length - 1 inclusive
// 3. When sum is less than target then there are rightIdx - leftIdx solutions
//    because each value to the left of rightIdx is smaller which has to lead to smaller sum
//
// T: O(n^2)
// S: O(1)
fun searchTriplets(arr: List<Int>, target: Int): Int {
    val sorted = arr.sorted()
    var count = 0
    for (idx in 0 .. sorted.size - 3) {
        val current = sorted[idx]
        var leftIdx = idx + 1
        var rightIdx = arr.lastIndex
        while(rightIdx > leftIdx) {
            val sum = current + arr[leftIdx] + arr[rightIdx]
            if (sum < target) {
                count += rightIdx - leftIdx
                leftIdx++
            } else {
                rightIdx--
            }
        }
    }

    return count
}

val result = searchTriplets(listOf(-1, 0, 2, 3), 3)
println(result == 2)

val result2 = searchTriplets(listOf(-1, 4, 2, 1, 3), 5)
println(result2 == 4)

