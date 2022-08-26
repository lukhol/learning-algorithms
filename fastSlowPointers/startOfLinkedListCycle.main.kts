#!/usr/bin/env kotlin

// Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.

class LinkedList(val value: Int, var next: LinkedList? = null)

// Solution is to find length of the cycle, then iterate from the beginning
// by cycle length iteration. Then iterate from that position with one pointer
// and from the beginning with other pointer. When they meet then we found
// beginning of the cycle
//
// 1. Other approach is just to iterate with slow and fast pointer until they meet
// 2. Then take again two pointers - first is the head, and second is that meet node from pointer 1
// 3. Iterate using those two pointers until they meet. When meet then return.
//
// 1-1, 2-3, 3-5, 4-7, 5-3, 6-5, 7-7
// 1 -> 2 -> 3 -> 4 -> 5
//           |         |
//           8 <- 7 <- 6
// S: O(1)
// T: O(n)
fun findCycleStart(head: LinkedList): LinkedList {
    var cycleLength = findCycleLength(head)
    var slow: LinkedList? = head
    while (cycleLength-- > 0) {
        slow = slow?.next
    }

    var movingHead: LinkedList? = head
    while (movingHead != slow) {
        movingHead = movingHead?.next
        slow = slow?.next
    }

    return movingHead!!
}

fun findCycleLength(head: LinkedList?): Int {
    fun calculateLength(head: LinkedList?): Int {
        if (head?.next == head) return 0
        var slow = head?.next
        var count = 1
        while(slow != head) {
            count++
            slow = slow?.next
        }

        return count
    }

    var slow = head
    var fast = head

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
        if (slow == fast) {
            return calculateLength(slow)
        }
    }

    return 0
}

fun findLoop(head: LinkedList?): LinkedList? {
    var slow = head
    var fast = head
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast?.next?.next
        if (slow == fast) break
    }

    slow = head
    while (slow != fast) {
        slow = slow?.next
        fast = fast?.next
    }

    return slow
}

val node1 = LinkedList(1)
val node2 = LinkedList(2)
val node3 = LinkedList(3)
val node4 = LinkedList(4)
val node5 = LinkedList(5)
val node6 = LinkedList(6)

node1.next = node2
node2.next = node3
node3.next = node4
node4.next = node5
node5.next = node6
node6.next = node4

println(findCycleStart(node1) == node4)
