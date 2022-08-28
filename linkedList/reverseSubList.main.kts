#!/usr/bin/env kotlin

// Given the head of LinkedList and two positions `p` and `q`, reverse the LinkedList from position `p` to `q`

class LinkedList(val value: Int, var next: LinkedList? = null)

fun reverseLinkedListInPositions(head: LinkedList?, p: Int, q: Int): LinkedList? {
  if (p == q) return head
  
  var newHead = if (p > 1) head else head?.next // Will be reversed if reversing starts from first node
  var currentPos = 1
  var startFromNode = head
  var prev: LinkedList? = null
  
  while (currentPos++ != p) {
    prev = startFromNode
    startFromNode = startFromNode?.next
  }
  
  if (startFromNode == null) return head
  
  for (i in 1 .. (q - p)) {
    val (newPrev, newStart) = reverseSingleNodeInLinkedList(startFromNode, prev)
    prev = newPrev
    startFromNode = newStart
  }
  
  return newHead 
}

// i = 1 -> 2 -> 3 -> 4 -> 5
// o = 1 -> 2 -> 4 -> 3 -> 5
// head = 3
// inputPrev = 2
fun reverseSingleNodeInLinkedList(head: LinkedList?, inputPrev: LinkedList?): Pair<LinkedList?, LinkedList?> {
  var prev = inputPrev // 2
  var current = head // 3
  var next = head?.next // 4
 
  prev?.next = next // 2 -> 4
  current?.next = next?.next // 3 -> 5
  next?.next = current // 4 -> 3
  
  return Pair(next, current) // 4, 3
}

// TODO - runs/tests
