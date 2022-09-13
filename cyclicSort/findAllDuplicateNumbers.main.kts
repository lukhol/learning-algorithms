#!/usr/bin/envkotlin kotlin

// We are given an unsorted array containing `n+1` numbers taken from the range 1 to `n`.
// The array has only one duplicate, but it can be repeated multiple times.
// Find that duplicate number without using any extra space. You are, however,
// allowed to modify the input array.
fun main() {
    fun swap(arr: MutableList<Int>, i: Int, j: Int) {
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }

    fun findNumbers2(arr: MutableList<Int>): List<Int> {
        var idx = 0
        while (idx < arr.size) {
            if (arr[idx] != arr[arr[idx] - 1]) {
                swap(arr, idx, arr[idx] - 1)
            } else {
                idx++
            }
        }

        val duplicatedNumbers = arrayListOf<Int>()
        for (i in arr.indices) {
            if (arr[i] != i + 1) {
                duplicatedNumbers.add(arr[i])
            }
        }

        return duplicatedNumbers
    }

    fun findNumbers(arr: MutableList<Int>): List<Int> {
        val duplicatedNumbers = arrayListOf<Int>()
        var idx = 0
        while (arr.size > idx) {
            val nextIdx = arr[idx] - 1
            val nextValue = arr[nextIdx]

            if (idx + 1 != nextValue) {
                if (nextValue != arr[idx]) {
                    swap(arr, idx, nextIdx)
                } else {
                    duplicatedNumbers.add(arr[idx])
                    idx++
                }
            } else {
                idx++
            }
        }

        return duplicatedNumbers
    }


    println(findNumbers(arrayListOf(3, 4, 4, 5, 5)) == listOf(5, 4))
    println(findNumbers(arrayListOf(5, 4, 7, 2, 3, 5, 3)) == listOf(3, 5))

    println(findNumbers2(arrayListOf(3, 4, 4, 5, 5)) == listOf(5, 4))
    println(findNumbers2(arrayListOf(5, 4, 7, 2, 3, 5, 3)) == listOf(3, 5))
}

main()
