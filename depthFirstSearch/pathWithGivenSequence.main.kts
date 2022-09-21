#!/usr/bin/envkotlin kotlin

// Given a binary tree and a number sequence, find if the
// sequence is present as a root-to-leaf path in the given tree.

class TreeNode (val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    // S: O(n) - recursion
    // T: O(n) 
    fun findPath(root: TreeNode, sequence: List<Int>): Boolean {
        if (sequence.isEmpty()) return true

        fun dfs(node: TreeNode?, index: Int): Boolean {
            if (node == null || index >= sequence.size) return false
            if (node.value != sequence[index]) return false
            if (index == sequence.lastIndex && node.left == null && node.right == null) return true
            return dfs(node.left, index + 1) || dfs(node.right, index + 1)
        }

        return dfs(root, 0)
    }

    val root = TreeNode(1)
    root.left = TreeNode(0)
    root.right = TreeNode(1)
    root.left?.left = TreeNode(1)
    root.right?.left = TreeNode(6)
    root.right?.right = TreeNode(5)

    println(!findPath(root, listOf(1, 0, 7)))
    println(findPath(root, listOf(1, 1, 6)))
    println(findPath(root, listOf(1, 0, 1)))
}

main()
