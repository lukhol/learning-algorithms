### Cyclic sort

All the questions where we need to find the repeating numbers, or missing numbers can easily be solved with the help of a pattern that is cyclic sort. In this pattern we simply place the elements of the array on their positions (or at least try to), like 1 should be at 1st position and 2 at the second position, and then we iterate again and check if for any index we have an element whose value is not equal to index + 1, then that is the missing number.
