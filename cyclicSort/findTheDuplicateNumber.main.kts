#!/usr/bin/envkotlin kotlin

// We are given an unsorted array containing `n+1` numbers taken from the range 1 to `n`.
// The array has only one duplicate but it can be repeated multiple times.
// Find that duplicate number without using any extra space. You are, however,
// allowed to modify the input array.
fun main() {
    fun swap(arr: MutableList<Int>, i: Int, j: Int) {
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }

    fun findNumber(arr: MutableList<Int>): Int {
        var idx = 0
        while (arr.size > idx) {
            val newIdx = arr[idx] - 1
            val newValue = arr[newIdx]

            if (newValue != idx + 1) {
                if (newValue != arr[idx]) {
                    swap(arr, idx, newIdx)
                } else {
                    return arr[idx]
                }
            } else {
                idx++
            }
        }

        println(arr)
        return -1
    }


    println(findNumber(arrayListOf(1, 4, 4, 3, 2)) == 4)
    println(findNumber(arrayListOf(2, 1, 3, 3, 5, 4)) == 3)
    println(findNumber(arrayListOf(2, 4, 1, 4, 4)) == 4)
}

main()
