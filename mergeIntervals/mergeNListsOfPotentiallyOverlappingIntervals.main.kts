#!/usr/bin/env kotlin
// This is my question - add more tests cases 

// Given n lists of intervals, merge all intervals in a way that final list will not contain any overlapping intervals.
// Each list consists of disjoint intervals sorted by their start time.
// 
// Exmaple:
// Input: [ [[1, 2], [4, 5], [8, 10]], [[2,5], [6,7]] ]
// Output [ [1, 5], [6,7], [8, 10] ]
// 
// Input: [ [[1, 2], [4, 5], [8, 10]], [[2,5], [6,7]], [[1, 9]] ]
// Output [ [1, 10] ]

fun mergeNListsOfPotentiallyOverlappingIntervals(intervals: List<List<Interval>>): List<Interval> {
  // TODO
  return listOf()
}

val input = listOf(listOf(Interval(1, 2), Interval(4, 5), Interval(8, 10)), listOf(Interval(2, 5), Interval(6, 7)))
val output = listOf(Interval(1, 5), Interval(6, 7), Interval(8, 10))
println(output == mergeNListsOfPotentiallyOverlappingIntervals(input))

val input2 = listOf(listOf(Interval(1, 2), Interval(4, 5), Interval(8, 10)), listOf(Interval(2, 5), Interval(6, 7)), listOf(Interval(1, 9)))
val output2 = listOf(Interval(1, 10))
println(output2 == mergeNListsOfPotentiallyOverlappingIntervals(input2))
