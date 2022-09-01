#!/usr/bin/env kotlin

// Given an array of intervals representing ‘N’ appointments, 
// find out if a person can attend all the appointments.

data class Interval(val start: Int, val end: Int)

// S: O(1)
// T: O(n logn) - because of sorting 
fun canAttendAllApointments(intervals: List<Interval>): Boolean {
    if (intervals.size <= 1) return true  
    val sortedIntervals = intervals.sortedBy { it.start }

    // Acts as a previous  
    var start = sortedIntervals.first().start
    var end = sortedIntervals.first().end

    // Starf from 1 because we want to have current and previous
    for (idx in 1 .. sortedIntervals.lastIndex) {
        val current = sortedIntervals[idx]
        if (current.start > end) {
            // When current interval starts after prev, then make prev current by setting start and end
            start = current.start
            end = current.end
        } else {
            // Current overlaps with previous
            return false
        }
    }

  return true
}

// Alternatively shorter version is just to have inlined if statement.
// if (sortedIntervals[idx].start < sortedIntervals[idx - 1].end)

println(!canAttendAllApointments(listOf(Interval(1, 4), Interval(2, 5), Interval(7,9))))
println(canAttendAllApointments(listOf(Interval(6, 7), Interval(2, 4), Interval(8, 12))))
println(!canAttendAllApointments(listOf(Interval(4, 5), Interval(2, 3), Interval(3, 6))))
