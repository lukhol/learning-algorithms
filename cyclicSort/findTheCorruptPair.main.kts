#!/usr/bin/envkotlin kotlin

// We are given an unsorted array containing ‘n’ numbers taken from the range 1 to `n`.
// The array originally contained all the numbers from 1 to `n`, but due to a data error,
// one of the numbers got duplicated which also resulted in one number going missing.
// Find both these numbers.
fun main() {
    fun swap(arr: MutableList<Int>, i: Int, j: Int) {
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }

    // S: O(1)
    // T: O(n)
    fun findTheCorruptPair(arr: MutableList<Int>): List<Int> {
        var idx = 0
        while (arr.size > idx) {
            val nextIdx = arr[idx] - 1
            val nextValue = arr[nextIdx]

            if (arr[idx] != nextValue) {
                swap(arr, idx, nextIdx)
            } else {
                idx++
            }
        }

        for (i in arr.indices) {
            // Since only one number got corrupted, the number at the wrong index is
            // the duplicated number and the index itself represents the missing number.
            if (i + 1 != arr[i]) {
                return listOf(arr[i], i + 1)
            }
        }

        return emptyList()
    }


    println(findTheCorruptPair(arrayListOf(3, 1, 2, 5, 2)) == listOf(2, 4))
    println(findTheCorruptPair(arrayListOf(3, 1, 2, 3, 6, 4)) == listOf(3, 5))
}


main()
