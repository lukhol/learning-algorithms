## Union find

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
