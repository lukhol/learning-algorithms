func search(nums []int, target int) int {
    var start = 0
    var end = len(nums) - 1
    var middle = (start + end) / 2

    for end >= start {
        middle = (start + end) / 2
        if target > nums[middle] {
            start = middle + 1
        } else if target < nums[middle] {
            end = middle - 1
        } else {
            return middle
        }
    }

    return -1
}
