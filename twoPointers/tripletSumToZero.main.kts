#!/usr/bin/envkotlin kotlin

// Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

// S: O(n)
// T: O(nlongn + n^2) = O(n^2)
fun tripletSumToZero(list: List<Int>): List<List<Int>> {
    val sorted = list.sorted()
    val result = LinkedHashSet<List<Int>>()

    for (idx in 0 .. sorted.size - 3) {
        val current = sorted[idx]
        var leftIdx = idx + 1
        var rightIdx = sorted.lastIndex
        while(rightIdx > leftIdx) {
            val left = sorted[leftIdx]
            val right = sorted[rightIdx]
            val allSum = current + left + right
            if (allSum == 0) {
                result.add(listOf(current, left, right))
                // Below may be incorrect - require more test cases
                leftIdx++
                rightIdx--
            } else if (allSum > 0) {
                rightIdx--
            } else {
                leftIdx++
            }
        }
    }

    return result.toList()
}


val result = tripletSumToZero(listOf(-3, 0, 1, 2, -1, 1, -2))
println(result == listOf(listOf(-3, 1, 2), listOf(-2, 0, 2), listOf(-2, 1, 1), listOf(-1, 0, 1)))

val result2 = tripletSumToZero(listOf(-5, 2, -1, -2, 3))
println(result2 == listOf(listOf(-5, 2, 3), listOf(-2, -1, 3)))

val result3 = tripletSumToZero(listOf(-1, -1, -1, 1, 1, 0))
println(result3 == listOf(listOf(-1, 1, 0)))


//      c       l        r
// -3, -2, -1 , 0, 1, 1, 2
//      c          l     r

fun tripletSumToZero_withoutSet(list: List<Int>): List<List<Int>> {
    val sorted = list.sorted()
    val result = arrayListOf<List<Int>>()
    for (idx in 0 .. sorted.size - 3) {
        if (idx > 0 && sorted[idx] == sorted[idx - 1]) {
            continue // Skip duplicated triplets
        }

        val current = sorted[idx]
        var leftIdx = idx + 1
        var rightIdx = sorted.lastIndex
        while(rightIdx > leftIdx) {
            val left = sorted[leftIdx]
            val right = sorted[rightIdx]
            val allSum = current + left + right
            if (allSum == 0) {
                result.add(listOf(current, left, right))
                // Below may be incorrect - require more test cases
                leftIdx++
                rightIdx--

                // Skip the same elements to avoid duplicated triplets
                while (rightIdx > leftIdx && sorted[leftIdx] == sorted[leftIdx - 1]) {
                    leftIdx++
                }
                while (rightIdx > leftIdx && sorted[rightIdx] == sorted[rightIdx + 1]) {
                    rightIdx--
                }

            } else if (allSum > 0) {
                rightIdx--
            } else {
                leftIdx++
            }
        }
    }

    return result.toList()
}