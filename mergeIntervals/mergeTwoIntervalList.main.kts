#!/usr/bin/env kotlin

// Given two lists of intervals, find the intersection of these two lists.
// Each list consists of disjoint intervals sorted on their start time.

// Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
// Output: [2, 3], [5, 6], [7, 7]
// Explanation: The output list contains the common intervals between the two lists.

data class Interval(val start: Int, val end: Int)

fun mergeTwoIntervalList(firstList: List<Interval>, secondList: List<Interval>): List<Interval> {
    if (firstList.isEmpty()) return secondList
    if (secondList.isEmpty()) return firstList

    val result = arrayListOf<Interval>()

    var firstIdx = 0
    var secondIdx = 0

    // as        ae
    //   bs   be
    //
    // a      a
    //           b    b
    while (firstList.size != firstIdx && secondList.size != secondIdx) {
        val aStart = firstList[firstIdx].start
        val aEnd = firstList[firstIdx].end
        val bStart = secondList[secondIdx].start
        val bEnd = secondList[secondIdx].end
        val aStartWithinB = aStart in bStart..bEnd
        val bStartWithingA = bStart in aStart .. aEnd

        if (aStartWithinB || bStartWithingA) {
            result.add(Interval(Math.max(aStart, bStart), Math.min(aEnd, bEnd)))
        }

        if (aEnd > bEnd) {
            secondIdx++
        } else {
            firstIdx++
        }
    }

    for (i in firstIdx + 1 .. firstList.lastIndex) result.add(firstList[i])
    for (i in secondIdx + 1 .. secondList.lastIndex) result.add(secondList[i])

    return result
}

println(
    mergeTwoIntervalList(
        listOf(Interval(1, 3), Interval(5, 6), Interval(7, 9)),
        listOf(Interval(2, 3), Interval(5, 7))
    ) == listOf(Interval(2, 3), Interval(5, 6), Interval( 7, 7))
)

println(
    mergeTwoIntervalList(
        listOf(Interval(1, 3), Interval(5, 7), Interval(9, 12)),
        listOf(Interval(5, 10))
    ) == listOf(Interval(5, 7), Interval(9, 10))
)
