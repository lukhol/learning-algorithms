## K way merge

### Description

This pattern is useful when dealing with a list of sorted arrays. Whenever we are given `K` sorted arrays, we can use a Heap to efficiently perform a sorted traversal of all the elements of all ararys without creating merged array. We can push the smallest (first) element of each array to the `Min Heap` with it's indexes (to keep track of which array the element came from) to get the overall minimum. Then we can remove top element from the heap to get the smallest element and push the next element from the same array, to which this smallest element belonged, to the heap. Then repeate that process until all elements from all arrays are processed.

### Template
```kotlin
data class Item(val value: Int, val arrayIdx: Int, val inArrayIdx: Int)

fun kWayMerge(lists: List<List<Int>>): Int {
  val minHeap = PriorityQueue<Item>(compareBy { it.value })
  lists.forEachIndexed { index, list ->
    minHeap.add(Item(list[0], index, 0))
  }  
  
  val somethingToCount = 0 // for example kth smallest/bigger number
  while (minHeap.isNotEmpty()) {
    somethingToCount++
    val current = minHeap.poll()
    
    val (_, arrayIdx, inArrayIdx) = current
    val newInArrayIdx = inArrayIdx + 1
    if (matrix[arrayIdx].size > newInArrayIdx) {
      minHeap.add(Item(matrix[arrayIdx][newInArrayIdx], arrayIdx, newInArrayIdx))
    }
    
    return somethingToCount
  } 
}
```
