// https://leetcode.com/problems/merge-k-sorted-lists/description/

// Given an array of ‘K’ sorted LinkedLists, merge them into one sorted list.

import java.util.*

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    data class Node(val node: ListNode, val indexInListsArray: Int)

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var root: ListNode? = null
        var last: ListNode? = null
        val heap = PriorityQueue<ListNode>(compareBy { it.`val` })
        lists.forEach {
            it?.let { node -> heap.add(node) }
        }

        while (heap.isNotEmpty()) {
            val current = heap.poll()
            if (root == null) {
                root = current
                last = current
                current?.next?.let { heap.add(it) }
            } else {
                current?.next?.let { heap.add(it) }
                last?.next = current
                last = current
            }
        }

        return root
    }

    fun mergeKListsFirstApproach(lists: Array<ListNode?>): ListNode? {
        var root: ListNode? = null
        var last: ListNode? = null
        val heap = PriorityQueue<Node>(compareBy { it.node.`val` })

        for (i in 0 .. lists.lastIndex) {
            val current = lists[i]
            if (current != null) {
                heap.add(Node(current, i))
            }
            lists[i] = current?.next
        }

        while (heap.isNotEmpty()) {
            val current = heap.poll()
            if (root == null) {
                root = current.node
                last = current.node
            } else {
                last?.next = current.node
                last = current.node
            }

            val next = lists[current.indexInListsArray]
            lists[current.indexInListsArray] = next?.next
            if (next != null) {
                heap.add(Node(next, current.indexInListsArray))
            }
        }

        return root
    }
}
