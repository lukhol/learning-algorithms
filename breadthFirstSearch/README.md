### Breadth First Search

#### Description
Breadth First Seach (BFS) is a technique to traverse tree like data structures level by level. This can be achived using `Queue`. At the beginning we have to put root of the tree in the queue. Then in `while (queue.isNotEmpty())` loop at the begining of the loop we know how many items previous level has (it's just size of the queue). 
- At first while loop iteration queue contains all nodes from first level (which is always only a root).
- At second while loop iteration queue contains all nodes from second level (which is from 0 to 4 nodes for binary tree and from 0 to n for other types of trees) 

```kotlin
class TreeNode (val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
```

#### Template
```kotlin
fun bfs(root: TreeNode) {
    // Always start with queue that contains only root element
    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)
    var level = 0
    while(queue.isNotEmpty()) {
        val elementsOnLevel = queue.size // On this level we have `elementsOnLevel` elements.
        
        for (i in 0 until elementsOnLevel) {
            val current = queue.poll()
            current.left?.let { queue.add(it) }
            current.right?.let { queue.add(it) }
        }
        
        level++
    }
}
```
