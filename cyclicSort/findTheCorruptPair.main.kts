#!/usr/bin/envkotlin kotlin

// We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
// The array originally contained all the numbers from 1 to ‘n’, but due to a data error, 
// one of the numbers got duplicated which also resulted in one number going missing. Find both these numbers.

fun main() {
  fun findNumbers(arr: MutableList<Int>): List<Int> {
    // TODO
    return emptyList()
  }
  
  println(findNumbers(arrayListOf(3, 1, 2, 5, 2)) == listOf(3, 4))
  println(findNumbers(arrayListOf(3, 1, 2, 3, 6, 4)) == listOf(3, 5))
}

main()
