#!/usr/bin/envkotlin kotlin

// Given a set of numbers that might contain duplicates, find all of its distinct subsets.
// T: O(2^n)
// S: O(2^n)
fun subsetsWithDuplicates(nums: IntArray): List<List<Int>> {
    nums.sort()
    val result = arrayListOf(listOf<Int>())

    var endIdx = 0
    for (i in 0 .. nums.lastIndex) {
        val startIdx = if (i > 0 && nums[i - 1] == nums[i]) endIdx + 1 else 0
        endIdx = result.lastIndex
        for (idx in startIdx .. endIdx) {
            result.add(result[idx].plus(nums[i]))
        }
    }

    return result
}

fun subsetsWithDuplicatesDfs(nums: IntArray): List<List<Int>> {
    nums.sort()
    val result = arrayListOf<MutableList<Int>>()

    fun dfs(startIdx: Int, current: MutableList<Int>) {
        result.add(ArrayList(current))

        for (i in startIdx .. nums.lastIndex) {
            if (i > startIdx && nums[i] == nums[i - 1]) {
                continue
            }

            current.add(nums[i])
            dfs(i + 1, current)
            current.removeAt(current.size - 1)
        }
    }

    dfs(0, arrayListOf())
    return result
}

println(subsetsWithDuplicates(intArrayOf(1, 3, 3)) == listOf(
    listOf(),
    listOf(1),
    listOf(3),
    listOf(1, 3),
    listOf(3, 3),
    listOf(1, 3, 3),
))
println(subsetsWithDuplicates(intArrayOf(1, 5, 3, 3)) == listOf(
    listOf(),
    listOf(1),
    listOf(3),
    listOf(1, 3),
    listOf(3, 3),
    listOf(1, 3, 3),
    listOf(5),
    listOf(1, 5),
    listOf(3, 5),
    listOf(1, 3, 5),
    listOf(3, 3, 5),
    listOf(1, 3, 3, 5),
))

