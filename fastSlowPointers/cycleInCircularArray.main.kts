#!/usr/bin/env kotlin

import kotlin.math.abs

// We are given an array containing positive and negative numbers. Suppose the array contains
// a number ‘M’ at a particular index. Now, if ‘M’ is positive we will move forward ‘M’
// indices and if ‘M’ is negative move backwards ‘M’ indices. You should assume that the
// array is circular which means two things:
//
// If, while moving forward, we reach the end of the array, we will jump to the first
// element to continue the movement.
// If, while moving backward, we reach the beginning of the array, we will jump to the
// last element to continue the movement.
// Write a method to determine if the array has a cycle. The cycle should have more
// than one element and should follow one direction which means the cycle should not
// contain both forward and backward movements.

// 1. Start with index 0 and search in one direction (+ or -) with two pointers
// 2. When we reach 0 or negative number then there is no more movement - there is no cycle
// 3. When two pointers meet and this number is bigger than 0, then it's a cycle
fun loopExists(arr: List<Int>): Boolean {

    fun findNextIndex(idx: Int, moveBy: Int): Int {
        var startingIndex = idx
        var movesLeft = abs(moveBy)
        while(movesLeft-- > 0) {
            if (moveBy > 0) {
                startingIndex++
                if (startingIndex == arr.size) startingIndex = 0
            } else {
                startingIndex--
                if (startingIndex == -1) startingIndex = arr.lastIndex
            }
        }

        if (arr[idx] > 0 && arr[startingIndex] < 0) return -1
        if (arr[idx] < 0 && arr[startingIndex] > 0) return -1

        return startingIndex
    }

    for (startIndex in arr.indices) {
        var slowPointer = startIndex
        var fastPointer = startIndex
        while(true) {
            if (arr[slowPointer] == 0 || arr[fastPointer] == 0) return false

            slowPointer = findNextIndex(slowPointer, arr[slowPointer])
            if (slowPointer == -1) break
            val fastPointerSlow = findNextIndex(fastPointer, arr[fastPointer])
            if (fastPointerSlow == -1) break
            fastPointer = findNextIndex(fastPointerSlow, arr[fastPointerSlow])
            if (fastPointer == -1) break

            if (slowPointer == fastPointerSlow) {
                return true
            }

        }
    }

    return false
}

println(loopExists(listOf(1, 2, -1, 2, 2)))
println(loopExists(listOf(2, 2, -1, 2)))
println(!loopExists(listOf(2, 1, -1, -2)))
