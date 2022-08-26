#!/usr/bin/env kotlin

// Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle. 

class LinkedList(val value: Int, var next: LinkedList? = null)

fun findCycleStart(head: LinkedList): LinkedList {
  
  // TODO
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
