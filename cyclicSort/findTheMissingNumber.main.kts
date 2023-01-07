#!/usr/bin/envkotlin kotlin

// We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
// Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
fun main() {
    // S: O(1)
    // T: O(n)
     fun missingNumber(arr: MutableList<Int>): Int {
        if (arr.isEmpty()) return -1
        for (idx in 0 .. arr.lastIndex) {
            
            var prev: Int? = null
            while (arr[idx] != idx) {
                val atThisIndex = arr[idx]
                if (prev != null && prev == atThisIndex) { 
                    break 
                }

                // There is a number bigger than lastIndex - in such case we will pick last one
                val next = arr[Math.min(atThisIndex, arr.lastIndex)] 

                // I need to keep track of previous element to prevent infinite loop
                if (prev != null && prev == next) { 
                    break 
                }
                arr[Math.min(atThisIndex, arr.lastIndex)] = atThisIndex 
                arr[idx] = next 
                prev = atThisIndex
            }
        }

        for (idx in 0 .. arr.lastIndex) {
            if (idx != arr[idx]) return idx
        }

        return arr.size
    }

    println(findTheMissingNumber(arrayListOf(4, 0, 3, 1)) == 2)
    println(findTheMissingNumber(arrayListOf(8, 3, 5, 2, 4, 6, 0, 1)) == 7)
}

main()

// Alternatively a lot simple approach:
// S: O(1)
// T: O(n)
fun findTheMissingNumber(arr: MutableList<Int>): Int {
    var idx = 0
    // Put all numbres on it's places skipping when index is out of range
    while (arr.size > idx) {
        if (arr[idx] != arr.size && arr[idx] != idx) {
            swap(arr, idx, arr[idx])
        } else {
            idx++
        }
    }

    // Find number that is not placed correctly
    var missingNumber = 0
    while (arr.size > missingNumber) {
        if (arr[missingNumber] != missingNumber) return missingNumber
        missingNumber++
    }

    // If didn't find then return missingNumber because it's just arr.size
    return missingNumber
}

 fun swap(arr: IntArray, a: Int, b: Int) {
    val tmp = arr[a]
    arr[a] = arr[b]
    arr[b] = tmp
}
