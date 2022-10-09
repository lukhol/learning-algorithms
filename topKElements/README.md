## Top K elements

### Description

This pattern aims to find most frequent/largest/smallest elements in a given set. The key data structure to solve top K elements problem is a `Mean Heap` or `Max Heap`. In Java it's `PriorityQueue`. Time complexity for heap is `O(log n)` for inserts and deletes (because of required rebalancing).

Generally `Heap` is not the same as `PriorityQueue`. `PriorityQueue` is an abstract data structure while `Heap` is a data structure. `Heap` is not a `PriorityQueue` but a way how it can be implmented. Implementing `PriorityQueue` with a `Heap` is the most efficient implementation.

`Heap` is in general a special type binary tree that must follow below criterias:
- it's a complete binary tree (all levels has to be fully filled except the last one which can be not fully filed from the right side)
- the value of each nod must be not greater/not smaller than the value of it's child nodes
- `insert` / `delete` takes `log n` time
- obtaining biggest/smallest element takes constance time `O(1)`



**Helpful tips** 
- when searching for any kth min/max value we do not need to store entire dataset in the heap. It's enough to store `k` elements in the heap because we are interested only in largest/smallest k elements
- it's sometimes helpful to create helper class like `class Entry(val key: String, var value: Int)` and then sort by second and still have access to that first value `key`
- when we have mutable data strucutre like Entry from previous example we can `poll` item from the heap, modify that entry and add it again
- it is useful to use `Min Heap` when we are searching for **largest** values because we are able to compare the smallest element on the heap with next value. When next value is bigger than smallest value on a heap then we can `poll` that smallest value and add next item instead. In such a way we can easily store only k top elements in a heap. Also kth element is the first one on a heap.
- sometimes it's needed to sort items on the heap based on multiple fields using comparator that use more than one field


### Template

**How to defined min/max heaps**
```kotlin
// Min and max heaps with raw types
val minHeap = PriorityQueue<Int>()
val maxHeap = PriorityQueue<Int> { a, b -> b - a }

// Or with more complex data structures like Entry
class Entry(val key: Char, var value: Int)
val minHeapEntry = PriorityQueue<Entry>(compareBy { it.value })
val maxHeapEntry = PriorityQueue<Entry>(compareByDescending { it.value })
```

**Keep only top k elements**
```kotlin
fun findKthGreatestElement(nums: IntArray, k: Int): Int {
  val minHeap = PriorityQueue<Int> { a, b -> b - a }
  for (num in nums) {
    minHeap.add(num)
   
    // With below check we always have at most k greatest elements in a heap.
    if (minHeap.size > k) {
      minHeap.poll()
    }
  }
  
  return minHeap.peek()
}
```
