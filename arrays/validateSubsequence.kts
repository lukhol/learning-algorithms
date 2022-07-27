#!/usr/bin/envkotlin kotlin
// Run me with kotlin validateSubsequence.kts
// /questions/validate-subsequence

// S: O(1)
// T: O(n)
fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    var idxInArray = 0
    for (item in array) {
        if (idxInArray >= sequence.size) return true
        if (sequence[idxInArray] == item) idxInArray++
    }

    return idxInArray == sequence.size
}

val result = isValidSubsequence(arrayListOf(5, 1, 22, 25, 6, -1, 8, 10), arrayListOf(1, 6, -1, 10))
println(result)

