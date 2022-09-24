#!/usr/bin/envkotlin kotlin

// Given a set of investment projects with their respective profits, we need to find the most profitable projects.
// We are given an initial capital and are allowed to invest only in a fixed number of projects.
// Our goal is to choose projects that give us the maximum profit.
//
// Example:
// Input: Project Capitals=[0,1,2], Project Profits=[1,2,3], Initial Capital=1, Number of Projects=2
// Output: 6
// Explanation:
//
// With initial capital of `1`, we will start the second project which will give us profit of `2`.
// Once we selected our first project, our total capital will become 3 (profit + initial capital).
// With `3` capital, we will select the third project, which will give us `3` profit.
// After the completion of the two projects, our total capital will be 6 (1+2+3).

// We can start an investment project only when we have the required capital.
// Once a project is selected, we can assume that its profit has become our capital.

import java.util.PriorityQueue

/**
 * Important thing here is that we have two input arrays - capital and profits.
 * Easy way to correlate those two arrays is to use indexes instead of values
 * in those arrays. It's possible because each index in both arrays represent
 * the same project in both of them. Knowing that we can sort indexes in meanCapitalHeap
 * by capital in order to always find project that required the smallest amount
 * of capital. Then we can sort indexes in maxProfitHeap to always find projects
 * with maximum profit. Because we know that we can afford only for projects with
 * indexes stored in minCapitalHeap, by inserting those indexes to maxProfitHeap
 * we are able to efficiently select most profitable projects.
 *
 * S: O(n) - we need to store all indexes in minCapitalHeap and part of them in maxCapitalHeap
 * T: O(n logn) - adding all indexes to minCapitalHeap + O(k logk) - adding to maxHeap
 * n - number of projects
 * k - number of projects that we are selecting
 */
fun findMaximumCapital(
    capital: List<Int>,
    profits: List<Int>,
    numberOfProjects: Int,
    initialCapital: Int
): Int {
    // We are using indexes to construct min and max heap to easily correlate
    // Both heaps
    val minCapitalHeap = PriorityQueue<Int> { i1, i2 -> capital[i1] - capital[i2] }
    val maxProfitHeap = PriorityQueue<Int> { i1, i2 -> profits[i2] - profits[i1] }

    // Add all indexes to min capital heap - in this way we will have indexes sorted
    // by required capital starting from smaller one.
    for (i in profits.indices) {
        minCapitalHeap.add(i)
    }

    // We are staring with some initial capital
    var availableCapital = initialCapital

    // We can choose only numberOfProjects projects
    for (i in 0 until numberOfProjects) {
        // We are adding all indexes from minCapital that we can choose from.
        while(minCapitalHeap.isNotEmpty() && capital[minCapitalHeap.peek()] <= availableCapital) {
            maxProfitHeap.add(minCapitalHeap.poll())
        }

        // If there is nothing we can afford then we can end computation.
        if (maxProfitHeap.isEmpty()) {
            break
        }

        // From all possible profits that we can afford (that we added in while loop)
        // we are choosing one with the biggest profit.
        availableCapital += profits[maxProfitHeap.poll()]
    }

    return availableCapital
}

fun main() {
    println(findMaximumCapital(listOf(0, 1, 2), listOf(1, 2, 3), 2, 1) == 6)
    println(findMaximumCapital(listOf(0, 1, 2, 3), listOf(1, 2, 3, 5), 3, 0) == 8)
}

main()
