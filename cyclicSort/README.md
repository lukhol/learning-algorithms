### Cyclic sort

#### Description

All the questions where we need to find the repeating numbers, or missing numbers can easily be solved with the help of a pattern that is cyclic sort. In this pattern we simply place the elements of the array on their positions (or at least try to), like 1 should be at 1st position and 2 at the second position, and then we iterate again and check if for any index we have an element whose value is not equal to index + 1, then that is the missing number.

#### Template
```kotlin
fun cyclicSort(arr: MutableList<Int>): List<Int> {
  var idx = 0
  while (arr.size > idx) {
    val j = ... // index to swap - mostly arr[idx] 1
    if (areIndexesInBounds && isSwapForDifferentNumber) { 
      swap(arr, i, j)
    } else {
      idx++
    }
  }
  
  return arr
}
```

* Typical cyclic sort generalized for this template *
```kotlin
fun swap(arr: MutableList<Int>, i: Int, j: Int) {
    val tmp = arr[i]
    arr[i] = arr[j]
    arr[j] = tmp
}

fun cyclicSort(arr: MutableList<Int>): List<Int> {
    var idx = 0
    while(arr.size > idx) {
        val j = arr[idx] - 1
        val currentValue = arr[idx]

        val areIndexesInBounds = j > 0 && j < arr.size
        val isSwapForDifferentNumber = areIndexesInBounds && currentValue != arr[j] // candidateToSwap
        if (isSwapForDifferentNumber) {
            swap(arr, idx, j)
        } else {
            idx++
        }
    }
    return arr
}
```
