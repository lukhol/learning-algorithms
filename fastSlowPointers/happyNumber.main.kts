#!/usr/bin/env kotlin

// Any number will be called a happy number if, after repeatedly replacing it with a number
// equal to the sum of the square of all of its digits, leads us to number ‘1’.
// All other (not-happy) numbers will never reach ‘1’. Instead, they will be stuck in a
// cycle of numbers which does not include ‘1’.

fun isHappyNumber(num: Int): Boolean {
    fun findSquareSum(toSquare: Int): Int {
        var innerToSquare = toSquare
        var sum = 0
        var digit: Int

        while (innerToSquare > 0) {
            digit = innerToSquare % 10
            sum += digit * digit
            innerToSquare /= 10
        }

        return sum
    }

    // Imo more obvious approach but require O(n) space
    //    var innerNum = num
    //    val seen = hashSetOf(innerNum)
    //    while (innerNum != 1) {
    //        innerNum = findSquareSum(innerNum)
    //        if (!seen.add(innerNum)) return false
    //    }

    var slow = num
    var fast = num
    do {
        slow = findSquareSum(slow)
        fast = findSquareSum(findSquareSum(fast))
    } while (slow != fast)

    return slow == 1
}

println(isHappyNumber(23))
println(!isHappyNumber(12))
