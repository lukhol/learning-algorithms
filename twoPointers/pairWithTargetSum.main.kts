#!/usr/bin/envkotlin kotlin

// Given an array of sorted numbers and a target sum, find a pair in
// the array whose sum is equal to the given target.
// Write a function to return the indices of the two numbers (i.e. the pair)
// such that they add up to the given target

// T: O(n)
// S: O(1)
fun search(arr: List<Int>, targetSum: Int): List<Int> {
    var leftPointer = 0
    var rightPointer = arr.size - 1

    while (leftPointer <= rightPointer) {
        val left = arr[leftPointer]
        val right = arr[rightPointer]
        val currentSum = left + right
        if (currentSum == targetSum) {
            return listOf(leftPointer, rightPointer)
        } else if (currentSum > targetSum) {
            rightPointer--
        } else {
            leftPointer++
        }
    }

    return arrayListOf(-1, -1)
}

println(search(arrayListOf(1, 2, 3, 4, 6), 6))
println(search(arrayListOf(2, 5, 9, 11), 11))
println(search(arrayListOf(2, 5, 9, 11), 120))
