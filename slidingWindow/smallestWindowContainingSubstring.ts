// Given a string and a pattern, find the smallest substring in
// the given string which has all the characters of the given pattern.

// S: O(k) where k is number of distinct characters in pattern
// T: O(n)
function smallestWindowContainingSubstring(str: string, pattern: string): string {
   const patternLetters: Record<string, number> = pattern
       .split('')
       .reduce((prev: Record<string, number>, curr: string) => {
          if (prev[curr]) {
             prev[curr] += 1
          } else {
             prev[curr] = 1
          }
          return prev;
       }, {});

   let startIdx = 0
   let foundCount = 0
   let result = ""

   for (let endIdx = 0; endIdx < str.length; endIdx++) {
      const endChar = str[endIdx];
      if (endChar in patternLetters) {
         patternLetters[endChar] -= 1
         if (patternLetters[endChar] >= 0) {
            foundCount += 1
         }
      }

      while (foundCount === pattern.length) {
         const potentialResult = str.substring(startIdx, endIdx + 1);
         if (potentialResult.length < result.length || result === "") {
            result = potentialResult
         }
         const startLetter = str[startIdx]
         if (startLetter in patternLetters) {
            patternLetters[startLetter] += 1
            if (patternLetters[startLetter] > 0) {
               foundCount--
            }
         }
         startIdx++
      }
   }

   return result
}

console.log(smallestWindowContainingSubstring("aabdec", "abc") === "abdec");
console.log(smallestWindowContainingSubstring("abdabca", "abc") === "abc");
console.log(smallestWindowContainingSubstring("adcad", "abc") === "");
