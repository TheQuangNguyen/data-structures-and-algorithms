# Data Structures and Algorithms 

This repo contains common algorithms problems and my solutions to those problems.

## Table of Contents For 401

1. [Reverse an Array](#reverse-an-array)
2. [Array Insert and Shift](#array-insert-and-shift)
3. [Binary Search](#binary-search)
4. [Linked List Implementation](#linked-list-implementation)

## Reverse an Array

### Problem Statement

Write a function which takes an array as argument. Without utilizing any of the built-in methods, return an array with elements in reversed order.

### Approach & Efficiency 

Create another array and loop through the input array starting from the last index to the first index and insert each elements values in the newly created array starting from the first index to the last. Both time and space complexities for this is O(n). 

Another way would be to have two pointers that reference the first and last index initially. Using a while loop, for every iteration, swap the elements between the two pointers and increment the pointer at the beginning of the array and decrement the pointer at the end of the array by one. The while loop stops when the beginning index is larger than the end index which is when the two pointer intersect one another. Time complexity would essentially be halves compared to the first method and the space complexity would be O(1).

### Solution 

[Reverse Array Code Solution](https://github.com/TheQuangNguyen/data-structures-and-algorithms/blob/master/code401challenges/src/main/java/code401challenges/ArrayReverse.java)

![alt text](/assets/array-reverse.png)

## Array Insert and Shift

### Problem Statement

Write a function called insertShiftArray which takes in an array and the value to be added. Without utilizing any of the built-in methods available to your language, return an array with the new value added at the middle index.

(Stretch Goal) Write a second function that removes an element from the middle index and shifts other elements in the array to fill the new gap.

### Approach & Efficiency

For the insertion, first create a new array of the length of input array plus one. Then calculate the middle index by dividing the length of the new array by 2 and save it as an int since if the new array is an odd number, the middle index would be truncated. Then use a for loop that goes from 0 to the length of the new array in increment of one. For each iteration, checks if the counter for the loop equals the middle index calculated earlier. If it is not, then insert the values of input array to the shift array. If it is, then insert the input value to the new array. Time complexity would be O(n) since we copying every single values of input array to the new array plus one and space complexity would be O(n) also since we create a new array of length of input array plus one. 

For the removal, it is very similar to the insertion with a few lines different. First checks if the input array is empty or not. This is because later on, a new array will be created that has the length of the input array minus one. If the input array has length of zero, then minus one of that would lead to an error. If the input array is empty, then immediately return an empty array. If not, then create a new array of length of the input array minus one. Calculate the middle index now by dividing the input array length by 2 instead of dividing the new array length by 2. Then use a for loop that goes from 0 to the input array length and for each iteration, checks if the counter is equal to the middle index or not. If it is, then continue to the next iteration thus skipping the insertion of the middle value to the new array. If not, then insert the values from the input array to the new array. Time complexity and space complexity would be the approximately the same as insertion.

### Solution 

[Array Shift Code Solution](https://github.com/TheQuangNguyen/data-structures-and-algorithms/blob/master/code401challenges/src/main/java/code401challenges/ArrayShift.java)

![alt text](/assets/array-shift.png)

## Binary Search

### Problem Statement

Write a function called BinarySearch which takes in 2 parameters: a sorted array and the search key. Without utilizing any of the built-in methods available to your language, return the index of the array’s element that is equal to the search key, or -1 if the element does not exist.

### Approach & Efficiency

Binary Search is an algorithm that used to search for a certain element within a sorted array. The main aspect of binary search is that we cut in half the section of the array that we are conducting the search to help significantly sorten the amount of compares that we have to do as opposed to a linear search. To do a binary search, we needs to define our lower and upper bounds which represent where we going to do our search within. In the very beginning, our lower bound would be the zeroth index and upper bound would be the array length minus one. Then we would calculate our mid index between the two bounds by taking the average between them. Using this mid index, we would then check if the element at the mid index is equal to the key that we are trying to search. If it is great we would just return the mid index. If not, then we would check if the key is either greater than or less than the element at the mid index. If greater than, move the lower bound to be mid + 1 and if less than, move the upper bound to be mid - 1. We do this because since we know that this array is sorted, if the key is greater than the mid element, we know that it cannot possibly be to the left of the mid so we effectively get rids of the left half and move our bounds so that we are now only searching at the right half and vice versa. We keep doing this until we either find the key in which we would return the mid index at that point, or if we exhausted our search in which we return -1. 

Binary search can be coded with a while loop or with recursion. Both methods are shown in the solution. 

The time complexity of binary search is O(log(n)) because we cut in half each time the amount of things that we need to search. Space complexity would be O(1).

### Solution 

[Binary Search Code Solution](https://github.com/TheQuangNguyen/data-structures-and-algorithms/blob/master/code401challenges/src/main/java/code401challenges/BinarySearch.java)

![alt text](/assets/binary-search.png)

## Linked List Implementation
This is my own implementation of a singly and doubly linked list. Singly linked list is when each node has the location of the next node in the list. The linked list itself only has information on where the head is. Doubly linked list is when each node has the location of the next node and also the previous node. The linked list itself has information on both the head of the list as well as the tail. 

### Challenge
The implementation of the linked list needs to have the following:
* Define a method called **insert** which takes any value as an argument and adds a new node with that value to the head of the list with an O(1) Time performance.
* Define a method called **includes** which takes any value as an argument and returns a boolean result depending on whether that value exists as a Node’s value somewhere within the list.
* Define a method called **toString** which takes in no arguments and returns a string representing all the values in the Linked List.

### Approach & Efficiency
The approach would be to have two classes, one for defining a node and another defining a linked list. The node class is simple, it just needs two variables for singly linked list. It needs a variable for the value that it holds and a pointer to the next node. For the linked list class, when we instantiate it, the head would be equal to null. When we do an insertion, we would insert a new node to the beginnning of the list and so we would first create a new node, have the new node points to the old node and change the head to the new node. For searching, we would just start at the head and go through each node to see if the value that each node contains matches the value that we are looking for. The toString method is very similar in which we would go through all the nodes and just append the values onto a string that we return in the end. 

**Insert** method would take O(1) time and O(1) space
**Includes** method would take O(n) time and O(1) space
**toString** method would take O(n) time and O(n) space

### API

[Code implementation of singly linked list](https://github.com/TheQuangNguyen/data-structures-and-algorithms/blob/master/Data-Structures/src/main/java/linkedList/LinkedList.java)

[Code implementation of doubly linked list](https://github.com/TheQuangNguyen/data-structures-and-algorithms/blob/master/Data-Structures/src/main/java/doublyLinkedList/DoublyLinkedList.java)

**insert()**: Takes in a value and appends it to the front of the linked list.
**includes()**: Takes in a value and search if that values exist within the linked list. 
**toString()**: Takes in no parameters and return a single string that contains the values of each node in the linked list separated by commas. 
