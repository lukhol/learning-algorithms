// https://leetcode.com/problems/rearrange-string-k-distance-apart/

// Given a string and a number `K`, find if the string can be rearranged such that
// the same characters are at least `K` distance apart from each other.

fun main() {
    println(Solution().rearrangeString("aabbcc", 3) == "acbacb")
    println(Solution().rearrangeString("aa", 0) == "aa")
    println(Solution().rearrangeString("aaabc", 3) == "")
    println(Solution().rearrangeString("aaadbbcc", 2) == "abacabcd")
}

class Solution {
    class Entry(val key: Char, var value: Int)

    // S: O(n + k + j), n - string lenght, k - letters distance (stored in the queue), j - number of unique characters
    // T: O(nlogn)
    fun rearrangeString(s: String, k: Int): String {
        if (k <= 1) return s

        val map = s.groupingBy { it }.eachCount() // O(n)
        val heap = PriorityQueue<Entry>(compareByDescending { it.value })
        map.forEach { heap.add(Entry(it.key, it.value)) }  // O(nlogn)

        val queue: Queue<Entry> = LinkedList()
        val sb = StringBuilder(s.length)

        while (heap.isNotEmpty()) {
            val current = heap.poll()
            sb.append(current.key)
            current.value -= 1
            queue.offer(current)
            if (queue.size == k) {
                val currentFromQueue = queue.poll()
                if (currentFromQueue.value != 0) {
                    heap.add(currentFromQueue)
                }
            }
        }

        return if (sb.length == s.length) sb.toString() else "" // O (n)
    }
}
