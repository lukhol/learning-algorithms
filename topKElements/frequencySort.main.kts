// https://leetcode.com/problems/sort-characters-by-frequency/

// Given a string, sort it based on the decreasing frequency of its characters.

fun main() {
    println(Solution().frequencySort("tree") == "eert")
    println(Solution().frequencySort("cccaaa") == "aaaccc")
    println(Solution().frequencySort("Aabb") == "bbaA")
}

class Solution {

    data class Item(val char: Char, val count: Int)

    fun frequencySort(s: String): String {
        val map = hashMapOf<Char, Int>()
        for (char in s) {
            map.compute(char) { _, value -> if (value == null) 1 else value + 1 }
        }

        val heap = PriorityQueue<Item> { a, b -> b.count - a.count }
        map.forEach { heap.add(Item(it.key, it.value)) }

        val result = CharArray(s.length)
        var idx = 0
        while(heap.isNotEmpty()) {
            val current = heap.poll()
            for (char in 0 until current.count) {
                result[idx++] = current.char
            }
        }

        return result.joinToString("")
    }
}
