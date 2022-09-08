#!/usr/bin/envkotlin kotlin

// We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
// Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
fun main() {
    // S: O(1)
    // T: O(n)
    fun findTheMissingNumber(arr: MutableList<Int>): Int {
        if (arr.isEmpty()) return -1
        var idx = 0
        var startedFrom = arr.first()
        while (idx != arr.size) {
            println("$arr, started from: $startedFrom, idx: $idx")
            if (arr[idx] != idx) {
                val tmp = arr[idx]
                val tmpIdx = Math.min(tmp, arr.lastIndex)

                arr[idx] = arr[tmpIdx]
                arr[tmpIdx] = tmp

                if (arr[idx] == idx) {
                    idx++
                    startedFrom = arr[Math.min(idx, arr.lastIndex)]
                } else if(startedFrom == arr[idx]) {
                    return idx
                }
            } else {
                idx++
                startedFrom = arr[Math.min(idx, arr.lastIndex)]
            }
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
