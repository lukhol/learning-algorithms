#!/usr/bin/envkotlin kotlin
// https://leetcode.com/problems/find-k-closest-elements/
// Given an array of numbers sorted in ascending order, find the element in the array that has the minimum difference with the given 'key'.

import java.util.LinkedList

// S: O(1)
// T: O(logn) or O(k)?
class Solution {
    fun findClosestElements_uglyLongFirstApproach(arr: IntArray, k: Int, x: Int): List<Int> {
        fun findTwoPointersCenter(): Int {
            var startIdx = 0
            var endIdx = arr.lastIndex
            var middleIdx = 0
            
            while (endIdx >= startIdx) {
                middleIdx = (endIdx + startIdx) / 2
                if (arr[middleIdx] == x) {
                    return middleIdx
                } else if (arr[middleIdx] < x) {
                    startIdx = middleIdx + 1
                } else {
                    endIdx = middleIdx - 1
                }
            }
                        
            return middleIdx
        }
        
        fun findCloserIdx(leftIdx: Int, rightIdx: Int): Int {
            if (leftIdx == -1 || leftIdx == arr.size) return rightIdx
            if (rightIdx == arr.size || rightIdx == -1) return leftIdx
            val a = arr[leftIdx]
            val b = arr[rightIdx]
            return if (
                Math.abs(a - x) < Math.abs(b - x) ||
                (a < b && Math.abs(a - x) == Math.abs(b - x))
            ) leftIdx else rightIdx
        }
        
        var leftIdx = findTwoPointersCenter()

        if (leftIdx == -1) {
            return arr.copyOfRange(0, k).toList()
        }
        val result = LinkedList<Int>()
       
        if (k == 1) {
            var onlyOneIdx = findCloserIdx(leftIdx - 1, leftIdx)
            onlyOneIdx = findCloserIdx(leftIdx + 1, onlyOneIdx)
            result.add(arr[onlyOneIdx])
            return result
        }
        
        var rightIdx = findCloserIdx(leftIdx - 1, leftIdx + 1)
        if (leftIdx > rightIdx) {
            // swap left and right when right is less than right - pointers have to be in proper order
            val tmp = leftIdx
            leftIdx = rightIdx
            rightIdx = tmp
        }
    
        result.add(arr[leftIdx]);
        result.add(arr[rightIdx]);
        
        // Two pointers logic
        while (result.size != k) {
            val nextCloserIdx = findCloserIdx(leftIdx - 1, rightIdx + 1)
            if (nextCloserIdx > rightIdx) {
                rightIdx = nextCloserIdx
                result.add(arr[nextCloserIdx])
            } else if (nextCloserIdx < leftIdx) {
                leftIdx = nextCloserIdx
                result.addFirst(arr[nextCloserIdx])
            }
        }
        
        return result
    }
}

fun main() {
  	println(Solution().findClosestElements(intArrayOf(1, 3), 1, 2) == listOf(1)) 
  	println(Solution().findClosestElements(intArrayOf(1,2,3,4,5), 4, 3) == listOf(1, 2, 3, 4)) 
    println(Solution().findClosestElements(intArrayOf(1,2,3,4,5), 4, -1) == listOf(1, 2, 3, 4)) 
    println(Solution().findClosestElements(intArrayOf(1,1,1,10,10,10), 1, 9) == listOf(downTo())) 
}
