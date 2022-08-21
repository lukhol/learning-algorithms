#!/usr/bin/env kotlin

// Given an array of unsorted numbers and a target number, find all unique
// quadruplets in it, whose sum is equal to the target number.

fun searchQuarduplets(arr: List<Int>, target: Int): List<List<Int>> {
    val result = arrayListOf<List<Int>>()
    // TODO
    return result
}

val result = searchQuarduplets(listOf(4, 1, 2, -1, 1, -3), 1)
println(result == arrayListOf(arrayListOf(-3, -1, 1, 4), arrayListOf(-3, 1, 1, 2)))

val result2 = searchQuarduplets(listOf(2, 0, -1, 1, -2, 2), 2)
println(result2 == arrayListOf(arrayListOf(-2, 0, 2, 2), arrayListOf(-1, 0, 1, 2)))
