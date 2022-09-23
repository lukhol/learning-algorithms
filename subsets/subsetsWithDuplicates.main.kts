#!/usr/bin/envkotlin kotlin

fun subsetsWithDuplicates(arr: List<Int>): List<List<Int>> {
    val sorted = arr.sorted()
    val result = arrayListOf(listOf<Int>())

    for (i in 0 .. arr.lastIndex) {
        val from = if (i > 0 && sorted[i - 1] == sorted[i]) result.size / 2 else 0
        for (idx in from until result.size) {
            result.add(result[idx].plus(sorted[i]))
        }
    }

    return result
}

println(subsetsWithDuplicates(listOf(1, 3, 3)) == listOf(
    listOf(),
    listOf(1),
    listOf(3),
    listOf(1, 3),
    listOf(3, 3),
    listOf(1, 3, 3),
))
println(subsetsWithDuplicates(listOf(1, 5, 3, 3)) == listOf(
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

