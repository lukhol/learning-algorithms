// https://leetcode.com/problems/minimum-cost-to-connect-sticks/

// Given `N` ropes with different lengths, we need to connect these ropes into one big rope
// with minimum cost. The cost of connecting two ropes is equal to the sum of their lengths.

class Solution {

    fun connectRopes(ropeLengths: List<Int>): Int {
        val heap = PriorityQueue<Int>()
        heap.addAll(ropeLengths)

        var sum = 0
        while (heap.size > 1) {
            val tmp = heap.poll() + heap.poll()
            heap.add(tmp)
            sum += tmp
        }

        return sum
    }
}

fun main() {
    println(Solution().connectRopes(listOf(1, 3, 11, 5)) == 33)
    println(Solution().connectRopes(listOf(3, 4, 5, 6)) == 36)
    println(Solution().connectRopes(listOf(1, 3, 11, 5, 2)) == 42)
}
