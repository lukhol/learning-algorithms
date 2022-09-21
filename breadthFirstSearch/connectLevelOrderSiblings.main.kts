#!/usr/bin/envkotlin kotlin

import java.util.LinkedList
import java.util.Queue

// Given a binary tree, connect each node with its level order successor.
// The last node of each level should point to a null node.


class TreeNode (val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    var next: TreeNode? = null
    
    fun print() {
        println()
        var current: TreeNode? = this
        while (current != null) {
            print("${current.value} -> ")
        	current = current.next
        }
        print(" null")
    }
}

fun main() {
  
    // S: O(n)
    // T: O(n)
    fun traverse(root: TreeNode): List<TreeNode> {
        val result = arrayListOf<TreeNode>()
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        while(queue.isNotEmpty()) {
            val elementsOnLevel = queue.size
            var chainTail = queue.peek()
            var chainHead = queue.peek()
            
            for (i in 0 until elementsOnLevel) {
                val current = queue.poll()
                if (chainHead != current) {
                    chainHead?.next = current
                    chainHead = current
                }
                current.left?.let { queue.add(it) }
                current.right?.let { queue.add(it) }
            }
            result.add(chainTail)
        }
        
        return result
    }

    // 	 12
    // 	7  1
    // 9  10 5
    val root = TreeNode(12)
    root.left = TreeNode(7)
    root.right = TreeNode(1)
    root.left?.left = TreeNode(9)
    root.right?.left = TreeNode(10)
    root.right?.right = TreeNode(5)
    traverse(root).forEach { it.print() }
}

main()
