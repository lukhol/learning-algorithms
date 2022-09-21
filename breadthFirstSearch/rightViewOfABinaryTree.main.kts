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

fun main() {
    // S: O(n)
    // T: O(n)
    fun traverse(root: TreeNode): List<Int> {
        val result = arrayListOf<Int>()
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        
        while(queue.isNotEmpty()) {
            var last = queue.peek()
            for (i in 0 until queue.size) {
               	last = queue.poll()
                last.left?.let { queue.add(it) }
                last.right?.let { queue.add(it) }
            }
            result.add(last.value)
        }
        
        return result
    }
    
    // 	  12
    // 	 7  1
    //  9  10 5
    // 17
    val root = TreeNode(12)
    root.left = TreeNode(7)
    root.right = TreeNode(1)
    root.left?.left = TreeNode(9)
    root.right?.left = TreeNode(10)
    root.right?.right = TreeNode(5)
    root.left?.left?.left = TreeNode(17)
   	println(traverse(root) == listOf(12, 1, 5, 17))
    root.right?.left?.right = TreeNode(18)
   	println(traverse(root) == listOf(12, 1, 5, 18))
}
