#!/usr/bin/envkotlin kotlin

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/submissions/

// Given an array of numbers sorted in an ascending order, find the ceiling of a given number 'key'. 
// The ceiling of the ‘key’ will be the smallest element in the given array greater than or equal to the 'key'.
// Write a function to return the index of the ceiling of the 'key'. If there isn’t any ceiling return -1.

// S: O(1)
// T: O(logn)
class Solution {

    // 0, 1, 2, 3, 4,  5
    // 2, 4, 6, 8, 10, 12
    // startIdx = 0, endIdx = 5, middleIdx = 2
    // startIdx = 2, endIdx = 5, middleIdx = 3
    // startIdx = 2, endIdx = 3
    // target = 7
    // ideally i should have startIdx, middleIdx and endIdx and then pick first bigger letter than startIdx
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        var startIdx = 0
        var endIdx = letters.lastIndex
        while (endIdx >= startIdx) {
            val middleIdx = (endIdx + startIdx) / 2
            if (target < letters[middleIdx]) {
                endIdx = middleIdx
            } else {
                startIdx = middleIdx
            }

            if (Math.abs(startIdx - endIdx) == 1) {
                if (letters[startIdx] > target) return letters[startIdx]
                if (letters[endIdx] > target) return letters[endIdx]
                val biggerThanTargetIdx = endIdx + 1
                return letters[if (biggerThanTargetIdx >= letters.size) 0 else biggerThanTargetIdx]
            }
        }

        throw IllegalStateException("Should not be reached")
    }
}

fun main() {
    val expected = 'n'
    val actual = Solution().nextGreatestLetter(charArrayOf('e','e','e','e','e','e','n','n','n','n'), 'e')
    println(expected == actual)
}

