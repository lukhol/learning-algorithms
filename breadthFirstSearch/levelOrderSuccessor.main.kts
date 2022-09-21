#!/usr/bin/envkotlin kotlin

import java.util.LinkedList
import java.util.Queue

// Given a binary tree and a node, find the level order successor of the given node in the tree. 
// The level order successor is the node that appears right after the given node in the level order traversal.

class TreeNode (val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    fun traverse(root: TreeNode, target: Int): Int {
        val result = arrayListOf<Double>()
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        var next = false
        while(queue.isNotEmpty()) {
            val elementsOnLevel = queue.size
            var thisLevelSum = 0.0
            for (i in 0 until elementsOnLevel) {
                val current = queue.poll()
                if (next) return current.value
                if (current.value == target) next = true
                current.left?.let { queue.add(it) }
                current.right?.let { queue.add(it) }
            }
            result.add(thisLevelSum / elementsOnLevel)
        }
        
        return -1
    }

    val root = TreeNode(12)
    root.left = TreeNode(7)
    root.right = TreeNode(1)
    root.left?.left = TreeNode(9)
    root.right?.left = TreeNode(10)
    root.right?.right = TreeNode(5)
    println(traverse(root, 12) == 7)
    println(traverse(root, 1) == 9)
    println(traverse(root, 10) == 5)
    println(traverse(root, 5) == -1)

}

main()
