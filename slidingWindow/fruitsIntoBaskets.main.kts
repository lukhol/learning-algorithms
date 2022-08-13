#!/usr/bin/env kotlin

// Given an array of characters where each character represents a fruit tree,
// you are given two baskets and your goal is to put maximum number of fruits
// in each basket. The only restriction is that each basket can have only one
// type of fruit.
//
// You can start with any tree, but once you have started you can’t skip a tree.
// You will pick one fruit from each tree until you cannot, i.e., you will stop
// when you have to pick from a third fruit type.
//
// Write a function to return the maximum number of fruits in both the baskets.

// S: O(1)
// T: O(n)
fun fruitsIntoBaskets(fruits: List<Char>): Int {
    var startIdx = 0
    val baskets = hashMapOf<Char, Int>()

    for (endIdx in fruits.indices) {
        val fruit = fruits[endIdx]
        baskets.compute(fruit) { _, value ->
            if (value == null) 1 else value + 1
        }

        while(baskets.size > 2) {
            val startFruit = fruits[startIdx]
            baskets.compute(startFruit) { _, value ->
                if (value == null) 0 else value - 1
            }
            baskets.remove(startFruit, 0)

            startIdx++
        }
    }

    return baskets.map { it.value }.sum()
}

val result = fruitsIntoBaskets(listOf('A', 'B', 'C', 'A', 'C'))
assert(result == 3)

val result2 = fruitsIntoBaskets(listOf('A', 'B', 'C', 'B', 'B', 'C'))
assert(result2 == 5)
