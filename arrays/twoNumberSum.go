func twoSum(nums []int, target int) []int {
    var valueToIndex = make(map[int]int)
    for idx, value := range nums {
        valueToIndex[value] = idx
    }

    for idx, value := range nums {
        var missingValue = target - value
        fromMap, ok := valueToIndex[missingValue]
        if ok && fromMap != idx {
            return []int { idx, fromMap }
        }
    }

    return []int {}
}
