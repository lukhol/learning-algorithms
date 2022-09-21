#!/usr/bin/envkotlin kotlin

import kotlin.math.max

// Given a binary tree, find the length of its diameter.
// The diameter of a tree is the number of nodes on the
// longest path between any two leaf nodes. The diameter
// of a tree may or may not pass through the root.

class TreeNode (val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    // S: O(n)
    // T: O(n)
    fun findBinaryTreeDiameter(root: TreeNode): Int {
        var maxDiameter = 0
        fun dfs(node: TreeNode?): Int {
            if (node == null) return 0
            val thisCount = 1
            val left = dfs(node.left)
            val right = dfs(node.right)
            maxDiameter = Math.max(maxDiameter, left + right + thisCount)
            return Math.max(left, right) + thisCount
        }

        dfs(root)
        return maxDiameter
    }

    fun fixtureWithRoot(): Pair<TreeNode, Int> {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)

        root.left?.left = TreeNode(4)
        root.left?.right = TreeNode(5)
        root.right?.left = TreeNode(6)
        root.right?.right = TreeNode(3)
        return Pair(root, 5)
    }

    fun fixtureWithoutRoot(): Pair<TreeNode, Int> {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)

        root.right?.left = TreeNode(5)
        root.right?.right = TreeNode(6)

        root.right?.left?.right = TreeNode(7)
        root.right?.left?.left = TreeNode(8)

        root.right?.right?.right = TreeNode(9)
        root.right?.right?.right?.right = TreeNode(11)

        root.right?.left?.left?.left = TreeNode(10)

        return Pair(root, 7)
    }

    val fixture1 = fixtureWithRoot()
    val result1 = findBinaryTreeDiameter(fixture1.first)
    println(result1)
    println(result1 == fixture1.second)

    val fixture2 = fixtureWithoutRoot()
    val result2 = findBinaryTreeDiameter(fixture2.first)
    println(result2)
    println(result2 == fixture2.second)
}

main()
