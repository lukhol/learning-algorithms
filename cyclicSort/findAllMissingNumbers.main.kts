#!/usr/bin/envkotlin kotlin
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

// We are given an unsorted array containing numbers taken from the range 1 to ‘n’.
// The array can have duplicates, which means some numbers will be missing.
// Find all those missing numbers.
fun main() {
    fun findAllMissingNumbers(arr: MutableList<Int>): List<Int> {
	val result = arrayListOf<Int>()
        var idx = 0
        while (idx != arr.size) {
            if (arr[idx] != arr[arr[idx] - 1]) {
                swap(arr, arr[idx] - 1, idx)
            } else { 
            	idx++
            }
        }
        
        for (idx in arr.indices) {
           val item = arr[idx]
           if (item != idx + 1) {
               result.add(idx + 1)
           }
        }
        
        return result
    }
    
    
    println(findAllMissingNumbers(arrayListOf(2, 3, 1, 8, 2, 3, 5, 1)) == arrayListOf(4, 6, 7))
    println(findAllMissingNumbers(arrayListOf(2, 4, 1, 2)) == arrayListOf(3))
    println(findAllMissingNumbers(arrayListOf(2, 3, 2, 1)) == arrayListOf(4))
}

main()
