#!/usr/bin/env kotlin

// Given an array containing 0s, 1s and 2s, sort the array in-place.
// You should treat numbers of the array as objects, hence, we can’t
// count 0s, 1s, and 2s to recreate the array.

// 1. Create variable `leftIdx` and set it to 0
// 2. Create variable `currentlySearchingFor` with value that we are searching for
// 3. Each time `currentlySearchingFor` is changed (or defined) increase `leftIdx
//    if `arr[leftIdx]` is a number we are currently searching for.
//    Break if we are out of bounds
// 4. Iterate with `rightIdx` and check if there is a number we need
// 5. If number on position leftIdx is equal to `currentlySearchingFor` swap them and
//    increase both pointers.
// 6. If rightIdx is equal to length of the array then increase `currentlySearchingFor`.
// 7. If leftIdx is equal to length of the array or `currentlySearchingFor` is equal to 4 then return


// S: O(1)
// T: O(3n) = O(n)
fun threeNumberSort(arr: MutableList<Int>) {
    var leftIdx = 0
    var currentlySearchingFor = 0

    while(currentlySearchingFor != 4 && arr.size != leftIdx) {
        // Skip first elements if are in proper positions
        while (leftIdx != arr.size && arr[leftIdx] == currentlySearchingFor) {
            leftIdx++
        }

        for (rightIdx in leftIdx + 1 .. arr.lastIndex) {
            if (arr[rightIdx] == currentlySearchingFor) {
                swap(arr, rightIdx, leftIdx)
                leftIdx++
            }
        }
        currentlySearchingFor++
    }
}

// Similar problem from AlgoExpert
fun threeNumberSort(array: MutableList<Int>, order: List<Int>): List<Int> {
    if (array.isEmpty()) return array
    var leftIdx = 0
    var currentlySearchingForIdx = 0

    while(currentlySearchingForIdx != 3 && array.size != leftIdx) {
        // If leftIdx points to element that we are searching for, then skip it before starting.
        while (leftIdx != array.size && array[leftIdx] == order[currentlySearchingForIdx]) {
            leftIdx++
        }

        val currentlySearchingFor = order[currentlySearchingForIdx]
        for (rightIdx in leftIdx + 1 .. array.lastIndex) {
            if (array[rightIdx] == currentlySearchingFor) {
                swap(array, rightIdx, leftIdx)
                leftIdx++
            }
        }
        currentlySearchingForIdx++
    }

    return array
}

fun <T> swap(arr: MutableList<T>, leftIdx: Int, rightIdx: Int) {
    val left = arr[leftIdx]
    arr[leftIdx] = arr[rightIdx]
    arr[rightIdx] = left
}

val first = arrayListOf(1, 0, 2, 1, 0)
threeNumberSort(first)
println(first == arrayListOf(0, 0, 1, 1, 2))

val second = arrayListOf(2, 2, 0, 1, 2, 0)
threeNumberSort(second)
println(second == arrayListOf(0, 0, 1, 2, 2, 2))

// 0,  1,  2
// 25, 10, 0
val third = arrayListOf(2, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0)
threeNumberSort(third)
println(third == arrayListOf(0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2))
