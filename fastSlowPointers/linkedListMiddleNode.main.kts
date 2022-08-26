#!/usr/bin/env kotlin
    
// Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.
// If the total number of nodes in the LinkedList is even, return the second middle node.

class LinkedList(val value: Int, var next: LinkedList? = null)

// S: O(1)
// T: O(n)
fun middleNode(head: LinkedList?): LinkedList {
  var slow = head
  var fast = head
  while (fast?.next != null) {
    slow = slow?.next
    fast = fast.next?.next
  }
  
  return slow
}
