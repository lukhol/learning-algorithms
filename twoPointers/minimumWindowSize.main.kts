// NOT WORKING YET
#!/usr/bin/env kotlin

// Given an array, find the length of the smallest subarray
// in it which when sorted will sort the whole array.

//
fun sort(arr: List<Int>): Int {
    var leftPointer = 0
    var rightPointer = arr.lastIndex

    while (arr[leftPointer + 1] >= arr[leftPointer]) {
        leftPointer++
        if (leftPointer == arr.lastIndex) {
            return 0
        }
    }

    while(arr[rightPointer] >= arr[rightPointer - 1]) {
        rightPointer--
        if (rightPointer == 0) {
            return 0
        }
    }

    return rightPointer - leftPointer + 1
}

println(sort(listOf(1, 2, 5, 3, 7, 10, 9, 12)) == 5)
println(sort(listOf(1, 3, 2, 0, -1, 7, 10)) == 5)
println(sort(listOf(1, 2, 3)) == 0)
println(sort(listOf(3, 2, 1)) == 3)
