#!/usr/bin/envkotlin kotlin

import java.util.LinkedList
import java.util.Queue

// Given a binary tree, populate an array to represent its level-by-level traversal.
// You should populate the values of all nodes of each level from left to right in separate sub-arrays.

class TreeNode (val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    fun traverse(root: TreeNode): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        while(queue.isNotEmpty()) {
            val elementsOnLevel = queue.size
            val thisLevelValues = arrayListOf<Int>()
            for (i in 0 until elementsOnLevel) {
                val current = queue.poll()
                thisLevelValues.add(current.value)
                current.left?.let { queue.add(it) }
                current.right?.let { queue.add(it) }
            }
            result.add(thisLevelValues)
        }

        return result
    }

    val root = TreeNode(12)
    root.left = TreeNode(7)
    root.right = TreeNode(1)
    root.left?.left = TreeNode(9)
    root.right?.left = TreeNode(10)
    root.right?.right = TreeNode(5)
    val result = traverse(root)
    println(result == listOf(listOf(12), listOf(7, 1), listOf(9, 10, 5)))
}

main()
