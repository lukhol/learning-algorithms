class PrefixTrie<T> {
    class Node<T>(
        val value: T? = null,
        val children: MutableMap<Node<T>, Node<T>> = hashMapOf()
    ) {
        override fun equals(other: Any?): Boolean {
            if (other !is Node<*>) return false
            if (other.value == null && this.value == null) return super.equals(other)
            return other.value?.equals(this.value) ?: false
        }

        override fun hashCode(): Int {
            return value?.hashCode() ?: 0
        }

        override fun toString(): String {
            return "Node(value=$value)"
        }
    }

    private val root = Node<T>()

    fun add(iterable: Iterable<T>) {
        var current: Node<T> = root

        for (item in iterable) {
            val newNode = Node(item)
            current = if (current.children.contains(newNode)) {
                current.children[newNode]!!
            } else {
                current.children[newNode] = newNode
                newNode
            }
        }

        println(root)
    }

    fun getAllLeafs(): List<List<T>> {
        val result = mutableListOf<MutableList<T>>()
        fun dfs(node: Node<T>, prevValues: MutableList<T> = arrayListOf()) {
            if (node.children.isEmpty()) {
                result.add(prevValues)
                return
            }

            node.children.forEach { (key, value) ->
                dfs(value, prevValues.plus(value.value!!).toMutableList())
            }
        }

        dfs(root)

        return result
    }
}

fun main() {
    val trie = PrefixTrie<Char>()
    trie.add("A".toCharArray().toList())
    trie.add("ABC".toCharArray().toList())
    trie.add("ABD".toCharArray().toList())

    println(trie.getAllLeafs())
}

main()
