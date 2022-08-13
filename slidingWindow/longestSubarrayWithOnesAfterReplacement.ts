// Given an array containing 0s and 1s, if you are allowed to
// replace no more than ‘k’ 0s with 1s, find the length of
// the longest contiguous subarray having all 1s.

// T: O(n)
// S: O(1)
function findLength(arr: (0 | 1)[], k: number): number {
   let startIdx = 0
   let numberOfZeros = 0
   let longest = 0

   for (let endIdx = 0; endIdx < arr.length; endIdx++) {
      const currentEnd = arr[endIdx]
      if (currentEnd === 0) {
         numberOfZeros += 1
      }

      while (numberOfZeros > k) {
         const currentStart = arr[startIdx]
         if (currentStart == 0) {
            numberOfZeros--
         }

         startIdx++
      }

      longest = Math.max(longest, endIdx - startIdx + 1)
   }

   return longest
}

const result = findLength([0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], 2)
console.log(result === 6)

const result2 = findLength([0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], 3)
console.log(result2 === 9)
