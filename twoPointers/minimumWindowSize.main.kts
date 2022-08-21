#!/usr/bin/env kotlin

// TODO - i'm not sure about implementation. It may be incorrect

// Given an array, find the length of the smallest subarray
// in it which when sorted will sort the whole array.

// 1. Find first invalid `leftPointer` - previous element has to be bigger than current
// 2. Find first invalid `rightPointer` - previous element has to be less than current
// 3. Find smallest and biggest element in subarray defined as indexes x >= leftPointer and x <= rightPointer
// 4. Move leftPointer to left to include any number that is bigger than smallest in subarray from point 3
// 5. Move rightPointer to right to include any number that is smaller than biggest element in subarray from point 3

// S: O(1)
// T: O(n)
fun sort(arr: List<Int>): Int {
    var leftPointer = 1
    var rightPointer = arr.lastIndex - 1

    var biggest = Int.MIN_VALUE
    var smallest = Int.MAX_VALUE

    fun isArraySorted() = leftPointer == arr.lastIndex

    while (leftPointer <= arr.lastIndex && arr[leftPointer] >= arr[leftPointer - 1]) {
        leftPointer++
        if (isArraySorted()) return 0
    }

    while(rightPointer >= 0 && arr[rightPointer] <= arr[rightPointer + 1]) {
        rightPointer--
    }

    for (i in leftPointer .. rightPointer) {
        biggest = Math.max(biggest, arr[i])
        smallest = Math.min(smallest, arr[i])
    }

    while (leftPointer > 0 && arr[leftPointer - 1] > smallest) {
        leftPointer--
    }

    while (arr.lastIndex > rightPointer && arr[rightPointer + 1] < biggest) {
        rightPointer++
    }

    return rightPointer - leftPointer + 1
}

println(sort(listOf(1, 2, 5, 3, 7, 10, 9, 12)) == 5)
println(sort(listOf(1, 3, 2, 0, -1, 7, 10)) == 5)
println(sort(listOf(1, 2, 3)) == 0)
println(sort(listOf(3, 2, 1)) == 3)
println(sort(listOf(10, 11, 12, -1, 0, 3, 2)) == 7)
println(sort(listOf(10, 11, 12, -1, 0, 3, 2, 100)) == 7)

