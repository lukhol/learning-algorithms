#!/usr/bin/envkotlin kotlin
// Run me with kotlin arrayLeftRotation.kts
// https://www.hackerrank.com/challenges/array-left-rotation/problem

// TODO: try with S: O(1) - replace items in place 

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

// Can be also solved using brute force solution in S: O(1), T: O(nd)
fun rotateLeft_bruteForce(d: Int, arr: Array<Int>): Array<Int> {
    val count = if (d > arr.size) d % arr.size else d
    for (i in 0 until count) {
        for (idx in 1 until arr.size) {
            val tmp = arr[idx]
            arr[idx] = arr[idx - 1]
            arr[idx - 1] = tmp
        }
    }

    return arr
}
