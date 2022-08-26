#!/usr/bin/env kotlin
// Given the head of a LinkedList with a cycle, find the length of the cycle.

class LinkedList(val value: Int, var next: LinkedList? = null)

// 1-1, 2-3, 3-5, 4-7, 5-5 (meet) -> iterate from 5 to 5 again counting
// 1 -> 2 -> 3 -> 4
//           |    |
//           6 <- 5
// S: O(1)
// T: O(n)
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

println(findCycleLength(node1) == 3)
