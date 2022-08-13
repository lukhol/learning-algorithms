// Given a string with lowercase letters only, if you are allowed
// to replace no more than ‘k’ letters with any letter, find the length
// of the longest substring having the same letters after replacement.

// S: O(k)
// T: O(kn)
function findLength(str: string, k: number): number {
   let startIdx = 0
   const map: Record<string, number> = {};
   let max = 0

   function sum(idx: number) {
      return Object.keys(map).reduce((prev, curr) => {
         if (curr === str[idx]) return prev
         return prev + map[curr];
      }, 0);
   }

   for (let endIdx = 0; endIdx < str.length; endIdx++) {
      const endLetter = str[endIdx]
      map[endLetter] = map[endLetter] ? map[endLetter] + 1 : 1

      while(sum(startIdx) > k) {
         delete map[str[startIdx]]
         startIdx++
      }

      max = Math.max(
          max,
          Object.keys(map).reduce((prev, curr) => prev + map[curr], 0)
      );
   }

   return max
}

const result = findLength("aabccbb", 2)
console.log(result === 5)

const result2 = findLength("abbcb", 1)
console.log(result2 === 4)

const result3 = findLength("abccde", 1)
console.log(result3 === 3)
