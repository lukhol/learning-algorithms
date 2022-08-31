#!/usr/bin/envkotlin kotlin
// https://leetcode.com/problems/merge-k-sorted-lists/submissions/

// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.

// Example
// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

// Create head and tail variables, at the beginning set to null
// Iterate over all lists first elements and choose smallest one
// Disconnect that smallest one and connect to tail of final list
// Iterate until there are no more elements
class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var finalHead: ListNode? = null
        var finalTail: ListNode? = null
        
        while (lists.any { it != null }) {
            var smallestIdxList = arrayListOf<Int>()
            var smallestSoFar = Int.MAX_VALUE
            for (idx in lists.indices) {
                val currentList = lists[idx]
                if (currentList == null) continue
                val currentValue = currentList.`val`
                if (smallestSoFar > currentValue) {
                    smallestSoFar = currentValue
                    smallestIdxList.clear()
                    smallestIdxList.add(idx)
                } else if (smallestSoFar == currentValue) {
                    smallestIdxList.add(idx)
                }
            }
            
            if (smallestIdxList.isNotEmpty()) {
                for (idx in smallestIdxList) {
                    val tmpNext = lists[idx]?.next
                    lists[idx]?.next = null
                    finalTail?.next = lists[idx]
                    finalTail = lists[idx]
                    if(finalHead == null) finalHead = finalTail
                    lists[idx] = tmpNext
                }
            } else {
                break
            }
        }
        
        return finalHead
    }
}
