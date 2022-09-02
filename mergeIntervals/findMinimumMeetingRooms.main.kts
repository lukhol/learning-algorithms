// Given a list of intervals representing the start and end time of ‘N’ meetings,
// find the minimum number of rooms required to hold all the meetings.

data class Interval(val start: Int, val end: Int)

fun main() {
    // S: O(1)
    // T: O(n logn) - because of sorting  
    fun findMinimumMeetingRooms(intervals: List<Interval>): Int {
        if (intervals.isEmpty()) return 0
        if (intervals.size == 1) return 1
        val sortedIntervals = intervals.sortedBy { it.start }
        var start = sortedIntervals.first().start
        var end = sortedIntervals.first().end

        var maxMeetingsRooms = 1
        var i = 1
        while (i != sortedIntervals.size) {
            var count = 1
            val current = sortedIntervals[i]
            var bStart = current.start
            var bEnd = current.end
            
            fun overlaps() = start in bStart until bEnd || bStart in start until end
            while (overlaps()) {
                count++
                maxMeetingsRooms = Math.max(maxMeetingsRooms, count)

                val nextIndex = i + count - 1
                if (nextIndex == sortedIntervals.size) break
                start = Math.max(start, bStart)
                end = Math.min(end, bEnd)
                bStart = sortedIntervals[nextIndex].start
                bEnd = sortedIntervals[nextIndex].end
                if (!overlaps()) i++
            }

            start = current.start
            end = current.end
            i++
        }


        return maxMeetingsRooms
    }
    
    // S: O(k) - where k is minium meeting rooms required (stored in the heap)
    // T: O(n logn) - because of sorting
    fun findMinimumMeetingRoomsPriorityQueue(intervals: List<Interval>): Int {
        if (intervals.isEmpty()) return 0
        if (intervals.size == 1) return 1
        val sortedIntervals = intervals.sortedBy { it.end }

        var maxMeetingsRooms = 1
        val heap = PriorityQueue(Comparator.comparing(Interval::end))

        for (interval in sortedIntervals) {
            while(heap.isNotEmpty() && interval.start >= heap.peek().end) {
                heap.poll()
            }

            heap.add(interval)
            maxMeetingsRooms = Math.max(maxMeetingsRooms, heap.size)
        }

        return maxMeetingsRooms
    }

    println(findMinimumMeetingRooms(listOf(Interval(1, 10), Interval(2, 9), Interval(3, 8), Interval(4, 7), Interval (5, 7))) == 5)
    println(findMinimumMeetingRooms(listOf(Interval(1,4), Interval(2,5), Interval(7,9))) == 2)
    println(findMinimumMeetingRooms(listOf(Interval(6,7), Interval(2,4), Interval(8,12))) == 1)
    println(findMinimumMeetingRooms(listOf(Interval(1,4), Interval(2,3), Interval(3,6))) == 2)
    println(findMinimumMeetingRooms(listOf(Interval(4,5), Interval(2,3), Interval(2,4), Interval(3,5))) == 2)
    println(findMinimumMeetingRooms(listOf(Interval(1,10), Interval(5,9), Interval(4, 6), Interval(5, 6))) == 4)
}

main()
