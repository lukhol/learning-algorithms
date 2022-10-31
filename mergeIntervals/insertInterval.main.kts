#!/usr/bin/env kotlin
// https://leetcode.com/problems/insert-interval/description/

// Given a list of non-overlapping intervals sorted by their start time,
// insert a given interval at the correct position and merge all necessary
// intervals to produce a list that has only mutually exclusive intervals.

class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): List<List<Int>> {
        if (intervals.isEmpty()) return listOf(newInterval.toList())
        val result = arrayListOf<List<Int>>()
        var globalIdx = 0

        // Add all intervals that ends before newInterval starts
        while (intervals.size > globalIdx && intervals[globalIdx][1] < newInterval[0]) {
            result.add(intervals[globalIdx++].toList())
        }

        val start = Math.min(if (globalIdx == intervals.size) newInterval[0] else intervals[globalIdx][0], newInterval[0])
        // End will be expanded in while loop later - for now we don't know if newInterval overlaps with the next one
        var end = newInterval[1]

        // Expand current interval
        while (intervals.size > globalIdx && intervals[globalIdx][0] <= end) {
            end = Math.max(end, intervals[globalIdx++][1])
        }

        // Add expanded interval to the result list
        result.add(listOf(start, end))

        // Add rest of the intervals
        for(idx in globalIdx .. intervals.lastIndex) {
            result.add(intervals[idx].toList())
        }

        return result
    }
}


fun main() {
    println(
        Solution().insert(
            arrayOf(intArrayOf(1, 3), intArrayOf(5, 7), intArrayOf(8, 12)),
            intArrayOf(4, 6)
        ) == listOf(listOf(1, 3), listOf(4, 7), listOf(8, 12))
    )

    println(
        Solution().insert(
            arrayOf(intArrayOf(1, 3), intArrayOf(5, 7), intArrayOf(8, 12)),
            intArrayOf(4, 10)
        ) == listOf(
            listOf(1, 3), listOf(4, 12)
        )
    )
    println(
        Solution().insert(
            arrayOf(intArrayOf(2, 3), intArrayOf(5, 7)),
            intArrayOf(1, 4)
        ).toList() == listOf(
            listOf(1, 4), listOf(5, 7)
        )
    )
}

main()
    
