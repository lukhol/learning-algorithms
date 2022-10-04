## Modified Binary Search

### Description
Binary search is an algorithm from 'divide and conquer` family. It's space complexity is O(1) and time complexity is O(logn) which is the fasters algorithm other than O(1). Input data has to be ordered in any direction (asc or desc) for this algorithm to work properly.

At each loop iteration we are rejecting half of the array by choosing only subarray to the left or to the right of the middle element. It's important to also reject middle element to do not fall into infinite loop.

- `start + (end - start) / 2` comparing to `(start+end) / 2` prevents overflow.
- sometimes it's useful to do binary search twice and then combine the results - for example when searching ranges
- when array is shifted then it's usefull to check which part - left or right is properly 
- when array is a mountain array then it's usefull to just check in which direction values are increasing
- most of the questions that need to search for some value in sorted array can be solved in O(logn) time using binary search
- in one of the steps (when choosing left or right) we can do `start = middle` or `end = middle` (without +/- 1) but in such case we need to remove equality from while loop condition to avoid infinite loop. Also additional check for single element array is needed.

### Template

https://leetcode.com/explore/learn/card/binary-search/136/template-analysis/935/

**Typical binary search for some value**
```kotlin
fun binarySearch(arr: IntArray, target: Int): Int {
    var start = 0
    var end = arr.lastIndex
    while (end >= start) {
        val middle = start + (end - start) / 2
        if (arr[middle] == target) {
            return middle
        } else if (arr[middle] > target) {
            end = middle - 1
        } else { // arr[middle] < target
            start = middle + 1
        }
    }
    
    return -1
}
```

**Find first/last occurrence of some element**
```kotlin
fun main() {
    println(findLastOccurrenceOfElement(intArrayOf(-1, 0, 0, 1, 1, 1, 2, 3, 4), 1) == 5)
    println(findLastOccurrenceOfElement(intArrayOf(-1, 0, 0, 1, 1, 1, 2, 3, 4), 5) == -1)
    println(findLastOccurrenceOfElement(intArrayOf(-1, 0, 0, 1, 1, 1, 2, 3, 4), 2) == 6)

    println(findFirstOccurrenceOfElement(intArrayOf(-1, 0, 0, 1, 1, 1, 2, 3, 4), 1) == 3)
    println(findFirstOccurrenceOfElement(intArrayOf(-1, 0, 0, 1, 1, 1, 2, 3, 4), 5) == -1)
    println(findFirstOccurrenceOfElement(intArrayOf(-1, 0, 0, 1, 1, 1, 2, 3, 4), 2) == 6)
}

fun findLastOccurrenceOfElement(arr: IntArray, target: Int): Int {
    var start = 0
    var end = arr.lastIndex
    var elementIndex = -1
    while (end >= start) {
        val middle = start + (end - start) / 2
        if (arr[middle] <= target) {
            if (arr[middle] == target) {
                elementIndex = middle
            }
            start = middle + 1
        } else {
            end = middle - 1
        }
    }

    return elementIndex
}

fun findFirstOccurrenceOfElement(arr: IntArray, target: Int): Int {
    var start = 0
    var end = arr.lastIndex
    var elementIndex = -1
    while (end >= start) {
        val middle = start + (end - start) / 2
        if (arr[middle] >= target) {
            if (arr[middle] == target) {
                elementIndex = middle
            }
            end = middle - 1
        } else {
            start = middle + 1
        }
    }

    return elementIndex
}
```

**Find next greater or smaller element**
```kotlin
fun main() {
    println(findNextBiggerElementIndex(intArrayOf(-1, 0, 0, 1, 1, 1, 2, 3, 4, 8), 1) == 6)
    println(findNextBiggerElementIndex(intArrayOf(-1, 0, 0, 1, 1, 1, 2, 3, 4, 8), 4) == 9)
    println(findNextBiggerElementIndex(intArrayOf(-1, 0, 0, 1, 1, 1, 2, 3, 4, 8), 5) == 9)
    println(findNextBiggerElementIndex(intArrayOf(-1, 0, 0, 1, 1, 1, 2, 3, 4, 8), -1) == 1)
}

fun findNextBiggerElementIndex(arr: IntArray, target: Int): Int {
    var start = 0
    var end = arr.lastIndex
    var elementIndex = 0
    while (end >= start) {
        val middle = start + (end - start) / 2
        if (target >= arr[middle]) {
            elementIndex = middle + 1
            start = middle + 1
        } else {
            end = middle - 1
        }
    }

    // Or just use start index
    return  elementIndex % arr.size
}
```
