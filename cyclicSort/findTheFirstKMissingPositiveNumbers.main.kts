#!/usr/bin/envkotlin kotlin

// Given an unsorted array containing numbers and a number ‘k’,
// find the first ‘k’ missing positive numbers in the array.
fun main() {
    fun swap(arr: MutableList<Int>, i: Int, j: Int) {
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }

    // S: O(1)
    // T: O(n)
    fun findTheFirstKMissingPositiveNumbers(arr: MutableList<Int>, k: Int): List<Int> {
        val result = arrayListOf<Int>()
        val biggerThanIndex = hashSetOf<Int>()
        var idx = 0
        while (arr.size > idx) {
            val isCurrentNumberInBounds = arr[idx] > 0 && arr[idx] <= arr.size
            if (isCurrentNumberInBounds && arr[idx] != arr[arr[idx] - 1]) {
                swap(arr, idx, arr[idx] - 1)
            } else {
                if (arr[idx] > arr.size) {
                    biggerThanIndex.add(arr[idx])
                }
                idx++
            }
        }

        for (i in arr.indices) {
            val indexFromOneInsteadOfZero = i + 1
            if (indexFromOneInsteadOfZero != arr[i]) {
                result.add(indexFromOneInsteadOfZero)
                if (result.size == k) return result
            }
        }

        for (i in arr.size + 1 .. Int.MAX_VALUE) {
            if (result.size == k) return result

            if (!biggerThanIndex.contains(i)) {
                result.add(i)
            }
        }
        return result
    }


    println(findTheFirstKMissingPositiveNumbers(arrayListOf(3, -1, 4, 5, 5), 3) == listOf(1, 2, 6))
    println(findTheFirstKMissingPositiveNumbers(arrayListOf(2, 3, 4), 3) == listOf(1, 5, 6))
    println(findTheFirstKMissingPositiveNumbers(arrayListOf(-2, -3, 4), 2) == listOf(1, 2))
    println(findTheFirstKMissingPositiveNumbers(arrayListOf(2, 3, 4), 3) == listOf(1, 5, 6))
    println(findTheFirstKMissingPositiveNumbers(arrayListOf(-2, -3, 4), 2) == listOf(1, 2))
    println(findTheFirstKMissingPositiveNumbers(arrayListOf(2, 3, 4), 3) == listOf(1, 5, 6))
    println(findTheFirstKMissingPositiveNumbers(arrayListOf(-2, -3, 4), 2) == listOf(1, 2))

}

main()
