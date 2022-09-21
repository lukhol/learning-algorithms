#!/usr/bin/envkotlin kotlin

// Given a binary tree and a number ‘S’, find all paths in the tree
// such that the sum of all the node values of each path equals ‘S’.
// Please note that the paths can start or end at any node but all
// paths must follow direction from parent to child (top to bottom).

class TreeNode (val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    // S: O(n)
    // T: O(n^2) - because of numberOfPathsEqualToSum
    fun countPathsForASum(root: TreeNode, s: Int): Int {
        fun numberOfPathsEqualToSum(nums: List<Int>, sum: Int): Int {
            var count = 0
            var currentSum = nums.last()
            for (i in nums.lastIndex - 1 downTo 0) {
                currentSum += nums[i]
                if (currentSum == sum) count++
            }

            return count
        }

        fun dfs(node: TreeNode?, numsUntilNow: MutableList<Int>, count: Int): Int {
            if (node == null) return count
            numsUntilNow.add(node.value)
            val pathsEqualToSumCount = numberOfPathsEqualToSum(numsUntilNow, s)
            var newCount = count + pathsEqualToSumCount
            newCount = Math.max(newCount, dfs(node.left, numsUntilNow, newCount))
            newCount = Math.max(newCount, dfs(node.right, numsUntilNow, newCount))
            numsUntilNow.removeLast()
            return newCount
        }

        return dfs(root, arrayListOf(), 0)
    }

    // Approach from educative
    fun countPathsForASum2(root: TreeNode, s: Int): Int {
        fun dfs(node: TreeNode?, numsUntilNow: MutableList<Int>): Int {
            if (node == null) return 0
            numsUntilNow.add(node.value)
            var currentSum = numsUntilNow.last()
            var currentCount = 0
            for (i in numsUntilNow.lastIndex - 1 downTo 0) {
                currentSum += numsUntilNow[i]
                if (currentSum == s) currentCount++
            }
            currentCount += dfs(node.left, numsUntilNow)
            currentCount += dfs(node.right, numsUntilNow)
            numsUntilNow.removeLast()
            return currentCount
        }

        return dfs(root, arrayListOf())
    }

    val root = TreeNode(1)
    root.left = TreeNode(7)
    root.right = TreeNode(9)

    root.left?.left = TreeNode(6)
    root.left?.right = TreeNode(5)
    root.right?.left = TreeNode(2)
    root.right?.right = TreeNode(3)

    val count = countPathsForASum2(root, 12)
    println(count)
    println(count == 3)
}

main()
