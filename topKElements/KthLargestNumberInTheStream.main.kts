// https://leetcode.com/problems/kth-largest-element-in-a-stream/description/

// Design a class to efficiently find the Kth largest element in a stream of numbers.
//
// The class should have the following two things:
//
// The constructor of the class should accept an integer array containing initial numbers from the stream and an integer ‘K’.
// The class should expose a function add(int num) which will store the given number and return the Kth largest number.

fun main() {
    val kthLargest = KthLargest(3, intArrayOf(4, 5, 8, 2))
    println(kthLargest.add(3) == 4)
    println(kthLargest.add(5) == 5)
    println(kthLargest.add(10) == 5)
    println(kthLargest.add(9) == 8)
    println(kthLargest.add(4) == 8)
}

class KthLargest(private val k: Int, nums: IntArray) {

    private val heap = PriorityQueue<Int>()

    init {
        nums.forEach {
            heap.add(it)
            if (heap.size > k) {
                heap.poll()
            }
        }
    }

    fun add(`val`: Int): Int {
        heap.add(`val`)
        if (heap.size > k) heap.poll()
        return heap.peek()
    }
}
