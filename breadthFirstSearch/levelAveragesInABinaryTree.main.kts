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
    fun traverse(root: TreeNode): List<Double> {
        val result = arrayListOf<Double>()
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        var leftToRight = false
        while(queue.isNotEmpty()) {
            val elementsOnLevel = queue.size
            var thisLevelSum = 0.0
            for (i in 0 until elementsOnLevel) {
                val current = queue.poll()
                thisLevelSum += current.value
                current.left?.let { queue.add(it) }
                current.right?.let { queue.add(it) }
            }
            result.add(thisLevelSum / elementsOnLevel)
            leftToRight = !leftToRight
        }

        return result
    }

    val root = TreeNode(12)
    root.left = TreeNode(7)
    root.right = TreeNode(1)
    root.left?.left = TreeNode(9)
    root.right?.left = TreeNode(10)
    root.right?.right = TreeNode(5)
    root.right?.left?.left = TreeNode(20)
    root.right?.left?.right = TreeNode(17)
    val result = traverse(root)
    println(result)
    println(result == listOf(12.0, 4.0, 8.0, 18.5))
}

main()
