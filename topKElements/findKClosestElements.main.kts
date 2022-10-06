// https://leetcode.com/problems/find-k-closest-elements/description/

// Given a sorted number array and two integers `K` and `X`, find `K` closest numbers to `X` in the array.
// Return the numbers in the sorted order. `X` is not necessarily present in the array.

fun main() {
    println(Solution().findClosestElements(intArrayOf(1, 3), 1, 2) == listOf(1))
    println(Solution().findClosestElements(intArrayOf(1,2,3,4,5), 4, 3) == listOf(1, 2, 3, 4))
    println(Solution().findClosestElements(intArrayOf(1,2,3,4,5), 4, -1) == listOf(1, 2, 3, 4))
}

class Solution {
    data class Entry(val distance: Int, val value: Int)

    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        fun binarySearch(): Int {
            var start = 0
            var end = arr.lastIndex
            while (end >= start) {
                val mid = start + (end - start) / 2
                if (arr[mid] == x) {
                    return mid
                } else if (x > arr[mid]) {
                    start = mid + 1
                } else {
                    end = mid - 1
                }
            }

            return if (start > 0) start - 1 else start
        }

        var start = binarySearch()
        val end = Math.min(start + k, arr.lastIndex)
        start = Math.max(start - k, 0)

        val heap = PriorityQueue<Entry> { a, b ->
            if (a.distance == b.distance) {
                return@PriorityQueue a.value - b.value
            }
            a.distance - b.distance
        }
        for (i in start .. end) {
            val currentValue = arr[i]
            val item = Entry(Math.abs(currentValue - x), i)
            heap.add(item)
        }

        val result = arrayListOf<Int>()
        while (result.size != k) {
            result.add(arr[heap.poll().value])
        }

        result.sort()
        return result
    }

    fun findClosestElements_properOne(arr: IntArray, k: Int, x: Int): List<Int> {
        var start = 0
        var end = arr.size - k
        while (end > start) {
            val mid = (end + start) / 2
            if (x - arr[mid] > arr[mid + k] - x) {
                start = mid + 1
            } else {
                end = mid
            }
        }

        return arr.slice(start until start + k)
    }
}
