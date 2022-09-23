#!/usr/bin/envkotlin kotlin

// Given an array of numbers and a number ‘k’, find the median of all the ‘k’ sized sub-arrays (or windows) of the array.

import java.util.PriorityQueue
import java.util.Comparator

// T: O(nk)
// S: O(k)
class SlidingWindowMedian {
    val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())
    val minHeap = PriorityQueue<Int>()
    
    fun median(numbers: List<Int>, windowSize: Int): List<Double> {
        val result = arrayListOf<Double>()
        var startIdx = 0
        for (endIdx in numbers.indices) {
            addNumber(numbers[endIdx])
            rebalance()
            
            if (endIdx - startIdx + 1 == windowSize) {
                println("start: ${startIdx}, end: ${endIdx}, max: ${maxHeap}, min: ${minHeap}, median: ${getMedian()}")
             	result.add(getMedian())
                removeNumber(numbers[startIdx++])
            }
        }
        
     	return result
    }
    
    private fun removeNumber(number: Int) {
        if (!maxHeap.remove(number)) {
            minHeap.remove(number)
        }
        rebalance()
    }
    
    private fun addNumber(element: Int) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= element) {
            maxHeap.add(element)
        } else {
            minHeap.add(element)
        }
    }
    
    private fun rebalance() {
        if (maxHeap.size > minHeap.size + 1) {
            minHeap.add(maxHeap.poll())
        } else if (minHeap.size > maxHeap.size) {
			maxHeap.add(minHeap.poll())            
        }
    }
    
    private fun getMedian(): Double  {
        if (maxHeap.size == minHeap.size) {
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0
        }
        return maxHeap.peek().toDouble()
    }
}

fun main() {
    println(SlidingWindowMedian().median(listOf(1, 2, -1, 3, 5), 3) == listOf(1.0, 2.0, 3.0))
    println(SlidingWindowMedian().median(listOf(1, 2, -1, 3, 5), 2) == listOf(1.5, 0.5, 1.0, 4.0))
}

main()
