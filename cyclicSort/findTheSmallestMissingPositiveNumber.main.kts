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
    println(findTheSmallestMissingPositiveNumber(mutableListOf(3, 4, -1, 1)) == 2)
    println(findTheSmallestMissingPositiveNumber(mutableListOf(1, 2, 0)) == 3)
    println(findTheSmallestMissingPositiveNumber(mutableListOf(1, 2, 3)) == 4)
    println(findTheSmallestMissingPositiveNumber(mutableListOf(1, 2, 4)) == 3)
    println(findTheSmallestMissingPositiveNumber(mutableListOf(0, 2, 4)) == 1)
    println(findTheSmallestMissingPositiveNumber(mutableListOf(1, 2, 4, 5, 6, 7, 8, 9)) == 3)
    println(findTheSmallestMissingPositiveNumber(mutableListOf(1, 2, 4, 5, 6, 7, 8, 9, 10)) == 3)
}

main()
