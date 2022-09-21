#!/usr/bin/envkotlin kotlin

import java.util.LinkedList
import java.util.Queue

// Given a binary tree, connect each node with its level order successor. 
// The last node of each level should point to the first node of the next level..

class TreeNode (val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    var next: TreeNode? = null
    
    fun printAsList() {
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
    fun traverse(root: TreeNode): TreeNode {
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        val head = root
        var tail: TreeNode? = root
        
        while(queue.isNotEmpty()) {
            val elementsOnLevel = queue.size
			val thisLevelNodes = LinkedList<TreeNode>()
            
            for (i in 0 until elementsOnLevel) {
                val current = queue.poll()
               	thisLevelNodes.add(current)
                if (current != tail) {
                  	tail?.next = current
               		tail = current
                }               
                current.left?.let { queue.add(it) }
                current.right?.let { queue.add(it) }
            }
        }
        
        return head
    }
    
    // Modified for zigzag
    fun traverseWithZigZag(root: TreeNode): TreeNode {
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        val head = root
        var tail: TreeNode? = root
        
        var leftToRight = true
        while(queue.isNotEmpty()) {
            val elementsOnLevel = queue.size
			val thisLevelNodes = LinkedList<TreeNode>()
            
            for (i in 0 until elementsOnLevel) {
                val current = queue.poll()
               	if (leftToRight) {
                    thisLevelNodes.addLast(current)
                } else {
                 	thisLevelNodes.addFirst(current)   
                }
               
                current.left?.let { queue.add(it) }
                current.right?.let { queue.add(it) }
            }
            
            for (node in thisLevelNodes) {
                if (node == tail) break
                tail?.next = node
                tail = node
            }
            leftToRight = !leftToRight
        }
        
        return head
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
   	traverse(root)
    root.printAsList()
}
