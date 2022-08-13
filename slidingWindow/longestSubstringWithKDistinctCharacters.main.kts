#!/usr/bin/env kotlin

// Given a string, find the length of the longest substring
// in it with no more than K distinct characters.
// S: O(k)
// T: O(n)
fun longestSubstringWithKDistinctCharacters(str: String, k: Int): Int {
    val letters = hashMapOf<Char, Int>()
    var longest = 0
    var startIdx = 0

    for (endIdx in str.indices) {
        letters.compute(str[endIdx]) { _, value ->
            if (value == null) 1 else value + 1
        }

        while(letters.size > k) {
            val letter = str[startIdx]
            letters.compute(letter) { _, value ->
                if (value == null) 0 else value - 1
            }
            letters.remove(letter, 0)
            startIdx++
        }

        longest = Math.max(longest, endIdx - startIdx + 1)
    }

    return longest
}

val result = longestSubstringWithKDistinctCharacters("araaci", 2)
assert(result == 4)

val result2 = longestSubstringWithKDistinctCharacters("araaci", 1)
assert(result2 == 2)

val result3 = longestSubstringWithKDistinctCharacters("cbbebi", 3)
assert(result3 == 5)
