#!/usr/bin/envkotlin kotlin
// https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size

class ArrayReader(private val array: IntArray) {
  fun get(index: Int): Int {
    return if (index >= array.size) return Int.MAX_VALUE else return array[index]
  }
}

class Solution {
    // S: O(1)
    // T: O(logn)
    fun search(reader: ArrayReader, target: Int): Int {
        var startIdx = 0
        var endIdx = 1
        while (target > reader.get(endIdx)) {
            endIdx = endIdx * 2
        }
      
        while (endIdx >= startIdx) {
            val middleIdx = startIdx + (endIdx - startIdx) / 2
            if (reader.get(middleIdx) == Int.MAX_VALUE) {
                endIdx = middleIdx - 1    
            } else if (target > reader.get(middleIdx)) {
                startIdx = middleIdx + 1
            } else if (target < reader.get(middleIdx)) {
                endIdx = middleIdx - 1
            } else {
                return middleIdx
            }
        }
        
        return -1
    }
}

fun main() {
    println(Solution().search(ArrayReader(intArrayOf(-1, 0, 3, 5, 9, 12)), 9) == 4)
    println(Solution().search(ArrayReader(intArrayOf(-1,0,3,5,9,12)), 2) == -1)

}
