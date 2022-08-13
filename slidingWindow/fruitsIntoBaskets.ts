// Run with npx ts-node fruitsIntoBaskets.ts

function fruitsIntoBaskets(fruits: string[]): number {
   let startIdx = 0;
   const baskets: { [key: string]: number} = {};

   for (let endIdx = 0; endIdx < fruits.length; endIdx++) {
      const endFruit = fruits[endIdx]
      baskets[endFruit] = baskets[endFruit] ? baskets[endFruit] + 1 : 1;

      while(Object.keys(baskets).length > 2) {
         const fruit = fruits[startIdx]
         baskets[fruit] = baskets[fruit] ? baskets[fruit] - 1 : 0;
         if (baskets[fruit] == 0) {
            delete baskets[fruit]
         }
         startIdx++
      }
   }

   return Object.keys(baskets).reduce((acc: number, next: string) => acc + baskets[next], 0)
}

const result = fruitsIntoBaskets(['A', 'B', 'C', 'A', 'C'])
console.log(result === 3)

const result2 = fruitsIntoBaskets(['A', 'B', 'C', 'B', 'B', 'C'])
console.log(result2 === 5)
