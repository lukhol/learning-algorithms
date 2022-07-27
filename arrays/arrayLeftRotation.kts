#!/usr/bin/envkotlin kotlin
// Run me with kotlin arrayLeftRotation.kts
// https://www.hackerrank.com/challenges/array-left-rotation/problem

import java.util.*

// S: O(n)
// T: O(n)
// where n is size of arr
fun rotateLeft(d: Int, arr: Array<Int>): Array<Int> {
    val rotatedD = d % arr.size
    val newArr = Array(arr.size) { -1 }
    for (idx in arr.indices) {
        val nextIdx = (idx + rotatedD + arr.size) % arr.size
        newArr[idx] = arr[nextIdx]
    }

    return newArr
}

val result = rotateLeft(4, arrayOf(1, 2, 3, 4, 5))
println(Arrays.toString(result))

