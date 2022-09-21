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
    // T: O(n^2)
    fun countPathsForASum(root: TreeNode, s: Int): Int {
        fun isEqualInRow(nums: List<Int>, sum: Int): Boolean {
            for (i in nums.lastIndex - 1 downTo 0) {
                val thisSum = nums.subList(i, nums.lastIndex + 1).sum()
                if (thisSum == sum) return true
            }
            return false
        }

        fun dfs(node: TreeNode?, numsUntilNow: MutableList<Int>, count: Int): Int {
            if (node == null) return count
            numsUntilNow.add(node.value)
            var newCount = if (isEqualInRow(numsUntilNow, s)) count + 1 else count
            newCount = Math.max(newCount, dfs(node.left, numsUntilNow, newCount))
            newCount = Math.max(newCount, dfs(node.right, numsUntilNow, newCount))
            numsUntilNow.removeLast()
            return newCount
        }

        return dfs(root, arrayListOf(), 0)
    }

    val root = TreeNode(1)
    root.left = TreeNode(7)
    root.right = TreeNode(9)

    root.left?.left = TreeNode(6)
    root.left?.right = TreeNode(5)
    root.right?.left = TreeNode(2)
    root.right?.right = TreeNode(3)

    val count = countPathsForASum(root, 12)
    println(count)
    println(count == 3)
}

main()
