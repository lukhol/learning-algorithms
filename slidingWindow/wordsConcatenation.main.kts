#!/usr/bin/env kotlin

// Given a string and a list of words, find all the starting indices
// of substrings in the given string that are a concatenation of all
// the given words exactly once without any overlapping of words.
// It is given that all words are of the same length.

// S: O(k) where k is number of words
// T: O(nk) where n is number of letters in string and k is number of words
fun wordsConcatenation(str: String, words: List<String>): List<Int> {
    if (words.isEmpty()) return emptyList()
    val singleWordLength = words[0].length
    if (singleWordLength > str.length) return emptyList()

    val wordCountMap = words.groupingBy { it }.eachCount().toMutableMap()
    val resultIndices = arrayListOf<Int>()
    var count = 0

    for (startIdx in 0 .. str.length - singleWordLength * words.size) {
        val endIdx = startIdx + singleWordLength - 1

        fun backtrack(leftIdx: Int, rightIdx: Int, matchedCount: Int): Boolean {
            if (matchedCount == words.size) return true
            if (rightIdx > str.lastIndex) return false

            val currentWord = str.substring(leftIdx, rightIdx + 1)
            return if (wordCountMap.containsKey(currentWord) && wordCountMap[currentWord]!! > 0) {
                wordCountMap.compute(currentWord) { _, prev -> prev!! - 1 }
                val result = backtrack(leftIdx + singleWordLength, rightIdx + singleWordLength, matchedCount + 1)
                wordCountMap.compute(currentWord) { _, prev -> prev!! + 1 }
                result
            } else {
                false
            }
        }

        if (backtrack(startIdx, endIdx, 0)) {
            resultIndices.add(startIdx)
        }
    }

    return resultIndices
}

val result = wordsConcatenation("catfoxcat", listOf("cat", "fox"))
println(result == listOf(0, 3))

val result2 = wordsConcatenation("catcatfoxfox", listOf("cat", "fox"))
println(result2 == listOf(3))

val result3 = wordsConcatenation("catcatfox", listOf("cat", "cat"))
println(result3 == listOf(0))
