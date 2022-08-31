#!/usr/bin/env kotlin

// Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.

data class Interval(val start: Int, val end: Int)

fun mergeIntervals(intervals: List<Interval>): List<Interval> {
    if (intervals.size <= 1) return intervals
    val sorted = intervals.sortedBy { it.start }
    val merged = arrayListOf<Interval>()
    var start = sorted.first().start
    var end = sorted.first().end
    for (idx in sorted.indices) {
        val inter = sorted[idx]
        if (end < inter.start) {
            merged.add(Interval(start, end))
            start = inter.start
            end = inter.end
        } else {
            end = Math.max(end, inter.end)
        }
    }

    merged.add(Interval(start, end))

    return merged
}

println(mergeIntervals(listOf(Interval(6,7), Interval(2,4), Interval(5,9))) == listOf(Interval(2, 4), Interval(5, 9)))
println(mergeIntervals(listOf(Interval(1,4), Interval(2,6), Interval(3,5))) == listOf(Interval(1,6)))
