#!/usr/bin/envkotlin kotlin
// Run me with kotlin twoNumberSum.kts
// /questions/two-number-sum

import java.util.*

fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {
    val elements = HashSet<Int>()
    for(item in array) {
        val complement = targetSum - item
        if (elements.contains(complement)) {
            return listOf(item, complement)
        } else {
            elements.add(item)
        }
    }
    return listOf()
}


val result = twoNumberSum(arrayListOf(3, 5, -4, 8, 11, 1, -1, 6), 10)
println(result)

