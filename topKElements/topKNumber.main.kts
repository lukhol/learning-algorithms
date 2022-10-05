// https://leetcode.com/problems/kth-largest-element-in-an-array

// Given an unsorted array of numbers, find the ‘K’ largest numbers in it.

class Solution {
    // S: O(n)
    // T: O(nlogn)
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val heap = PriorityQueue<Int> { a, b -> b - a }
        for (num in nums) {
            heap.add(num)
        }

        var counter = 0
        while (counter++ < k - 1) {
            heap.poll()
        }

        return heap.poll()
    }
}

// S: O(k)
// T: O(n log k)
class Solution2 {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val heap = PriorityQueue<Int>()
        for (num in nums) {
            heap.add(num)

            if (heap.size == k + 1) {
                heap.poll()
            }
        }

        return heap.poll()
    }
}


fun main() {
  println(Solution().findKthLargest(intArrayOf(3,2,1,5,6,4), 2) == 5)
}
