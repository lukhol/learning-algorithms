## Union find

#### Quick find

```kotlin
class DisjointSet(n: Int) {
    private val disjointSet = IntArray(n) { it }

    fun find(node: Int): Int = disjointSet[node]

    fun rootsCount(): Int = disjointSet.toSet().size

    fun union(a: Int, b: Int) {
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

    fun areConnected(a: Int, b: Int): Boolean = find(a) == find(b)
}
```
