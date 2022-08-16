#!/usr/bin/envkotlin kotlin

// Given an array of sorted numbers, remove all duplicates from it.
// You should not use any extra space; after removing the duplicates
// in-place return the new length of the array.

// S: O(1)
// T: O(n)
fun removeDuplicates(arr: MutableList<Int>): Int {
    var nextNonDuplicate = 1
    for (next in 1 .. arr.lastIndex) {
        if (arr[nextNonDuplicate - 1] != arr[next]) {
            arr[nextNonDuplicate] = arr[next]
            nextNonDuplicate++
        }
    }

    return nextNonDuplicate
}

val result = arrayListOf(2, 3, 3, 3, 6, 9, 9)
println(removeDuplicates(result))
println(result)

val result2 = arrayListOf(2, 2, 2, 11)
println(removeDuplicates(result2))
println(result2)
