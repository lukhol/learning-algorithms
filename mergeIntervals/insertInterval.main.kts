#!/usr/bin/env kotlin

// Given a list of non-overlapping intervals sorted by their start time,
// insert a given interval at the correct position and merge all necessary
// intervals to produce a list that has only mutually exclusive intervals.

data class Interval(val start: Int, val end: Int)

fun insertInterval(intervals: List<Interval>, newInterval: Interval): List<Interval> {
    if (intervals.isEmpty()) {
        return listOf(newInterval)
    }

    val mergedIntervals = arrayListOf<Interval>()

    var globalIdx = 0
    while (intervals.size > globalIdx && newInterval.start > intervals[globalIdx].end) {
        mergedIntervals.add(intervals[globalIdx])
        globalIdx++
    }

    if (globalIdx == intervals.size) return mergedIntervals

    var start = Math.min(intervals[globalIdx].start, newInterval.start)
    var end = Math.max(intervals[globalIdx].end, newInterval.end)
    for (idx in globalIdx..intervals.lastIndex) {
        val currentInterval = intervals[idx]
        if (currentInterval.start > end) {
            mergedIntervals.add(Interval(start, end))
            start = currentInterval.start
            end = currentInterval.end
        } else {
            end = Math.max(currentInterval.end, end)
        }
    }

    mergedIntervals.add(Interval(start, end))

    return mergedIntervals
}

println(
    insertInterval(
        arrayListOf(Interval(1, 3), Interval(5, 7), Interval(8, 12)),
        Interval(4, 6)
    ) == listOf(Interval(1, 3), Interval(4, 7), Interval(8, 12))
)

println(
    insertInterval(
        arrayListOf(Interval(1, 3), Interval(5, 7), Interval(8, 12)),
        Interval(4, 10)
    ) == listOf(
        Interval(1, 3), Interval(4, 12)
    )
)
println(
    insertInterval(
        arrayListOf(Interval(2, 3), Interval(5, 7)),
        Interval(1, 4)
    ) == listOf(
        Interval(1, 4), Interval(5, 7)
    )
)
