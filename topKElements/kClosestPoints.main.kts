// https://leetcode.com/problems/k-closest-points-to-origin/description/

// Given an array of points in the a 2D2D plane, find ‘K’ closest points to the origin.

fun main() {
    val result1 = Solution().kClosest(arrayOf(intArrayOf(1, 3), intArrayOf(-2, 2)), 1)
    println(result1 == listOf(listOf(-2, 2)))

    val result2 = Solution().kClosest(arrayOf(intArrayOf(3, 3), intArrayOf(5, -1), intArrayOf(-2, 4)), 2)
    println(result2 == listOf(listOf(-2, 4), listOf(3, 3)))
}

class Solution {

    class PointWithDistance (val coords: IntArray, val distance: Double)

    // S: O(k)
    // T: O(n log k)
    fun kClosest(points: Array<IntArray>, k: Int): List<List<Int>> {
        val heap = PriorityQueue<PointWithDistance> { a, b -> b.distance.compareTo(a.distance) }
        for (p in points) {
            val sum = p[0] * p[0] + p[1] * p[1]
            heap.add(PointWithDistance(p, Math.sqrt(sum.toDouble())))
            if (heap.size > k) {
                heap.poll()
            }
        }

        return heap.map { it.coords.toList() }
    }
}
