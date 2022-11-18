### Binary Tree / Binary Search Tree

**Count number of nodes**
```kotlin
class Solution {
    // I need to traverse the tree in in-order manner
    fun numberOfNodes(root: TreeNode?): Int {
        fun dfs(node: TreeNode?, counter: Int): Int {
            if (node == null) return counter
            val left = dfs(node.left, counter)   
            return left + dfs(node.right, left + 1)
        }

        return dfs(root, 0)
    }
}
```

**Find kth element in the tree**
```kotlin
class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        if (root == null) return -1
        var kthSmallestElement = 0

        fun dfs(node: TreeNode?, counter: Int): Int {
            if (node == null) return counter
            val left = dfs(node.left, counter)
            val mid = left + 1
            if (mid == k) {
                kthSmallestElement = node.`val`
            }
            val right = dfs(node.right, mid)
            return right
        }

        dfs(root, 0)

        return kthSmallestElement
    }
}
```
