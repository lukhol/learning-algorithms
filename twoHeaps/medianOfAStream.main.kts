#!/usr/bin/envkotlin kotlin

// Design a class to calculate the median of a number stream. The class should have the following two methods:
// - insertNum(int num): stores the number in the class
// - findMedian(): returns the median of all numbers inserted in the class
// If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.

import java.util.PriorityQueue
import java.util.Comparator

// T: O(logn)
// S: O(n)
class MedianOfAStream {
    // We store half of the numbers in maxHeap and half in minHeap
    // First part (maxHeap) store all smaller elements with quick access to biggest element it this set
    // Second part (minHeap) store all bigger elements with quick access to smallest element in this set
    val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())
    val minHeap = PriorityQueue<Int>()
    
    fun insert(num: Int) {
      // We have to chose one array to be the leading one but insert there only numbers that are
      // - smaller than bigger in maxHeap
      // - bigger than smaller in minHeap
     	if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num)
        } else {
            minHeap.add(num)
        }
        
        // Rebalancing
        if (maxHeap.size > minHeap.size + 1) {
            minHeap.add(maxHeap.poll())
        } else if (minHeap.size > maxHeap.size) {
            maxHeap.add(minHeap.poll())
        }
    }
    
    fun median(): Double {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) return 0.0
        if (minHeap.size == maxHeap.size) {
            return minHeap.peek() / 2.0 + maxHeap.peek() / 2.0
        }
        return maxHeap.peek().toDouble()
    }
}

fun main() {
  val medianOfAStream = MedianOfAStream()
  medianOfAStream.insert(3)
  medianOfAStream.insert(1)
  println(medianOfAStream.median() == 2.0)
  medianOfAStream.insert(5)
  println(medianOfAStream.median() == 3.0)
  medianOfAStream.insert(4)
  println(medianOfAStream.median() == 3.5)
}

main()
