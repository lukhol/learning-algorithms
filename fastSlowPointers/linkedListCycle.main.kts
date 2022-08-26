#!/usr/bin/env kotlin

// Given the head of a Singly LinkedList, write a function to
// determine if the LinkedList has a cycle in it or not.

class LinkedList(val value: Int, var next: LinkedList? = null)

// S: O(1)
// T: O(n)
fun hasCycle(head: LinkedList?): Boolean {
    if (head == null) return false
    var slow = head
    var fast = head.next?.next

    while (fast != null) {
        if (fast == head) return true
        slow = slow?.next
        fast = fast.next?.next
    }

    return false
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
node6.next = node1

// Has cycle
println(hasCycle(node1))

// Clear cycle
node6.next = null
println(!hasCycle(node1))

// Alternative
fun hasCycle2(head: LinkedList?): Boolean {
    if (head == null) return false
    var slow = head
    var fast =  head

    while (fast != null && fast!!.next != null) {
        slow = slow?.next
        fast = fast?.next?.next
        if (slow == fast) return true
    }

    return false
}
