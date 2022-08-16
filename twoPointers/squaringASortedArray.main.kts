#!/usr/bin/envkotlin kotlin

// Given a sorted array, create a new array containing squares of all 
// the number of the input array in the sorted order.

// S: O(1)
// T: O(n)
fun squaringASortedArray(arr: List<Int>): List<Int> {
    val result = MutableList(arr.size) { 0 }
    var leftPointer = 0
    var rightPointer = arr.size - 1
    var insertIndex = arr.size - 1

    while (rightPointer >= leftPointer) {
        val left = arr[leftPointer] * arr[leftPointer]
        val right = arr[rightPointer] * arr[rightPointer]
        if (left > right) {
            result[insertIndex--] = left
            leftPointer++
        } else {
            result[insertIndex--] = right
            rightPointer--
        }
    }

    return result
}

val result = squaringASortedArray(arrayListOf(-2, -1, 0, 2, 3))
println(result == arrayListOf(0, 1, 4, 4, 9))

val result2 = squaringASortedArray(arrayListOf(-3, -1, 0, 1, 2))
println(result2 == arrayListOf(0, 1, 1, 4, 9))
