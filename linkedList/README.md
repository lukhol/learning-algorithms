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
3. Maintain more than two pointers, split list into multiple lists and then connect them together again in different order. Usually for each sublist we need head, tail and sometimes prev element.
4. Calculating length of the linked list.

Typically to solve more complex question multiple technics from above needs to be combined.

