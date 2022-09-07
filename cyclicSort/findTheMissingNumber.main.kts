// #!/usr/bin/envkotlin kotlin

// We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
// Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
fun main() {
    // n = 2, eg. [2,1]
    // 0,1,2
    //
    fun findTheMissingNumber(arr: MutableList<Int>): Int {
        if (arr.isEmpty()) return -1
        var idx = 0
        var startedFrom = arr.first()
        while (idx != arr.size) {
            println("$arr, started from: $startedFrom, idx: $idx")
            if (arr[idx] != idx) {
                val tmp = arr[idx]
                val tmpIdx = Math.min(tmp, arr.lastIndex)

                arr[idx] = arr[tmpIdx]
                arr[tmpIdx] = tmp

                if (arr[idx] == idx) {
                    idx++
                    startedFrom = arr[Math.min(idx, arr.lastIndex)]
                } else if(startedFrom == arr[idx]) {
                    return idx
                }
            } else {
                idx++
                startedFrom = arr[Math.min(idx, arr.lastIndex)]
            }
        }

        return arr.size
    }

    println(findTheMissingNumber(arrayListOf(4, 0, 3, 1)) == 2)
    println(findTheMissingNumber(arrayListOf(8, 3, 5, 2, 4, 6, 0, 1)) == 7)
}

main()
