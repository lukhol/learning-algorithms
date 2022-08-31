#!/usr/bin/env kotlin

// Given a list of non-overlapping intervals sorted by their start time, 
// insert a given interval at the correct position and merge all necessary 
// intervals to produce a list that has only mutually exclusive intervals.

data class Interval(val start: Int, val end: Int)

fun insertInterval(intervals: MutableList<Interval>, newInterval: Interval): List<Interval> {
  // TODO
  return intervals
}

println(
  insertInterval(
    arrayListOf(Interval(1, 3), Interval(5, 7), Interval(8, 12)),
    Interval(4, 6)
  ) == listOf(Interval(1, 3), Interval(4, 7), Interval(8, 12)
)
println(
  insertInterval(
    arrayListOf(Interval(1, 3), Interval(5, 7), Interval(8, 12)), 
    Interval(4, 10)
  ) == listOf(Interval(1, 3), Interval(4, 12)
)
println(
  insertInterval(
    arrayListOf(Interval(2, 3), Interval(5, 7)), 
    Interval(1, 4)
  ) == listOf(Interval(1, 4), Interval(5, 7)
)
