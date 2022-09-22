#!/usr/bin/envkotlin kotlin

// Find the path with the maximum sum in a given binary tree.
// Write a function that returns the maximum sum. A path can be
// defined as a sequence of nodes between any two nodes and
// doesn't necessarily pass through the root.

class TreeNode (val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    fun pathWithMaximumSum(root: TreeNode): Int {
    	var maxSum = Int.MIN_VALUE
        fun dfs(node: TreeNode?): Int {
            if (node == null) return 0
            val left = dfs(node.left)
            val right = dfs(node.right)
            
            maxSum = Math.max(maxSum, left + right + node.value)
            maxSum = Math.max(maxSum, left + node.value)
            maxSum = Math.max(maxSum, right + node.value)
            
           	return Math.max(left + node.value, right + node.value)
        }
        dfs(root)
        return maxSum
	}	

    fun fixtureWithRoot(): Pair<TreeNode, Int> {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)

        root.left?.left = TreeNode(4)
        root.right?.left = TreeNode(5)
        root.right?.right = TreeNode(6)
        return Pair(root, 16)
    }

    fun fixtureWithoutRoot(): Pair<TreeNode, Int> {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)

        root.left?.left = TreeNode(1)
        root.left?.right = TreeNode(3)

        root.right?.left = TreeNode(5)
        root.right?.right = TreeNode(6)

        root.right?.left?.left = TreeNode(7)
        root.right?.left?.right = TreeNode(8)

        root.right?.right?.left = TreeNode(9)

        return Pair(root, 31)
    }

    val fixture1 = fixtureWithRoot()
    val result1 = pathWithMaximumSum(fixture1.first)
    println(result1)
    println(result1 == fixture1.second)

    val fixture2 = fixtureWithoutRoot()
    val result2 = pathWithMaximumSum(fixture2.first)
    println(result2)
    println(result2 == fixture2.second)
}

main()
