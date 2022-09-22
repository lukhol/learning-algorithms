### Depth First Search

#### Description
It's an algorithm for traversing tree or graph. The algorithm starts at the root node and explore nodes as deep as it's possible before bactracking to nodes on earlier levels. For graph usually extra Set data strucutres is needed to keep track of already visited nodes. For tree it's not necessary.

This algorithm can traverse nodes in different orders
- preorder / reversed preorder
- inorder / reversed inorder (for binary trees only)
- postorder / reversed postorder

Algorithm is usually performed with recursion but can be also done with iterative approach using stack (not queue as it's done in BFS).

```kotlin
class TreeNode (val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
```

#### Template
**Typical implementation**
```kotlin
fun dfs(node: TreeNode?) {
  if (node == null) return
  // Preorder
  dfs(node.left)
  // Inorder
  dfs(node.right)
  // Postorder
}
```

**Values can be build bottom up**
```kotlin
// Count nodes
fun dfs(node: TreeNode?): Int {
  if (node == null) return 0
  return dfs(node.left) + dfs(node.right) + 1
}
```

**Values can be build top down**
```kotlin
// Keep track of current level
fun dfs(node: TreeNode?, level: Int = 0) {
  if (node == null) return 
  dfs(node.left, level + 1)
  dfs(node.right, level + 1)
}
```
