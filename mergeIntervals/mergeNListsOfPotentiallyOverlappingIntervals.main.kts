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

data class Interval(val start: Int, val end: Int)
class MutablePair<T1, T2>(var first: T1, var second: T2)

fun mergeNListsOfPotentiallyOverlappingIntervals(intervals: List<List<Interval>>): List<Interval> {
    if (intervals.isEmpty()) return emptyList()
    val results = arrayListOf<Interval>()

    val withoutEmptyLists = intervals.filter { it.isNotEmpty() }
    val intervalsAndIndexes = withoutEmptyLists.map { MutablePair(it, 0 )}.toMutableList()

    fun hasAnyNotProcessedInterval() = intervalsAndIndexes.any { it.first.size > it.second }

    fun sortInnerListsByStartTimeAndGetFirst(): MutablePair<List<Interval>, Int> {
        intervalsAndIndexes.sortBy {
            if (it.first.size == it.second) {
                Int.MAX_VALUE
            } else {
                it.first[it.second].start
            }
        }
        return intervalsAndIndexes.first()
    }

    var smallest = sortInnerListsByStartTimeAndGetFirst()
    var earliestStartInterval = smallest.first[smallest.second]

    var start = earliestStartInterval.start
    var end = earliestStartInterval.end

    while (hasAnyNotProcessedInterval()) {
        var anyOverlapped = false
        var allOverlapped: Boolean? = null
        for (idx in intervalsAndIndexes.indices) {
            // This list has been fully processed - can be skipped
            val currentPair = intervalsAndIndexes[idx]
            if (currentPair.first.size == currentPair.second) continue

            val current = currentPair.first[currentPair.second]
            if (end >= current.start) {
                end = Math.max(end, current.end)
                start = Math.min(start, current.start)
                currentPair.second += 1

                allOverlapped = allOverlapped ?: true
                anyOverlapped = true
            } else {
                allOverlapped = false
            }
        }

        if (!anyOverlapped) {
            results.add(Interval(start, end))

            smallest = sortInnerListsByStartTimeAndGetFirst()
            earliestStartInterval = smallest.first[smallest.second]
            start = earliestStartInterval.start
            end = earliestStartInterval.end
        }

    }

    results.add(Interval(start, end))

    return results
}

val input = listOf(listOf(Interval(1, 2), Interval(4, 5), Interval(8, 10)), listOf(Interval(2, 5), Interval(6, 7)))
val output = listOf(Interval(1, 5), Interval(6, 7), Interval(8, 10))
println(output == mergeNListsOfPotentiallyOverlappingIntervals(input))

val input2 = listOf(listOf(Interval(1, 2), Interval(4, 5), Interval(8, 10)), listOf(Interval(2, 5), Interval(6, 7)), listOf(Interval(1, 9)))
val output2 = listOf(Interval(1, 10))
println(output2 == mergeNListsOfPotentiallyOverlappingIntervals(input2))
