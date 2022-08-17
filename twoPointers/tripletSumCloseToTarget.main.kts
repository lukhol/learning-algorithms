// Given an array of unsorted numbers and a target number, find a triplet in the array
// whose sum is as close to the target number as possible, return the sum of the triplet.
// If there are more than one such triplet, return the sum of the triplet with the smallest sum.

// S: O(1)
// T: O(n logn) + O(n^2) = O(n^2)
fun searchTriplet(arr: List<Int>, targetSum: Int): Int {
    var smallestTripletSumDistance = Int.MAX_VALUE
    var smallestTripletSum = Int.MAX_VALUE
    val sorted = arr.sorted()

    for (idx in 0 .. sorted.size - 3) {
        val currentValue = sorted[idx]
        var leftIdx = idx + 1
        var rightIdx = sorted.lastIndex

        while (rightIdx > leftIdx) {
            val left = sorted[leftIdx]
            val right = sorted[rightIdx]

            val currentSum = currentValue + left + right
            val currentDistance = Math.abs(targetSum - currentSum)

            if (smallestTripletSumDistance > currentDistance) {
                smallestTripletSumDistance = currentDistance
                smallestTripletSum = currentSum
            } else if (smallestTripletSumDistance == currentDistance) {
                smallestTripletSumDistance = currentDistance
                smallestTripletSum = Math.min(currentSum, smallestTripletSum)
            }

            if (currentSum > targetSum) {
                rightIdx--
            } else {
                leftIdx++
            }
        }
    }

    return smallestTripletSum
}

val result = searchTriplet(arrayListOf(-2, 0, 1, 2), 2)
println(result == 1)

val result2 = searchTriplet(arrayListOf(-3, -1, 1, 2), 1)
println(result2 == 0)

val result3 = searchTriplet(arrayListOf(1, 0, 1, 1), 100)
println(result3 == 3)
