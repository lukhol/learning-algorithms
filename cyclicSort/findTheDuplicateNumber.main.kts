#!/usr/bin/envkotlin kotlin

// We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’.
// The array has only one duplicate but it can be repeated multiple times. 
// Find that duplicate number without using any extra space. You are, however,
// allowed to modify the input array.
fun main() {
    fun findNumber(arr: MutableList<Int>): Int {
        return -1
    }
    
    println(findNumber(arrayListOf(1, 4, 4, 3, 2)) == 4)
    println(findNumber(arrayListOf(2, 1, 3, 3, 5, 4)) == 3)
    println(findNumber(arrayListOf(2, 4, 1, 4, 4)) == 4)
}

main()
