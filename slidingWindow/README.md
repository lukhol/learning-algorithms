1. Window can be of fixed length or variable length
2. For most problems it's enough to iterate over an array with `endIndex` variable using for loop. `startIndex` variable can be increased/decreased manually. By moving `startIndex` sliding window can be
   * shrinked - incrementing startIdx
   * stay fixed - do not touch startIdx
   * expanded - decrease startIdx
   Generally `startIdx` can be changed using while loop with proper condition
3. Some problems require 
   * using a Map for counting occurences of letters/values/words.
   * using counter of occurrences
   * using lenght variable

```kotlin
fun slidingWindow(input: List<Int>, someInput: String) {
    var startIdx = 0
    var mapping: Map<Any, Int> = someInput
        .split("")
        .groupingBy { it }
        .eachCount() // Any can be replaced by word/letter/number and map to number of occurrences

    // or
    var length = 0
    // or
    var longest = 0 // or max
    // or
    var count = 0

    // Main for loop iterate with endIndex
    for (endIdx in input.indices) {

        // a) startIdx is typically moved using inner while loop
        while(someCondition) {
            startIdx++
            // or
            startIdx--
        }

        // b) startIdx can be also moved just once on some condition
        if (someCondition) {
            startIdx++
            // or
            startIdx--
        }
    }
}

```
