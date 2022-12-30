Directory for data structures knowledge - I will probably do not implement own versions of data structures but rather keep there properties of different data structures and information when and why they are good for certain use cases.

## Heap (sterta/stos/kopiec)

`Heap` is in general a special type of binary tree that must follow below criterias:
- it's a complete binary tree (all levels has to be fully filled except the last one which can be not fully filed from the right side)
- the value of each nod must be not greater/not smaller than the value of it's child nodes
- `insert` / `delete` takes `log n` time
- obtaining biggest/smallest element takes constance time `O(1)`

Insert operation is typically done by adding value to the end of the tree to keep it complete and then move that leaf up to the proper position.
- min heap - vaule of each node is <= values of it's children
- max heap - value of each node is >= values of it's children

Delete operation is typicaly done by replacing last leaf with the root element and then removing last element. In such a way we always have a complete binary tree that just have to be rebalanced (root node has to be moved down).

Heap can be implemented with an array:
- root element has index 1
- indexes are assigned from left to right (like in BFS traversal)
- find parent node `n = n / 2`
- left child `n * 2`
- right child `n * 2 + 1`
- to decide if this is a leaf `i > n/2` - when index is bigger than `n/2` then it's a leaf

Application of Heap:
- Heap Sort
- The Top-K problem
- The K-th element
- Stepping median - can be solved with two heaps - `max` with smallest part of the dataset and `min` with biggest part of the dataset


## Trie

`Trie` is a tree like data structure that is used to efficiently find a word or prefix in collection of words. In a Trie, each node in the tree represents a single character in a string. The root node represents the empty string, and the edges between nodes represent the cahracters that make up the string. Each node may have multiple children, representing the different possible characters that can follow the character represented by the node. The easiest possible implementation is below:
```kotlin
class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var isEndOfWord = false
}

class Trie {
    val root = TrieNode()

    fun insert(word: String) {
        var current = root
        for (c in word) {
            current = current.children.getOrPut(c) { TrieNode() }
        }
        current.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        var current = root
        for (c in word) {
            current = current.children[c] ?: return false
        }
        return current.isEndOfWord
    }
}
```
