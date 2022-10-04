## Modified Binary Search

### Description
Binary search is an algorithm from 'divide and conquer` family. It's space complexity is O(1) and time complexity is O(logn) which is the fasters algorithm other than O(1). Input data has to be ordered in any direction (asc or desc) for this algorithm to work properly.

- `start + (end - start) / 2` comparing to `(start+end) / 2` prevents overflow.
- sometimes it's useful to do binary search twice and then combine the results - for example when searching ranges
- when array is shifted then it's usefull to check which part - left or right is properly 
- when array is a mountain array then it's usefull to just check in which direction values are increasing
- most of the questions that need to search for some value in sorted array can be solved in O(logn) time using binary search
- in one of the steps (when choosing left or right) we can do `start = middle` or `end = middle` (without +/- 1) but in such case we need to remove equality from while loop condition to avoid infinite loop. Also additional check for single element array is needed.

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
