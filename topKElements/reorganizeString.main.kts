// https://leetcode.com/problems/reorganize-string/

// Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
// Return any possible rearrangement of s or return "" if not possible.
fun main() {
    println(Solution().reorganizeString("aab") == "aba")
    println(Solution().reorganizeString("aaab") == "")
    println(Solution().reorganizeString("aabbcc") == "abcbca")
    println(Solution().reorganizeString("vvvlo") == "vovlv")
}

class Solution {

    class Entry(val key: Char, var value: Int)

    // S: O(n)
    // T: O(n logk) - where k is number of unique characters
    fun reorganizeString(s: String): String {
        val result = arrayListOf<Char>()
        val map = s.groupingBy { it }.eachCount()
        val heap = PriorityQueue<Entry> { a, b -> b.value - a .value }
        map.forEach { heap.add(Entry(it.key, it.value)) }

        while (heap.isNotEmpty()) {
            var first = heap.poll()
            var second = heap.poll()

            if (first != null && second != null && result.isNotEmpty() && first.key == result.last()) {
                val tmp = first
                first = second
                second = tmp
            }

            first?.let {
                it.value -= 1
                result.add(it.key)

                if (it.value > 0) {
                    heap.add(it)
                }
            }
            second?.let {
                heap.add(it)
            }

            if (result.size > 1 && result.last() == result[result.lastIndex - 1]) {
                return ""
            }
        }

        return result.joinToString("")
    }
}
