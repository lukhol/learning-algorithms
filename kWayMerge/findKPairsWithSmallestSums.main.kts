import java.util.*

// You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
// Define a pair (u, v) which consists of one element from the first array and one element from the second array.
// Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums. 

// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/

class Solution {
    
    // S: O(k) - on the heap there are at most k + 1 elements
    // T: (k^2 log k) - in worst case we will have to include all possible pairs from nums1 and nums2 arrays
    fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
        val maxHeap = PriorityQueue<List<Int>>(compareByDescending { it.sum() })
        // All indexes bigger than k can be rejected because in each pair we need to have
        // at least one item from both arrays. It's not possible to have item from both arrays 
        // and index bigger than k in any of those arrays.
        for (i in 0 .. Math.min(nums1.lastIndex, k - 1)) {
            for (j in 0 .. Math.min(nums2.lastIndex, k - 1)) {
                val item = listOf(nums1[i], nums2[j])
                // If our heap is not yet of size k we just need to add items to it
                if (maxHeap.size < k) {
                    maxHeap.add(item)
                } else {
                    // If new item is bigger than currently biggest element then there is no sens to continue
                    // Because arrays are sorted in ascending order then we will always have bigger elements from now
                    if (item.sum() > maxHeap.peek().sum()) {
                        break
                    } else {
                        // Add to heap and then poll - in such a way we will always pop the biggest element
                        maxHeap.add(item)
                        maxHeap.poll()
                    }
                }
            }
        }

       return ArrayList(maxHeap) 
    }
}

fun main() {
    val l1 = intArrayOf(1, 7, 11)
    val l2 = intArrayOf(2, 4, 6)
    println(Solution().kSmallestPairs(l1, l2, 3) == listOf(listOf(1, 6), listOf(1, 2), listOf(1, 4)))
    
    val l3 = intArrayOf(1, 2)
    val l4 = intArrayOf(3)
    println(Solution().kSmallestPairs(l3, l4, 3) == listOf(listOf(2, 3), listOf(1, 3)))
}

main()
