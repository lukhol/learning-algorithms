#!/usr/bin/env kotlin

// Given a string, find the length of the longest
// substring which has no repeating characters.

// S: O(k) where k is length of longest substring
// T: O(n)
fun noRepeatSubstring(str: String): Int {
    val used = hashSetOf<Char>()
    var maxLength = 0

    for (endIdx in str.indices) {
        val letter = str[endIdx]
        if (!used.add(letter)) {
            used.clear()
            used.add(letter)
        }

        maxLength = Math.max(maxLength, used.size)
    }

    return maxLength
}

val result = noRepeatSubstring("aabccbb")
assert(result == 3)

val result2 = noRepeatSubstring("abbbb")
assert(result2 == 2)

val result3 = noRepeatSubstring("abccde")
assert(result3 == 3)
