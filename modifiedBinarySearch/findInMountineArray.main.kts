// https://leetcode.com/problems/find-in-mountain-array/

// Given a Bitonic array, find if a given 'key' is present in it. An array is considered bitonic if it is
// monotonically increasing and then monotonically decreasing. Monotonically increasing or decreasing means
// that for any index i in the array arr[i] != arr[i+1].
//
// Write a function to return the index of the 'key'. If the 'key' is not present, return -1.

class MountainArray(private val arr: IntArray) {
    fun get(index: Int): Int = arr[index]
    fun length(): Int = arr.size
}

class Solution {
    fun findInMountainArray(target: Int, mountainArr: MountainArray): Int {
        fun findIndexOfBiggestElement(): Int {
            var start = 0
            var end = mountainArr.length() - 1
            var maxValueIdx = -1
            var maxValue = Int.MIN_VALUE
            while (end >= start) {
                val mid = start + (end - start) / 2
                if (mid + 1 == mountainArr.length() || mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                    start = mid + 1
                } else {
                    end = mid - 1
                }

                if (mountainArr.get(mid) > maxValue) {
                    maxValue = mountainArr.get(mid)
                    maxValueIdx = mid
                }
            }

            return maxValueIdx
        }

        fun binarySearch(initialStart: Int, initialEnd: Int, increasing: Boolean = true): Int {
            var start = initialStart
            var end = initialEnd
            while (end >= start) {
                val mid = start + (end - start) / 2
                if (increasing) {
                    if (target == mountainArr.get(mid)) {
                        return mid
                    } else if (target > mountainArr.get(mid)) {
                        start = mid + 1
                    } else {
                        end = mid -1
                    }
                } else {
                    if (target == mountainArr.get(mid)) {
                        return mid
                    } else if (target > mountainArr.get(mid)) {
                        end = mid - 1
                    } else {
                        start = mid + 1
                    }
                }
            }

            return -1
        }

        val maxIdx = findIndexOfBiggestElement()
        val firstPartIdx = binarySearch(0, maxIdx)
        if (firstPartIdx != -1) return firstPartIdx
        return binarySearch(maxIdx, mountainArr.length() - 1, false)
    }
}

fun main() {
    println(Solution().findInMountainArray(3, MountainArray(intArrayOf(1,2,3,4,5,3,1))) == 2)
    println(Solution().findInMountainArray(3, MountainArray(intArrayOf(0,1,2,4,2,1))) == -1)
    println(Solution().findInMountainArray(12, MountainArray(intArrayOf(1,3,8,12))) == 3)
    println(Solution().findInMountainArray(10, MountainArray(intArrayOf(10, 9, 8))) == 0)
    println(Solution().findInMountainArray(2, MountainArray(intArrayOf(1, 5, 2))) == 2)
}
