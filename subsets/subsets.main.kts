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
