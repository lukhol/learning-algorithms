#!/usr/bin/envkotlin kotlin

// We are given an array containing ‘n’ objects. Each object, when created, was assigned a unique 
// number from 1 to ‘n’ based on their creation sequence. This means that the object with sequence
//  number ‘3’ was created just before the object with sequence number ‘4’.

// Write a function to sort the objects in-place on their creation sequence number in O(n)O(n) and
//  without any extra space. For simplicity, let’s assume we are passed an integer array containing 
//  only the sequence numbers, though each number is actually an object.

fun main() {
    fun cyclicSort(arr: MutableList<Int>): List<Int> {
        var idx = 0
        while (idx != arr.size) {
            if (arr[idx] != idx + 1) {
                val tmp = arr[idx]
                arr[idx] = arr[tmp - 1]
                arr[tmp - 1] = tmp
            } else {
                idx++
            }
        }
        return arr
    }
    
    println(cyclicSort(arrayListOf(3, 1, 5, 4, 2)) == listOf(1, 2, 3, 4, 5))
    println(cyclicSort(arrayListOf(2, 6, 4, 3, 1, 5)) == listOf(1, 2, 3, 4, 5, 6))
    println(cyclicSort(arrayListOf(1, 5, 6, 4, 3, 2)) == listOf(1, 2, 3, 4, 5, 6))
}

main()
