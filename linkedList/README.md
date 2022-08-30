### LinkedList template 
```kotlin
open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}
```

Most of LinkedList questions are about singly linked list. Basic building blocks for most of the questions are:
1. Reverse linked list in place (prev, current, tmpNext).
```kotlin
fun reverseLinkedList(head: LinkedList): LinkedList {
    var prev: LinkedList? = null
    var current: LinkedList? = head
    while (current != null) {
        val next = current.next
        current.next = prev
        prev = current
        current = next
    }
    return prev!!
}
```
2. Split linked list into two parts (can be achieved with two pointers) and optionally reverse one part.
```kotlin
fun splitInTheMiddle(head: LinkedList?): LinkedList {
    var slow = head
    var fast = head
    var prev = head
    while (fast != null) {
        prev = slow
        slow = slow?.next
        fast = fast.next?.next
    }

    prev?.next = null
    return slow!!
}
```
3. Maintain more than two pointers, split list into multiple lists and then connect them together again in different order. Usually for each sublist we need head, tail and sometimes prev element.
```kotlin
fun rearrangeLinkedList(head: LinkedList, k: Int): LinkedList {
    // Maintain multiple heads and tails
    var firstListHead: LinkedList? = null
    var firstListTail: LinkedList? = null
    
    var secondListHead: LinkedList? = null
    var secondListTail: LinkedList? = null
    
    var thirdListHead: LinkedList? = null
    var thirdListTail: LinkedList? = null
    
    // Maintain current
    var current: LinkedList? = head
    
    while (current != null) {
        if (current.value == k) {
            secondListTail?.next = current
            secondListTail = current
            if (secondListHead == null) secondListHead = current
        } else if (current.value > k) {
            thirdListTail?.next = current
            thirdListTail = current
            if (thirdListHead == null) thirdListHead = current
        } else {
            firstListTail?.next = current
            firstListTail = current
            if (firstListHead == null) firstListHead = current
        }
        
        // Each item just assigned to one of the lists has to be disconnect from next elements in list
        var tmpNext = current.next
        current.next = null
        current = tmpNext
    }
    
    // Connect all lists
    if (secondListHead == null) {
        firstListTail?.next = thirdListHead
    } else {
        firstListTail?.next = secondListHead
        secondListTail?.next = thirdListHead
    }
    
    return (firstListHead ?: secondListHead) ?: thirdListHead!!
}
```
4. Calculating length of the linked list.
```kotlin
fun linkedListLength(head: LinkedList): Int {
    var length = 0
    var curr: LinkedList? = head
    while(curr != null) {
        length++
        curr = curr.next
    }
    return length
}
```
5. Finding last element
``` kotlin
fun findLastNodeInLinkedList(head: LinkedList): LinkedList {
    var current: LinkedList = head
    while (current.next != null) {
        current = current.next
    }
    return current
}
```

Typically to solve more complex question multiple technics from above needs to be combined.

