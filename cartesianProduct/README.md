### Examples

##### Example 1
- input - `[1,2], [3,4,5]`
- output - `[1,3], [1,4], [1,5], [2,3], [2,4], [2,5]`

##### Example 2
- input - `[1,2], [4,5], [6,7]`
- output - `[1, 4, 6], [1, 4, 7], [1, 5, 6], [1, 5, 7], [2, 4, 6], [2, 4, 7], [2, 5, 6], [2, 5, 7]`


#### Reduce approach

**JavaScript**
```js
const input = [[1, 2], [3, 4, 5]]
const result = input.reduce((prev, curr) => {
    return prev.flatMap(it => curr.map(it2 => [...it, it2]))
}, [[]])
console.log(result)
```

**Kotlin**
```kotlin
val input = arrayListOf(listOf(1, 2), listOf(4, 5), listOf(6, 7))
val result = input.fold(listOf(listOf<Int>())) { prev, curr ->
    prev.flatMap { curr.map { it2 -> it.plus(it2) } }
}
println(result)
```

#### Recursive approach
**Kotlin**
```kotlin
val input = arrayListOf(listOf(1, 2), listOf(4, 5), listOf(6, 7))
val eachProductLength = input.filter { it.isNotEmpty() }.size
val recursiveResult = arrayListOf<List<Int>>()

fun cartesian(idx: Int, next: MutableList<Int>) {
    if (next.size == eachProductLength) {
        recursiveResult.add(next)
        return
    }

    for (item in input[idx]) {
        cartesian(idx + 1, next.plus(item).toMutableList())
    }
}

cartesian(0, arrayListOf())
println(recursiveResult)
```

**JavaScript**
```javascript
// TODO
```

#### Iterative approach
**Kotlin**
```kotlin 
val input = arrayListOf(listOf(1, 2), listOf(4, 5), listOf(6, 7))
val eachProductLength = input.filter { it.isNotEmpty() }.size
val iterativeResults = arrayListOf<List<Int>>()

val stack = Stack<Pair<Int, List<Int>>>()
stack.add(Pair(0, arrayListOf()))

while (stack.isNotEmpty()) {
    val current = stack.pop()
    if (current.second.size == eachProductLength) {
        iterativeResults.add(current.second)
        continue
    }

    for (item in input[current.first]) {
        stack.add(Pair(current.first + 1, current.second.plus(item)))
    }
}

println(iterativeResults)
```

**JavaScript**
```javascript
// TODO
```
