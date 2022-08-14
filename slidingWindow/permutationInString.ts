// Given a string and a pattern, find out if the string contains
// any permutation of the pattern.
//
// Permutation is defined as the re-arranging of the characters
// of the string. For example, “abc” has the following six permutations:
//
// abc
// acb
// bac
// bca
// cab
// cba
//
// If a string has ‘n’ distinct characters it will have n!n! permutations.

// S: O(k) where k is number of distinct characters in pattern
// T: O(n) where n is length of input string
function findPermutation(str: String, pattern: String): boolean {
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

   let startIdx = 0;
   let length = 0;
   for (let endIdx = 0; endIdx < str.length; endIdx++) {
      const currentLetterCount = patternLetters[str[endIdx]];
      if (currentLetterCount && currentLetterCount > 0) {
         patternLetters[str[endIdx]] -= 1;
         length++
      } else {
         while(startIdx !== endIdx) {
            patternLetters[str[startIdx]] += 1;
            startIdx++
         }

         startIdx++
         length = 0
      }

      if (length === pattern.length) {
         return true
      }
   }

   return length == pattern.length
}

const result = findPermutation("oidbcaf", "abc")
console.log(result === true)

const result2 = findPermutation("odicf", "dc")
console.log(result2 === false)

const result3 = findPermutation("bcdxabcdy", "bcdyabcdx")
console.log(result3 === true)

const result4 = findPermutation("aaacb", "abc")
console.log(result4 === true)
