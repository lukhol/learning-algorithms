### Two Heaps

#### Description
This pattern is useful when dealing with problems that can be splitted into two parts. One part is bigger than the other. Because of that we are able to store smallest values in `maxHeap` with ability to efficiently retreive biggest element from smallest set. It's similiar for bigger part `minHeap` in which we can store bigger part with ability to efficiently get smallest element from that set.

#### Template
```kotlin
import java.util.PriorityQueue

val minHeap = PriorityQueue<Any> { a, b -> a - b } // Min value from bigger values
val maxHeap = PriorityQueue<Any> { a, b -> b - a } // Max value from smaller values

// TODO

```

