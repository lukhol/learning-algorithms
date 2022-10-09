import java.util.*

class FreqStack {
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
