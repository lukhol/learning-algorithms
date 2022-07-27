#!/usr/bin/envkotlin kotlin
// Run me with kotlin validateSubsequence.kts
// /questions/validate-subsequence

fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    var arrayIdx = 0
    var foundFromSequence = 0
    for (sequenceElement in sequence) {
        for (currArrayIdx in arrayIdx until array.size) {
            val arrayElement = array[currArrayIdx]
            if (arrayElement == sequenceElement) {
                foundFromSequence += 1
                arrayIdx = currArrayIdx + 1
                break
            }

            if (currArrayIdx == array.size - 1) {
                return false
            }
        }

    }

    return foundFromSequence == sequence.size
}


val result = isValidSubsequence(arrayListOf(5, 1, 22, 25, 6, -1, 8, 10), arrayListOf(1, 6, -1, 10))
println(result)

