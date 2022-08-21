#!/usr/bin/env kotlin

// Given an array containing 0s, 1s and 2s, sort the array in-place.
// You should treat numbers of the array as objects, hence, we can’t
// count 0s, 1s, and 2s to recreate the array.

// 1. Set `leftIdx` to first element that is not 0 and `rightIdx` to `leftIdx + 1`
// 2. Create variable `currentlySearchingFor` with value that we are searching for
// 3. Iterate with `rightIdx` and check if there is a number we need
// 4. If number on position leftIdx is equal to `currentlySearchingFor` swap them and
//    increase both pointers.
// 5. If rightIdx is equal to length of the array then increase `currentlySearchingFor`.
// 6. If leftIdx is equal to length of the array or `currentlySearchingFor` is equal to 4 then return


// S: O(1)
// T: O(3n) = O(n)
fun threeNumberSort(arr: MutableList<Int>) {
    var leftIdx = 0

    // Skip 0 at the beginning
    while (arr[leftIdx] == 0) {
        leftIdx++
    }

    var currentlySearchingFor = 0

    while(currentlySearchingFor != 4 && arr.size != leftIdx) {
        for (rightIdx in leftIdx + 1 .. arr.lastIndex) {
            if (arr[rightIdx] == currentlySearchingFor) {
                swap(arr, rightIdx, leftIdx)
                leftIdx++
            }
        }
        currentlySearchingFor++
    }
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
