# Data Structures and Algorithms 

This repo contains common algorithms problems and my solutions to those problems.

## Table of Contents For 401

1. [Reverse an Array](#reverse-an-array)
2. [Array Insert and Shift](#array-insert-and-shift)

### Reverse an Array

#### Problem Statement

Write a function which takes an array as argument. Without utilizing any of the built-in methods, return an array with elements in reversed order.

#### Approach & Efficiency 

Create another array and loop through the input array starting from the last index to the first index and insert each elements values in the newly created array starting from the first index to the last. Both time and space complexities for this is O(n). 

Another way would be to have two pointers that reference the first and last index initially. Using a while loop, for every iteration, swap the elements between the two pointers and increment the pointer at the beginning of the array and decrement the pointer at the end of the array by one. The while loop stops when the beginning index is larger than the end index which is when the two pointer intersect one another. Time complexity would essentially be halves compared to the first method and the space complexity would be O(1).

#### Solution 

[Reverse Array Code Solution](https://github.com/TheQuangNguyen/data-structures-and-algorithms/blob/master/code401challenges/src/main/java/code401challenges/ArrayReverse.java)

![alt text](/assets/array-reverse.png)




### Array Insert and Shift

#### Problem Statement

Write a function called insertShiftArray which takes in an array and the value to be added. Without utilizing any of the built-in methods available to your language, return an array with the new value added at the middle index.

(Stretch Goal) Write a second function that removes an element from the middle index and shifts other elements in the array to fill the new gap.

#### Approach & Efficiency

For the insertion, first create a new array of the length of input array plus one. Then calculate the middle index by dividing the length of the new array by 2 and save it as an int since if the new array is an odd number, the middle index would be truncated. Then use a for loop that goes from 0 to the length of the new array in increment of one. For each iteration, checks if the counter for the loop equals the middle index calculated earlier. If it is not, then insert the values of input array to the shift array. If it is, then insert the input value to the new array. Time complexity would be O(n) since we copying every single values of input array to the new array plus one and space complexity would be O(n) also since we create a new array of length of input array plus one. 

For the removal, it is very similar to the insertion with a few lines different. First checks if the input array is empty or not. This is because later on, a new array will be created that has the length of the input array minus one. If the input array has length of zero, then minus one of that would lead to an error. If the input array is empty, then immediately return an empty array. If not, then create a new array of length of the input array minus one. Calculate the middle index now by dividing the input array length by 2 instead of dividing the new array length by 2. Then use a for loop that goes from 0 to the input array length and for each iteration, checks if the counter is equal to the middle index or not. If it is, then continue to the next iteration thus skipping the insertion of the middle value to the new array. If not, then insert the values from the input array to the new array. Time complexity and space complexity would be the approximately the same as insertion.

#### Solution 

[Array Shift Code Solution](https://github.com/TheQuangNguyen/data-structures-and-algorithms/blob/master/code401challenges/src/main/java/code401challenges/ArrayShift.java)

![alt text](/assets/array-shift.png)