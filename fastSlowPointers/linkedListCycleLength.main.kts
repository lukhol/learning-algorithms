#!/usr/bin/env kotlin

// Given the head of a LinkedList with a cycle, find the length of the cycle.

class LinkedList(val value: Int, var next: LinkedList? = null)

fun findCycleLength(head: LinkedList?): Int {
  // TODO
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
node6.next = node1

println(findCycleLength(node1) == TODO)
