#!/usr/bin/envkotlin kotlin

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/submissions/

// Given an array of lowercase letters sorted in ascending order, find the smallest letter in the given array greater than a given 'key'.
// Assume the given array is a circular list, which means that the last letter is assumed to be connected with the first letter.
// This also means that the smallest letter in the given array is greater than the last letter of the array and is also the first letter of the array.
// Write a function to return the next letter of the given 'key'.

// S: O(1)
// T: O(logn)
class Solution {

    // target = 1
    // 0, 1, 2, 3, 4, 5, 6, 7, 8
    // 1, 1, 1, 1, 1, 2, 2, 2, 2
    // startIdx = 0, endIdx = 8, middleIdx = 4
    // startIdx = 5, endIdx = 8, middleIdx = 6
    // startIdx = 5, endIdx = 5, middleIdx = 5
    // startIdx = 5, endIdx = 5, middleIdx = 5
    // startIdx = 5, endIdx = 4
    // When target is greater than or equal to current number then we have to go right
    // Othervice we have to go left
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

