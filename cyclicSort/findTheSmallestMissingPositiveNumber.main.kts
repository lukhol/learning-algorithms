#!/usr/bin/envkotlin kotlin

// Given an unsorted array containing numbers, find the smallest missing positive number in it.
fun main() {
    fun swap(arr: MutableList<Int>, i: Int, j: Int) {
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }

    // I need to put all numbers on corresponding index.
    // If number is bigger than size or smaller than 1 then ...
    fun findTheSmallestMissingPositiveNumber(arr: MutableList<Int>): Int {
        var idx = 0
        while (arr.size > idx) {
            val isCurrentNumberOnItsIndex = arr[idx] == idx + 1
            val isCurrentNumberInBounds = arr[idx] > 0 && arr[idx] <= arr.size
            if (!isCurrentNumberOnItsIndex && isCurrentNumberInBounds) {
                swap(arr, idx, arr[idx] - 1)
            } else {
                idx++
            }
        }

        for (i in arr.indices) {
            val indexFromOneInsteadOfZero = i + 1
            if (indexFromOneInsteadOfZero != arr[i]) {
                return indexFromOneInsteadOfZero
            }
        }

        return arr.size + 1
    }

    println(findTheSmallestMissingPositiveNumber(arrayListOf(-3, 1, 5, 4, 2)) == 3)
    println(findTheSmallestMissingPositiveNumber(arrayListOf(3, -2, 0, 1, 2)) == 4)
    println(findTheSmallestMissingPositiveNumber(arrayListOf(3, 2, 5, 1)) == 4)
    println(findTheSmallestMissingPositiveNumber(mutableListOf(3, 4, -1, 1)) == 2)
    println(findTheSmallestMissingPositiveNumber(mutableListOf(1, 2, 0)) == 3)
    println(findTheSmallestMissingPositiveNumber(mutableListOf(1, 2, 3)) == 4)
    println(findTheSmallestMissingPositiveNumber(mutableListOf(1, 2, 4)) == 3)
    println(findTheSmallestMissingPositiveNumber(mutableListOf(0, 2, 4)) == 1)
    println(findTheSmallestMissingPositiveNumber(mutableListOf(1, 2, 4, 5, 6, 7, 8, 9)) == 3)
    println(findTheSmallestMissingPositiveNumber(mutableListOf(1, 2, 4, 5, 6, 7, 8, 9, 10)) == 3)
}

main()
