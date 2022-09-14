#!/usr/bin/envkotlin kotlin

// Given an unsorted array containing numbers, find the smallest missing positive number in it.
fun main() {
    fun swap(arr: MutableList<Int>, i: Int, j: Int) {
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }

    // S: O(1)
    // T: O(n)
    fun findTheSmallestMissingPositiveNumber(arr: MutableList<Int>): Int {
        TODO()
    }


    println(findTheSmallestMissingPositiveNumber(arrayListOf(-3, 1, 5, 4, 2)) == 3)
    println(findTheSmallestMissingPositiveNumber(arrayListOf(3, -2, 0, 1, 2)) == 4)
    println(findTheSmallestMissingPositiveNumber(arrayListOf(3, 2, 5, 1)) == 4)
}

main()
