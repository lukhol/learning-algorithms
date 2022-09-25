#!/usr/bin/envkotlin kotlin

import java.util.*

/**
 * Given a set of distinct numbers, find all of its permutations.
 * Permutation is defined as the re-arranging of the elements of the set.
 * For example, {1, 2, 3} has the following six permutations:
 *
 * {1, 2, 3}
 * {1, 3, 2}
 * {2, 1, 3}
 * {2, 3, 1}
 * {3, 1, 2}
 * {3, 2, 1}
 *
 * If a set has ‘n’ distinct elements it will have n!n! permutations.
 */

// Permutation
fun subsetsWithDuplicates(nums: IntArray): List<List<Int>> {
    val result = arrayListOf<List<Int>>()
    val queue: Queue<List<Int>> = LinkedList()
    queue.add(emptyList())

    for (item in nums) {
        for (permutationId in 0 .. result.lastIndex) {
            val permutation = result[permutationId]
            queue.add(permutation)
        }

        (0 until queue.size).forEach { _ ->
            val permutation = queue.poll()
            for (i in 0 .. permutation.size) {
                val copy = permutation.toMutableList()
                copy.add(i, item)
                if (copy.size == nums.size) {
                    result.add(copy)
                } else {
                    queue.add(copy)
                }
            }
        }
    }

    return result
}

println(subsetsWithDuplicates(intArrayOf(1, 3, 5)) == listOf(
    listOf(5, 3, 1),
    listOf(3, 5, 1),
    listOf(3, 1, 5),
    listOf(5, 1, 3),
    listOf(1, 5, 3),
    listOf(1, 3, 5),
))

