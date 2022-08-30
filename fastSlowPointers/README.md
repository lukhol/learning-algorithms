### Two points - slow and fast

```kotlin
class LinkedList(val value: Int, var next: LinkedList? = null)
```

There are two pointers
1. SLOW that is moving one node at a time
2. FAST that is moving two nodes at a time

```kotlin
fun middleNode(head: LinkedList?): LinkedList {
  var slow = head
  var fast = head
  while (fast?.next != null) {
    slow = slow?.next
    fast = fast.next?.next
  }
  
  return slow
}
```
