## Union find
The main idea of a "disjoint set" is to have all connected vertices have the same parent node or root node, whether directly or indirectly connected. To check if two vertices are connected, we only need to check if they have the same root node.

The two most important functions for "disjoint set" data structure are the `find` function and the `union` function. The `find` function locates the root node of a given vertex. The `union` function connects two previously unconnected vertices by giving them the same root. There is another important function named `connected`, which checks for the `connectivility` of two vertices. The `find` and `union` functions are esseitnal for any question that uses the "disjoint set" data structure.

#### Common interface
```kotlin
interface UnionFind {
    fun find(node: Int): Int
    fun rootsCount(): Int
    fun union(a: Int, b: Int)
    fun areConnected(a: Int, b: Int): Boolean = find(a) == find(b)
}
```

#### Quick find
```kotlin
class UnionFindFastFind(n: Int): UnionFind {
    private val disjointSet = IntArray(n) { it }

    override fun find(node: Int): Int = disjointSet[node]

    override fun rootsCount(): Int = disjointSet.toSet().size

    override fun union(a: Int, b: Int) {
        if (a == b) return
        val aParent = disjointSet[a]
        val bParent = disjointSet[b]
        if (aParent != bParent) {
            for (i in disjointSet.indices) {
                if (disjointSet[i] == bParent) {
                    disjointSet[i] = aParent
                }
            }
        }
    }
}
```

#### Quick union
```kotlin
class UnionFindFastUnion(n: Int): UnionFind {
    private val disjointSet = IntArray(n) { it }

    override fun find(node: Int): Int {
        var innerNode = node
        while (disjointSet[innerNode] != innerNode) {
            innerNode = disjointSet[innerNode]
        }
        return innerNode
    }

    override fun rootsCount(): Int {
        val counter = hashSetOf<Int>()
        for (node in disjointSet) {
            counter.add(find(node))
        }
        return counter.size
    }

    override fun union(a: Int, b: Int) {
        val rootA = find(a)
        val rootB = find(b)

        if (rootA != rootB) {
            disjointSet[rootB] = rootA
        }
    }
}
```

#### Union by rank
It's optimization for quick union implementation for faster find method. In worst case tree represented as this data structure can be linked list which makes find operation O(n) time complexity. To optimize this when we have two nodes that are not the same we should choose as a parent tree with smaller height of the tree. We also need additional `rank` array to store information about height of the tree from each parent. Initially it's 0.


#### Path compression
