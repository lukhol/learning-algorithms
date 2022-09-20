#!/usr/bin/envkotlin kotlin

import java.util.LinkedList
import java.util.Queue

// Given a binary tree, populate an array to represent its level-by-level traversal.
// You should populate the values of all nodes of each level from left to right in separate sub-arrays.

class TreeNode (val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

// S: O(n)
// T: O(n)
fun main() {
    fun traverse(root: TreeNode): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        var iter = 0 // It will be easier to just use leftToRight boolean variable...
        while(queue.isNotEmpty()) {
            val elementsOnLevel = queue.size
            val thisLevelValues = LinkedList<Int>()
            iter++
            for (i in 0 until elementsOnLevel) {
                val current = queue.poll()
                if (iter % 2 == 0) {
                    thisLevelValues.addFirst(current.value)
                } else {
                    thisLevelValues.addLast(current.value)
                }
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
    root.right?.left?.left = TreeNode(20)
    root.right?.left?.right = TreeNode(17)
    val result = traverse(root)
    println(result)
    println(result == listOf(listOf(12), listOf(1, 7), listOf(9, 10, 5), listOf(17, 20)))
}

main()
