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
import java.util.Comparator

fun findMaximumCapital(capital: List<Int>, profits: List<Int>, numberOfProjects: Int, initialCapita: Int): Int {
    return -1
}

fun main() {
    println(findMaximumCapital(listOf(0, 1, 2), listOf(1, 2, 3), 1, 2) == 6)
    println(findMaximumCapital(listOf(0, 1, 2, 3), listOf(1, 2, 3, 4), 0, 3) == 8)
}

main()
