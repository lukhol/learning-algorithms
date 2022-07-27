#!/usr/bin/envkotlin kotlin
// Run me with kotlin minMaxSum.kts
// https://www.hackerrank.com/challenges/mini-max-sum/problem

// S: O(1)
// T: O(n)
fun minMaxSum(arr: Array<Int>): Unit {
    arr.sort()
    var max: Long = 0
    var min: Long = 0
    for (i in 0 .. arr.size - 2) {
        min += arr[i]
    }

    for (i in 1 until arr.size) {
        max += arr[i]
    }

    println("$min $max")
}

minMaxSum(arrayOf(1, 2, 3, 4, 5))
