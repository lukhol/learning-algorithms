### Merge intervals template
1. `a` and `b` can overlap in 6 different way 

![Types of overlapping intervals](https://cdn.emre.me/2019-10-27-merge-intervals.png)

2. To check if `a` and `b` overlaps we have to check if `aStart` is between `bStart` and `bEnd` OR `bStart` is between `aStart` and `aEnd`.
3. Most problem can be solved by sorting intervals by start time - merge interval, find overlapping intervals, do intervals overlaps, find number od overlapping intervals
4. Sorting by start time eliminates 3 of of 6 cases 
5. Some tasks can can be solved using mean heap - TODO
