#!/usr/bin/env kotlin

// Given two strings containing backspaces (identified by the character ‘#’),
// check if the two strings are equal.

// S: O(1)
// T: O(n)
fun compare(s1: String, s2: String): Boolean {
    var s1Pointer = s1.lastIndex
    var s2Pointer = s2.lastIndex

    while (s1Pointer >= 0 || s2Pointer >= 0) {
        s1Pointer = backspace(s1, s1Pointer)
        s2Pointer = backspace(s2, s2Pointer)

        if (0 > s1Pointer || 0 > s2Pointer) {
            return false
        }

        if (s1[s1Pointer] != s2[s2Pointer]) {
            return false
        }

        s1Pointer--
        s2Pointer--
    }

    return true
}

fun backspace(str: String, pointer: Int): Int {
    var innerPointer = pointer
    var backspaceCount = 0
    while(true) {
        if (str[innerPointer] == '#') {
            backspaceCount++
        } else {
            break
        }

        innerPointer--
    }

    return innerPointer - backspaceCount
}

println(compare("xy#z", "xzz#"))
println(!compare("xy#z", "xyz#"))
println(compare("xp#", "xyz##"))
println(compare("xywrrmp", "xywrrmu#p"))
