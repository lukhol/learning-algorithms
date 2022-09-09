#!/usr/bin/envkotlin kotlin

// We are given an unsorted array containing numbers taken from the range 1 to ‘n’.
// The array can have duplicates, which means some numbers will be missing.
// Find all those missing numbers.
fun main() {
    fun findDuplicatedNumber(arr: List<Int>): List<Int> {
        // TODO
        return arr
    }
    
    
    println(findDuplicatedNumber(arrayListOf(2, 3, 1, 8, 2, 3, 5, 1)) == arrayListOf(4, 6, 7))
    println(findDuplicatedNumber(arrayListOf(2, 4, 1, 2)) == arrayListOf(3))
    println(findDuplicatedNumber(arrayListOf(2, 3, 2, 1)) == arrayListOf(4))
}

main()
