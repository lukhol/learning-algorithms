// Given an array, find the sum of all numbers between the K1’th and K2’th smallest elements of that array.

fun main() {
    println(Solution().sumOfElementsInRange(intArrayOf(1, 3, 12, 5, 15, 11), 3, 6) == 23)
    println(Solution().sumOfElementsInRange(intArrayOf(3, 5, 8, 7), 1, 4) == 12)
}

class Solution {
    // S: O(n)
    // T: O(n logn)
    fun sumOfElementsInRange(arr: IntArray, start: Int, end: Int): Int {
        val minHeap = PriorityQueue<Int>()
        arr.forEach { minHeap.add(it) }
        repeat(start) { minHeap.poll() }
        var sum = 0
        repeat((end - start) - 1) { sum += minHeap.poll() }
        return sum
    }
}
