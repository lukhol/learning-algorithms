#!/usr/bin/envkotlin kotlin

import java.util.LinkedList
import java.util.Queue

// Find the minimum depth of a binary tree. The minimum depth is the
// number of nodes along the shortest path from the root node to the
// nearest leaf node.

class TreeNode (val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

// S: O(n)
// T: O(n)
fun main() {
    fun traverse(root: TreeNode): Int {
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        var level = 0
        while(queue.isNotEmpty()) {
            level++
            val elementsOnLevel = queue.size
            for (i in 0 until elementsOnLevel) {
                val current = queue.poll()
                if (current.left == null && current.right == null) return level
                current.left?.let { queue.add(it) }
                current.right?.let { queue.add(it) }
            }
        }

        return level
    }

    val root = TreeNode(12)
    root.left = TreeNode(7)
    root.right = TreeNode(1)
    root.left?.left = TreeNode(9)
    root.right?.left = TreeNode(10)
    root.right?.right = TreeNode(5)
    root.right?.left?.left = TreeNode(11)
    println(traverse(root) == 3)

    val root2 = TreeNode(12)
    root2.left = TreeNode(7)
    root2.right = TreeNode(1)
    root2.right?.left = TreeNode(10)
    root2.right?.right = TreeNode(5)
    println(traverse(root2) == 2)
}

main()
