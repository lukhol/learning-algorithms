#!/usr/bin/envkotlin kotlin

import java.util.LinkedList
import java.util.Queue

// Given a binary tree, return an array containing nodes in its right view.
// The right view of a binary tree is the set of nodes visible when the tree
//  is seen from the right side.

class TreeNode (val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    var next: TreeNode? = null
}

// S: O(n) - functions stack because of recursion
// T: O(n)
fun main() {
    fun binaryTreePathSum(root: TreeNode, targetSum: Int): Boolean {
        var currentSum = 0
        var result = false
        fun dfs(node: TreeNode?) {
            if (node == null || result) return 
            currentSum += node.value
            if (currentSum == targetSum && node.left == null && node.right == null) {
                result = true
                return 
            }
            dfs(node.left)
            dfs(node.right)
            currentSum -= node.value
        }
        dfs(root)
        
        return result
    }
    
    fun binarybinaryTreePathSumWithSubtract(root: TreeNode, targetSum: Int): Boolean {
        fun dfs(node: TreeNode?, sum: Int): Boolean {
            if (node == null) return false 
            var newSum = sum - node.value
            if (newSum == 0 && node.left == null && node.right == null) {
                return true
            }
            var leftRes = dfs(node.left, newSum)
            var rightRes = dfs(node.right, newSum)
        	return leftRes || rightRes
        }
        
        return dfs(root, targetSum)
    }
    
    fun testCase1() {
        val root = TreeNode(1)
    
        root.left = TreeNode(2)
        root.right = TreeNode(3)

        root.left?.left = TreeNode(4)
        root.left?.right = TreeNode(5)
        root.right?.left = TreeNode(6)
        root.right?.right = TreeNode(7)

        println(binaryTreePathSum(root, 10))

        root.right?.left = TreeNode(12)
        println(!binaryTreePathSum(root, 10))
    }
    testCase1()
    
    fun testCase2() {
        val root = TreeNode(12)
    
        root.left = TreeNode(7)
        root.right = TreeNode(1)

        root.left?.left = TreeNode(9)
        root.right?.left = TreeNode(10)
        root.right?.right = TreeNode(5)

        println(binaryTreePathSum(root, 23))
        println(!binaryTreePathSum(root, 16))	
    }
    testCase2()
}
