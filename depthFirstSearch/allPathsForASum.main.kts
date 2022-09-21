#!/usr/bin/envkotlin kotlin

import java.util.LinkedList
import java.util.Queue

// Given a binary tree and a number ‘S’, find all paths from root-to-leaf
// such that the sum of all the node values of each path equals ‘S’.

class TreeNode (val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    var next: TreeNode? = null
}

// S: O(n) - functions stack because of recursion
// T: O(n)
fun main() {
    
    fun binarybinaryTreePathSum(root: TreeNode, targetSum: Int): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        
        fun dfs(node: TreeNode?, currentSum: Int, currentPath: List<Int> = emptyList()) {
            if (node == null) return
            var newSum = currentSum - node.value
            if (newSum == 0 && node.left == null && node.right == null) {
                result.add(currentPath.plus(node.value))
                return 
            }
            dfs(node.left, newSum, currentPath.plus(node.value))
            dfs(node.right, newSum, currentPath.plus(node.value))
        }
        
        println(result)
        return result
    }
    
    val root = TreeNode(12)

    root.left = TreeNode(7)
    root.right = TreeNode(1)

    root.left?.left = TreeNode(4)
    root.right?.left = TreeNode(10)
    root.right?.right = TreeNode(5)

    val result = binarybinaryTreePathSum(root, 23)
    println(result)
    println(result == listOf(listOf(12, 7, 4), listOf(12, 1, 10)))
}

main()
