// https://leetcode.com/problems/peak-index-in-a-mountain-array/submissions/813804308/

// Find the maximum value in a given Bitonic array. An array is considered bitonic if it is
// monotonically increasing and then monotonically decreasing. Monotonically increasing or 
// decreasing means that for any index i in the array arr[i] != arr[i+1].

class Solution {
    fun peakIndexInMountainArray(arr: IntArray): Int {
        var start = 0
        var end = arr.lastIndex

        var max = -1
        var maxIdx = -1

        while (end >= start) {
            val mid = start + (end - start) / 2
            if (arr[mid + 1] > arr[mid]) {
                start = mid + 1
            } else {
                end = mid - 1
            }

            if (arr[mid] > max) {
                max = arr[mid]
                maxIdx = mid
            }
        }

        return maxIdx
    }
}

fun main() {
  println(Solution().peakIndexInMountainArray(intArrayOf(0,1,0)) == 1)
  println(Solution().peakIndexInMountainArray(intArrayOf(0,2,1,0)) == 1)
  println(Solution().peakIndexInMountainArray(intArrayOf(0,10,5,2)) == 1)
  println(Solution().peakIndexInMountainArray(intArrayOf(24,69,100,99,79,78,67,36,26,19)) == 2)
}

main()
