## Modified Binary Search

### Description
Binary search is an algorithm from 'divide and conquer` family. It's space complexity is O(1) and time complexity is O(logn) which is the fasters algorithm other than O(1). Input data has to be ordered in any direction (asc or desc) for this algorithm to work properly.

- `start + (end - start) / 2` comparing to `(start+end) / 2` prevents overflow.

### Template

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
