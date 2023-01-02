**When we need to keep min/max value of a collection we can solve it in a two ways**
1. Keep lowest/biggest value for each element in a separated instance of the collection (true for collections that keeps order of insertion)
2. Create data class that will keep original value and min/max so far value.
    
Example of such question is here - https://leetcode.com/problems/min-stack/description/

and solution is simple

```kotlin
data class Item(val value: Int, val minSoFar: Int)

class MinStack() {

    private val stack = Stack<Item>()

    fun push(`val`: Int) {
        if (stack.isEmpty()) {
            stack.push(Item(`val`, `val`))
            return
        }

        stack.push(Item(`val`, Math.min(stack.peek()!!.minSoFar, `val`)))
    }

    fun pop() {
        stack.pop()
    }

    fun top(): Int {
        return stack.peek().value
    }

    fun getMin(): Int {
        return stack.peek()!!.minSoFar
    }
}
```


**Max/Min heap in Kotlin**
- Min Heap - `val minHeap = PriorityQueue<Int>() / PriorityQueue<Int> { a, b -> a - b }`
- Max Heap -  `val maxHeap = PriorityQueue<Int>(Collections.reverseOrder()) / PriorityQueue<Int> { a, b -> b - a }`
