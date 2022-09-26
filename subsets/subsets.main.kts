#!/usr/bin/envkotlin kotlin

fun subsets(arr: List<Int>): List<List<Int>> {
    val result = arrayListOf(listOf<Int>())

    for (i in 0 .. arr.lastIndex) {
        val resultSize = result.size
        for (idx in 0 until resultSize) {
            result.add(result[idx].plus(arr[i]))
        }
    }

    return result
}

fun subsetsDfs(nums: IntArray): List<List<Int>> {
    val result = arrayListOf<MutableList<Int>>()

    fun dfs(startFromIndex: Int, curr: MutableList<Int>, numOfElements: Int) {
        if (numOfElements == curr.size) {
            result.add(ArrayList(curr))
            if (numOfElements == nums.size) return
        }

        for (i in startFromIndex .. nums.lastIndex) {
            curr.add(nums[i])
            dfs(i + 1, curr, numOfElements + 1)
            curr.removeAt(curr.size - 1)
        }
    }

    dfs(0, arrayListOf(), 0)

    return result
}

println(subsets(listOf(1, 3)) == listOf(
    listOf(),
    listOf(1),
    listOf(3),
    listOf(1, 3)
))
println(subsets(listOf(1, 5, 3)) == listOf(
    listOf(),
    listOf(1),
    listOf(5),
    listOf(3),
    listOf(1, 5),
    listOf(1, 3),
    listOf(5, 3),
    listOf(1, 5, 3)
))
