#!/usr/bin/envkotlin kotlin

import java.util.LinkedList
import java.util.Queue

class TreeNode (val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    fun sumOfPathNumbers(root: TreeNode): Int {
      	
        fun dfs(node: TreeNode?, currentNumber: String, totalSum: Int): Int {
            if (node == null) return totalSum
			      val newCurrent = currentNumber + node.value.toString()
            
            if (node.left == null && node.right == null) {
                return newCurrent.toInt() + totalSum
            } 
            
            var newTotal = totalSum
            newTotal = Math.max(newTotal, dfs(node.left, newCurrent, newTotal))
            newTotal = Math.max(newTotal, dfs(node.right, newCurrent, newTotal))
            return newTotal
        }
        
        return dfs(root, "", 0)
    }
    
    val root = TreeNode(1)

    root.left = TreeNode(7)
    root.right = TreeNode(9)

    root.right?.left = TreeNode(2)
    root.right?.right = TreeNode(9)

    val result = sumOfPathNumbers(root)
    println(result)
    println(result == 408)
}

main()
