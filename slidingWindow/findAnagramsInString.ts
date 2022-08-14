// Given a string and a pattern, find all anagrams of the pattern in the given string.
//
// Anagram is actually a Permutation of a string. For example, “abc” has the following six anagrams:
//
// abc
// acb
// bac
// bca
// cab
// cba
// Write a function to return a list of starting indices of the anagrams of the pattern in the given string.

function findAnagramsInString(str: string, pattern: string): number[] {
   const charactersInPattern: Record<string, number> = pattern
       .split('')
       .reduce((prev: Record<string, number>, curr) => {
          if (prev[curr]) {
             prev[curr] += 1
          } else {
             prev[curr] = 1
          }
          return prev;
       }, {});

   const anagramIndexes = [];
   let startIdx = 0;
   let length = 0;

   for (let endIdx = 0; endIdx < str.length; endIdx++) {
      const endChar = str[endIdx];
      if (endChar in charactersInPattern) {
         charactersInPattern[endChar] -= 1;
         if (charactersInPattern[endChar] >= 0) {
            length++
         }
      }

      console.log(JSON.stringify({ startIdx, endIdx, length, charactersInPattern }))

      if (length === pattern.length) {
         anagramIndexes.push(startIdx);
      }

      if (endIdx >= pattern.length - 1) {
         const startChar = str[startIdx];
         if (startChar in charactersInPattern) {
            charactersInPattern[startChar] += 1
            if (charactersInPattern[startChar] > 0) {
               length--
            }
         }

         startIdx++
      }
   }

   console.log(anagramIndexes)
   return anagramIndexes;
}

const result = findAnagramsInString("ppqp", "pq");
console.log(result[0] === 1 && result[1] === 2);

const result2 = findAnagramsInString("abbcabc", "abc");
console.log(result2[0] === 2 && result2[1] === 3 && result2[2] === 4);


