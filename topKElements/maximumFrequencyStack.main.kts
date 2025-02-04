import java.util.*

// https://leetcode.com/problems/maximum-frequency-stack/

// Better solution that I didn't come up by my self - just implemented
// pop - T: O(log n)
// push - T: O(log n)
// S: O(n)
class FreqStack {
    private val map = hashMapOf<Int, Int>()
    private val heap = PriorityQueue(
        compareByDescending<Item> { it.count }
            .thenByDescending { it.offset }
    )
    private var offset = 0
    data class Item(val value: Int, val count: Int, val offset: Int)

    fun push(`val`: Int) {
        map.compute(`val`) { _, value -> (value ?: 0) + 1 }
        heap.add(Item(`val`, map[`val`]!!, offset++))
    }

    fun pop(): Int {
        val popped = heap.poll()
        map.compute(popped.value) { _, value -> (value ?: 0) - 1 }
        return popped.value
    }
}

// S: O(n)
// pop - T: O(log n)
// push - T: O(log n)
class FreqStack2 {
    private val map = hashMapOf<Int, Item>()
    private val heap = PriorityQueue(
        compareByDescending<Item> { it.count }
            .then(compareByDescending { it.addedAt.last() })
    )
    class Item(val value: Int, var count: Int, val addedAt: MutableList<Long>) {
        override fun toString(): String {
            return "Item(value=$value, count=$count, lastAddedAt=$addedAt)"
        }
    }

    fun push(`val`: Int) {
        val fromMap = map[`val`]
        if (fromMap != null) {
            heap.remove(fromMap)
            fromMap.count += 1
            fromMap.addedAt.add(System.nanoTime())
            heap.add(fromMap)
        } else {
            val list = LinkedList<Long>()
            list.add(System.nanoTime())
            val newItem = Item(`val`, 1, list)
            map[`val`] = newItem
            heap.add(newItem)
        }
    }

    fun pop(): Int {
        val popped = heap.poll()
        if (popped.count > 1) {
            popped.count -= 1
            popped.addedAt.removeAt(popped.addedAt.lastIndex)
            heap.add(popped)
        } else if (popped.count == 1) {
            map.remove(popped.value)
        }

        return popped.value
    }
}

// LeetCode propose solution - best one in time complexity
// Store value to it's frequency map (O(1) time access)
// Then store frequency to all items in this frequency
// 
// pop 
//  1. get all items with most frequency from `group` map
//  2. pop from the stack, update poped value frequencyCount
class FreqStack3 {
    private val freq = hashMapOf<Int, Int>() // value -> currentFrequency
    private val group = hashMapOf<Int, Stack<Int>>() // - frequency -> all items in this frequency stored in FIFO (Stack)
    private var maxFreq = 0

    fun push(`val`: Int) {
        val currentFrequency = freq.getOrDefault(`val`, 0) + 1
        freq[`val`] = currentFrequency
        maxFreq = Math.max(maxFreq, currentFrequency)
        group.computeIfAbsent(currentFrequency) { Stack() }.push(`val`)
    }

    fun pop(): Int {
        val x = group[maxFreq]!!.pop()
        freq[x] = freq[x]!! - 1
        if (group[maxFreq]!!.size == 0) {
            maxFreq--
        }

        return x
    }
}

fun main() {
    val freqStack = FreqStack()
    freqStack.push(5) // The stack is [5]
    freqStack.push(7) // The stack is [5,7]
    freqStack.push(5) // The stack is [5,7,5]
    freqStack.push(7) // The stack is [5,7,5,7]
    freqStack.push(4) // The stack is [5,7,5,7,4]
    freqStack.push(5) // The stack is [5,7,5,7,4,5]
    println(freqStack.pop() == 5) // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
    println(freqStack.pop() == 7) // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
    println(freqStack.pop() == 5) // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
    println(freqStack.pop() == 4) // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
}

main()
