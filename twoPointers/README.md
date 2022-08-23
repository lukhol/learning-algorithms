#### Description
Two pointers is a technique in which we are using two pointers to traverse the array in different speed / from different side. Some classic examples are:
1. One slow-runner and other fast-runner (it's more fast and slow pointer but it is still using two pointers)
2. One pointer starts from the beginning while the other pointer starts from the end. They move towards each other until they both meet.
3. Binary search use some form of two pointers - we have leftPointer, rightPointer and middlePointer

Two pointers can be used for:
- searching pairs in array
- palindrom check
- reverse words in string
- pair/triplet/quarduplet sum/product
- cycle detection in linked list
- maximum sliding window
- longest string without repeating characters


 
#### Template
```kotlin
fun twoPointers<T>(arr: List<T>, target: T) {
  var leftPointer = 0
  var rightPointer = arr.lastIndex
  var middlePointer = arr.size / 2 // Sometimes we need middle pointer that can be moved in one of two direction
  
  while (rightPointer > leftPointer) {
    val someCondition = false // Any condition
    val otherCondition = false // Any condition
    
    // A) Move pointers by 1
    if (someCondition) {
      // do something
      // 1. We can move both pointers
      // 2. We can finish and return here
      leftPointer++
      rightPointer--
    } else if (otherCondition) {
      // Or only one of the pointers
      leftPointer++
    } else {
      // Or only one of the pointers
      rightPointer++
    }
    
    // B) Move pointers for more than 1
    while (leftPointer <= arr.lastIndex && arr[leftPointer] > target) {
      leftPointer++
    }
  }
}
```
