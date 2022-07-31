// I had it in Booking.com
// Question 1 : Meandering array
// 
// An array of integers is defined as being meandering order when the first two elements are the respective largest and smallest elements in the array and the subsequent elements alternate between its next largest and next smallest elements. In other words, the elements are in order of [first_largest, first_smallest, second_largest, second_smallest.....]
// 
// Example:
// The array [-1, 1, 2, 3, -5] sorted normally is [-5, -1, 1, 2, 3].
// Sorted in meandering order, it becomes [3, -5, 2, -1, 1]

// Constraints:
// 2 <= n <= 10^4
// -10^6 <= unsorted[i] <= 10^6
// The unsorted array may contain duplicate elements

// S: O(n)
// T: O(nlogn)
fun meanderingArray(unsorted: Array<Int>): Array<Int> {
    // Write your code here
    // a) Use two priority queue - one for biggest numbers, second one for largest
    // b) 1. Sort the array (nlogn) + iterate over array with two pointers
    Arrays.sort(unsorted)

    val result = Array(unsorted.size) { 0 }
    var leftPointer = 0
    var rightPointer = unsorted.size - 1
    var addingIdx = 0
    while (rightPointer >= leftPointer) {
        if (rightPointer == leftPointer) {
            result[addingIdx++] = unsorted[leftPointer]
        } else {
            result[addingIdx++] = unsorted[rightPointer]
            result[addingIdx++] = unsorted[leftPointer]
        }

        rightPointer--
        leftPointer++
    }

    return result
}
