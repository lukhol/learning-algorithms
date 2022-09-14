#!/usr/bin/envkotlin kotlin

// Given an unsorted array containing numbers and a number ‘k’, find the first ‘k’ missing positive numbers in the array.
fun main() {
    fun swap(arr: MutableList<Int>, i: Int, j: Int) {
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }

    // S: O(1)
    // T: O(n)
    fun findTheFirstKMissingPositiveNumbers(arr: MutableList<Int>, k: Int): List<Int> {
        TODO()
    }


    println(findTheFirstKMissingPositiveNumbers(arrayListOf(3, -1, 4, 5, 5), 3) == listOf(1, 2, 6))
    println(findTheFirstKMissingPositiveNumbers(arrayListOf(2, 3, 4), 3) == listOf(1, 5, 6))
    println(findTheFirstKMissingPositiveNumbers(arrayListOf(-2, -3, 4), 2) == listOf(1, 2))
}

main()
