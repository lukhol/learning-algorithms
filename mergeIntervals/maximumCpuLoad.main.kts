#!/usr/bin/env kotlin
// We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load
// when it is running. Our goal is to find the maximum CPU load at any time if all the
// jobs are running on the same machine.

fun main() {
    data class Job(val start: Int, val end: Int, val cpuLoad: Int)

    // S: O(k) - where k is max count of overlaping jobs
    // T: O(n logn) - because of soring
    fun maximumCpuLoad(jobs: List<Job>): Int {
        if (jobs.isEmpty()) return 0
        if (jobs.size == 1) return jobs.first().cpuLoad
        val sortedJobs = jobs.sortedBy { it.start }

        var maxCpuLoad = 0
        var currentCpuLoad = 0

        val heap = PriorityQueue(Comparator.comparingInt<Job> { it.end })
        for (job in sortedJobs) {
            while(heap.isNotEmpty() && heap.peek().end < job.start) {
                currentCpuLoad -= heap.poll().cpuLoad
            }

            heap.add(job)
            currentCpuLoad += job.cpuLoad
            maxCpuLoad = Math.max(maxCpuLoad, currentCpuLoad)
        }

        return maxCpuLoad
    }

    println(maximumCpuLoad(listOf(Job(1, 4, 3), Job(2, 5, 4), Job(7, 9, 6))) == 7)
    println(maximumCpuLoad(listOf(Job(6, 7, 10), Job(2, 4, 11), Job(8, 12, 15))) == 15)
    println(maximumCpuLoad(listOf(Job(1, 4, 2), Job(2, 4, 1), Job(3, 6, 5))) == 8)
}

main()
