# Data Structures and Algorithms 

This repo contains common algorithms problems and my solutions to those problems.

## Table of Contents For 401

1. [Reverse an Array](#reverse-an-array)
2. [Array Insert and Shift](#array-insert-and-shift)
3. [Binary Search](#binary-search)
4. [Linked List Implementation](#linked-list-implementation)
5. [Linked List Insertion](#linked-list-insertion)
6. [Get Kth Value From End Of Linked List](#get-kth-value-from-end-of-linked-list)
7. [Merge Two Linked Lists](#merge-two-linked-lists)
8. [Stacks and Queues Implementation](#stacks-and-queues-implementation)
9. [Queue With Two Stacks Implementation](#queue-with-two-stacks-implementation)
10. [Animal Shelter](#animal-shelter)
11. [Brackets Validation](#brackets-validation)
12. [Binary/Binary Search Tree Implementation](#binary/binary-search-tree-implementation)
13. [Fizz Buzz Tree](#fizz-buzz-tree)
14. [Breadth-First Traversal](#breadth-first-traversal)
15. [Find Maximum Value in Binary Tree](#find-maximum-value-in-binary-tree)
16. [Hash Table](#hash-table)
17. [Repeated Word](#repeated-word)
18. [Graphs](#Graphs)
19. [Breadth-First Traversal Graph](breadth-first-traversal-graph)


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

## Linked List Insertion

### Problem Statement

Write the following methods for the Linked List class:
* **.append(value):** adds a new node with the given value to the end of the list
* **.insertBefore(value, newVal):** add a new node with the given newVal immediately before the first value node
* **.insertAfter(value, newVal):** add a new node with the given newValue immediately after the first value node

### Approach & Efficiency

#### Append

Start with the head node and use a while loop to iterate through the list to find the last node on the list. For each iteration of the loop, checks to see if the next node is null or not. If not, then make the current node be equal to the next node. When current node is the last node, the while loop will exits and afterward make a new node with the given value and next be equals to null. Then have the current node points to the new node since the new node is the new last node of the list. 

Time complexity is O(n) since we have to go through every node to get to the last node. Space complexity is O(1) since we only needed to provide memory for the new node. 

#### Insert Before 

Start with the head node and use a while loop to iterate through the list to see if the next node is equal to the given value. If it is, then the current node would be the node before the node that contains the given value. Create a new node with the given value and have new node points to the next node of the current node. Then have the current node's next points to the new node. 

There is a special case in which the very first node contains the value and so we need to put the new node before the first node and make the new node be the head of the list. To do this, we would have an if statement that checks if the head of the list equal to the value before the while loop. If it is, then make the new node with the given value and points to the old head node. Afterward, make the head of the linked list be the new node. 

Time complexity is O(n) because the worst case is that the value we looking for can be at the end of the list. Space complexity is O(1) because we only need to create a new node. 

#### Insert After

Insert After is almost the same to insert before with the exception that we are not stopping at the node before the node that contains the value but we are stopping at the node that contains the value. This means that for the while loop, we would check if the current node value is equal to the value we looking for, not the next node's value. Everything else is basically the same in regard to the insertion logic. 

Time comlexity is O(n) because worst case we have to search until the last node at the end of the list. Space complexity is o(1) for the same reason above. 

### Solution 

[Linked List Insertion Code Solution](https://github.com/TheQuangNguyen/data-structures-and-algorithms/blob/master/Data-Structures/src/main/java/linkedList/LinkedList.java)

![alt text](/assets/linked-list-insertion.png)

## Get Kth Value From End Of Linked List

### Problem Statement 

Write a method for the Linked List class which takes a number, k, as a parameter. Return the node’s value that is k from the end of the linked list. You have access to the Node class and all the properties on the Linked List class as well as the methods created in previous challenges.

### Approach & Efficiency 

Have two pointers at the head and move the first pointer k position away from the head. Then move both pointers along the linked list one node at a time until the first pointer get to the last node on the list before null using a while loop. Since the first and second pointers are k apart away, the second pointer is at the node kth away from the end of list. 

The time complexity of this algorithm should be O(n) since in the worst case, both pointer traverse through the entire list to the end of the list for the case of k = 0. Space complexity would be just O(1) since we only need to create two pointers.

### Solution 

[Linked List Get Kth Value From The End Solution](https://github.com/TheQuangNguyen/data-structures-and-algorithms/blob/master/Data-Structures/src/main/java/linkedList/LinkedList.java)

![alt text](/assets/linked-list-get-kth-from-end.png)

## Merge Two Linked Lists

### Problem Statement

Write a function called mergeLists which takes two linked lists as arguments. Zip the two linked lists together into one so that the nodes alternate between the two lists and return a reference to the head of the zipped list. Try and keep additional space down to O(1). You have access to the Node class and all the properties on the Linked List class as well as the methods created in previous challenges.

### Approach & Efficiency

First create variables that will each store the current nodes for both linked lists as well as the next nodes for the current nodes. Then with a while loop, go through the first linked list and set the currentNode1.next to be currentNode2. Afterward set currentNode2.next be equals to nextNode1. Then set both currentNode1 and currentNode2 to be nextNode1 and nextNode2. Then repeat the process until either currentNode1.next or currentNode2.next is equal to null. Afterward, checks if currentNode1.next is null. If it is, then set currentNode1.next to currentNode2. Otherwise, set currentNode1.next to currentNode2 and currenNode2.next to nextNode1. 

Time complexity of this is O(n) since we traverse through the entire linked list that is shorter.
Space complexity would be O(1) since we only need four variables to keep track of our current nodes and next nodes. 

### Solution 
[Merging Two Linked Lists Solution](https://github.com/TheQuangNguyen/data-structures-and-algorithms/blob/master/Data-Structures/src/main/java/linkedList/LinkedList.java)

![alt text](/assets/merging-linked-list.png)

## Stacks and Queues Implementation
This is my own implementation of the stack and queue data structures. Stacks and queues are very similar to linked list but what's different is how we interact with the content of each data structure. 

Stacks is used to order items being push into the stack in such a way that the most recently added item would always be inserted at the front of the stack. This way when we pop off an item, we would take off the last item that we insert in the stack, which is the one at the front.  

Queues is similar to stacks but instead, queues order items such that the order that the items inserted into the queues is the order of the items that should be removed from the queues. Queues have two pointers that point to the back and the front of the queue. Items being inserted are said to be enqueued to the back of the queue nad items being removed are said to be dequeued from the front of the queue. 

### Challenge
1. Create a Node class that has properties for the value stored in the Node, and a pointer to the next node.
2. Create a Stack class that has a top property. It creates an empty Stack when instantiated.
    - This object should be aware of a default empty value assigned to top when the stack is created.
    - Define a method called push which takes any value as an argument and adds a new node with that value to the top of the stack with an O(1) Time performance.
    - Define a method called pop that does not take any argument, removes the node from the top of the stack, and returns the node’s value.
    - Define a method called peek that does not take an argument and returns the value of the node located on top of the stack, without removing it from the stack.
3. Create a Queue class that has a front property. It creates an empty Queue when instantiated.
    - This object should be aware of a default empty value assigned to front when the queue is created.
    - Define a method called enqueue which takes any value as an argument and adds a new node with that value to the back of the queue with an O(1) Time performance.
    - Define a method called dequeue that does not take any argument, removes the node from the front of the queue, and returns the node’s value.
    - Define a method called peek that does not take an argument and returns the value of the node located in the front of the queue, without removing it from the queue.

### Approach & Efficiency
1. **Stacks** - should contain a private instance variable called **top** that points to the item at the front of the stack. 
    - `void push(T value)` - push method should take in a generic variable called value that will hold the value of the node that we will add to the stack and return void. All we have to do is to create a new node that holds the parameter value and points to the current top. Then set the current top to be the new node. Time and space complexity are O(1).
    - `T pop()` - pop method should not take in any parameter and it should first check if the stack is empty by checking if the top of the stack is null or not. This is because we cannot pop off something from an empty stack. We would return an exception if pop is used on an empty stack. If the stack is not empty, set the value of the current top node onto a variable. Then set top to be top.next and return the value of the previous top. Time and space complexity are O(1).
    - `T peek()` - peek method should not take in any parameter and all it has to do is return the value of the node that top points to without modifying the stack. Time and space complexity are O(1).

2. **Queues** - should contain two private instance variables called **front** and **back** that points respectively to the front and back of the queue.
    - `void enqueue(T value)` - enqueue method should take in a generic variable called value that holds the value of the node that we will add to the queue and return void. We first would have a temporary variable that holds the location of the current back node. Then create a new node that holds the input value and points to null and set this as the current back. Afterward, we have to check if the queue is empty or not by checking if either the front or back points to null. This is because if the queue is empty and we enqueue an item on the queue, then both the front and back would point to the same item. Thus if the queue is empty, have front = back. Otherwise, have the temporary variable that holds the previous back to have its next points to the current back. Time and space complexity are O(1).
    - `T dequeue()` - dequeue method should not take in any parameter and it should return the value of the removed node. First we would check if the queue is empty since we cannot remove something that is not there. Afterward, store the current front value onto a temporary variable and set the current front to equals the front.next. We then need to check if the queue is empty or not. This is because if the queue contains only one item, then after it is dequeued, the both the front and back should points to null. We only have the front points to front.next which should be null but we also need to set the back to null as well. Finally return the value of the removed node. 
    - `T peek()` - peek method should not take in any parameter and it should return the value of the node that front points to without modifying the queue. Time and space complexity are O(1).

## Queue With Two Stacks Implementation

### Challenge

Implement a Queue using two Stacks. This PseudoQueue class should internally utilize two stack objects implemented in previous lab. The PseudoClass should have the following methods:
* `enqueue(value)` which inserts `value` into the PseudoQueue, using a first-in, first-out approach.
* `dequeue()` which extracts a value from the PseudoQueue, using a first-in, first-out approach.

### Approach & Efficiency

The order of items being stored and pop off of a stack is the reverse of a queue in which for stacks, it is last-in-first-out(LIFO) while queue is first-in-first-out(FIFO). Therefore, if one were to push multiple values onto a stack and pop off those individual values and push them onto a second stack, this has the effect of reversing the order of the first stack which make the second stack's order be like a queue. 

Thus an approach to this problem would be to have enqueue only push to the first stack. This first stack would be the intermediary needed to reverse the order being push onto the stack. Multiple consecutive enqueue would push multiple values on the first stack. Only when dequeue is called would we transfer the items from the first stack to the second stack by popping off items one by one and pushing them onto the second stack. At this current stage, the first stack is empty and the second stack contain the order of a queue. Now, when we dequeue again, we would keep popping off items from the second stack until it is empty. Enqueue here and there would only affect first stack as the items are being pushed to the first stack.

For enqueuing one item, time and space complexity are both O(1)
For dequeuing one item, time and space complexity are also O(n) because dequeuing may involves transfering all items from first stack to second stack and consume time proportional to how many items being added and space proportional to how many things added to second stack. 

### Solution

[Code Implementation for Queue With Two Stacks](https://github.com/TheQuangNguyen/data-structures-and-algorithms/blob/master/Data-Structures/src/main/java/stacksandqueues/PseudoQueue.java)

![alt text](/assets/queue-with-stacks.png)

## Animal Shelter

### Problem Domain 

Create a class called AnimalShelter which holds only cat and dog. The shelter operates using a first-in, first-out approach like a queue. Implement the following methods: 
- `enqueue(animal)`: adds animal to the shelter. animal can be either a dog or a cat object.  
- `dequeue(pref)`: returns either a dog or a cat. If a cat or dog isn’t preferred, return whichever animal has been waiting in the shelter the longest.

### Approach & Efficiency 

At first, I was thinking of implementing two stacks that work like a queue since if I were to use two queues I would able to keep Cat and Dog apart but when it comes to whichever comes first, I would not able to know. But implementing two stacks involving too much convoluted transfering of items from one stack to another and so I am thinking of adding a time stamp to each item being added to the Animal Shelter so that I can differentiate which one came first. In that case, using two queues would be most efficient time wise since I would only need to check the time on the front of both queues to see which animal came first. If preference is either cat or dog, then just dequeue from the respective queues. 

For enqueue, time complexity would be O(1) and space complexity is O(n) depending on how much animal is enqueued

For dequeue, time complexity would be O(1) and space complexity is O(1)

### Solution 

[Code Implementation of Animal Shelter]()

![alt text](/assets/animal-shelter.png)

## Brackets Validation

### Problem Domain 

Write a function that takes a string as its only argument and should return a boolean representing whether or not the brackets in the string are balanced. There are 3 types of brackets: `[]`, `()`, `{}`. 

Sample Input: `()[[Extra Characters]]`

Sample Output: `TRUE`

### Approach & Efficiency

A validated string of brackets should have all left brackets matching its counterpart right brackets and in the correct order as well. `[{]}` have matching brackets but they are not in the correct order. The most recently seen left brackets if reading from left to right should have the next right brackets match it. Therefore, implementing a stack would make the most sense here to keep track of the most recently seen left brackets. The algorithm is pretty simple. Start by first initialize a Stack and going through each character in the string using a loop. Then check if the character is any of the left brackets. If it is, then add it to the stack. Otherwise, if it is any of the right brackets, check the top of the stack for which left bracket it needs to match. If the right bracket does not match the left bracket, then return false immediately. On the other hand, if they match, then pop off the matched left bracket from the stack and continue to the next character. Check for all characters and see at the end if the stack is empty or not. If it is not empty, then that means there were left brackets that were not matched and function should return false. If it is empty, then that means we matched every bracket with its counterpart and so it should return true. 

Time complexity of this would be `O(n)` since we can go through every character of the string in order to validate that the brackets are balanced.

Space complexity of this would be `O(n)` since there might be case that the string is full of left brackets that would fill up the stack. 

### Solution 

[Code Implementation](https://github.com/TheQuangNguyen/data-structures-and-algorithms/blob/master/Data-Structures/src/main/java/utilities/MultiBracketValidation.java)

![alt text](/assets/brackets-validation.png)

## Binary/Binary Search Tree Implementation

### Challenge

- Create a Node class that has properties for the value stored in the node,the left child node, and the right child node.
- Create a BinaryTree class
    - Define a method for each of the depth first traversals called **preOrder**, **inOrder**, and **postOrder** which returns an array of the values, ordered appropriately.
- Create a BinarySearchTree class
    - Define a method named **add** that accepts a value, and adds a new node with that value in the correct location in the binary search tree.
    - Define a method named **contains** that accepts a value, and returns a boolean indicating whether or not the value is in the tree at least once.

### Approach & Efficiency

For depth first traversals, I use recursion to traverse and ArrayList to store my values in the specified order. Preorder traversal requires me to add the current node value to the ArrayList first and recurse through the left node of the current node then recurse through the right. Inorder would have me recurse through the left node first then add the value to the ArrayList then recurse through the right. PostOrder is recursing through both the left and right first then add the value to the ArrayList. All traversals would take O(n) time and space since every values in the binary tree would have to be visited and we are storing those values in an ArrayList.  

Adding node to Binary Search Tree is fairly straightforward. Starting at the root, check first the node is null. If it is, then the current node will be the new node that contains the input value. If not, then check if the value that you want to add is less than or greater than the current node's value. Go down tree either left or right depends on if the value is less than or greater than and recursively repeat the process.

Searching is as straightforward since you are doing the same thing but at each node, you are checking if the node's value is equal to the input value. Otherwise just go left or right depending of if the value is less than or greater than. If you hit a node that is null, then that means the value is not in the tree so return false. Searching and adding would takes O(log(n)) time and O(1) space since we are choosing left or right at each node. 

### API

**Binary Tree**
- `void add(T value)` - takes in a value and randomly choose a spot on the tree to store the value. 
- `ArrayList<T> preOrder()` - perform preOrder traversal and return an ArrayList of values in preOrder order.
- `ArrayList<T> inOrder()` - perform preOrder traversal and return an ArrayList of values in preOrder order.
- `ArrayList<T> postOrder()` - perform preOrder traversal and return an ArrayList of values in preOrder order.

**Binary Search Tree**
- `void add(T value)` - takes in a value and add the value in the correct spot in BST.
- `boolean contains(T value)` - search the tree if the value is in the tree. Return true or false. 

## Fizz Buzz Tree

### Problem Domain

Write a function called FizzBuzzTree which takes a tree as an argument. Without utilizing any of the built-in methods available to your language, determine weather or not the value of each node is divisible by 3, 5 or both, and change the value of each of the nodes:
- If the value is divisible by 3, replace the value with “Fizz”
- If the value is divisible by 5, replace the value with “Buzz”
- If the value is divisible by 3 and 5, replace the value with “FizzBuzz”

Return the tree with its new values.

### Approach & Efficiency

The approach is fairly straightforward. Traverse the tree using any sort of traversal (I use preorder traversal in my code) and for each node, checks if its value is divisible by 3, 5, or both and change the values according to the problem domain. Then recurse through all other nodes until null node has been hit. 

Time complexity of this would be O(n) since we have to visit every nodes to check for its value.

Space complexity would be O(n) for call stack since the approach uses recursion but for persistance memory, it would be O(1) since we are not storing anything. 

### Solution 

![alt text](/assets/fizzbuzz.png)

## Breadth-First Traversal

### Problem Domain

Write a breadth first traversal method which takes a Binary Tree as its unique input. Without utilizing any of the built-in methods available to your language, traverse the input tree using a Breadth-first approach; print every visited node’s value.

### Approach & Efficiency 

In order to keep track of all the nodes from left to right at each level as we traverse down the tree, a queue was used to hold all the nodes at each level. To implement this, we would first enqueue the root of the tree into our queue. Then using a while loop, checks if the q is empty or not. If it is, exits the loop, if not, then continue the iteration. Basically we would dequeue the front of the queue and print the node's value. Then we would check if the left and/or right of the node is null or not. If it is, we do not do anything. If not, we would enqueue the left adn/or the right child node into the queue. We continue until the queue is empty which is when we went through every nodes. 

Time complexity of this is O(n) since we have to go through every nodes.
Space complexity of this is O(log(n)) because the queue need to hold at most the number of nodes at the lowest level of the tree.  

### Solution 

[Code Solution]()

![alt text](/assets/breadth-first.png)

## Find Maximum Value In Binary Tree

### Problem Domain

Write an instance method called **find-maximum-value**. Without utilizing any of the built-in methods available to your language, return the maximum value stored in the tree. You can assume that the values stored in the Binary Tree will be numeric.

### Approach and Efficiency

The solution will use a helper method that takes in a current node and also the maximum value found so far and return the max. Using recursion, first input the root of the tree and the value of the root into the helper method. The method will first check if the node is null or not. If it is, then return the max immediately. Otherwise, check if the current node value is greater than the max and change the max accordingly. Then recurse through the left and the right child nodes while passing in the current max. It is left to assume that the recursion will return the max of the left subtree and the right subtree and so at the end, just compare the two max and whichever is bigger we would return. 

This implemenation would takes O(n) time since we have to traverse through every nodes and O(1) space since we only store the current max, left max and right max.

### Solution

![find max](/assets/find-max.png)

## Hash Table 

A hash table is a data structure that allows key-value pairs to be stored within it. The advantage of a hash table over other data structures is that adding, removing, and lookup operations all take O(1) time to execute. This is achieved through utilizing a hash function that takes a key and convert that key into a integer index that determine where in the array that entry would be stored. The hash function is the heart of a hash table and the ability of the hash function to spread all entries somehwat evenly throughout all slots in the array determine how efficient the hash table is.  

### Challenge

Implement a hash table that has the following methods: 

1. `add`: takes in both the key and value. This method should hash the key, and add the key and value pair to the table, handling collisions as needed.
2. `get`: takes in a key and returns the value from the table.
3. `contains`: takes in the key and returns a boolean, indicating if the key exists in the table already.
4. `hash`: takes in an arbitrary key and returns an index in the collection.

***Note**: the above operations should all take O(1) time.

### Approach & Efficiency

This hash table will implement separate chaining as the method to deal with collisions. Separate chaining involves storing entries in the hashtable in an array of linked lists so that even if a collision was to happen, the entry would just be added on to the linked list at that index of the array. 

For the hash function, it is simply converting the key to a string and take the sum of the ASCII values of each of the character of the string and multiple by 599, a prime number, and mod it by the length of the array of the hash table. This would give back an integer that is within the range of the array and that will determine the index of where the entry would be added to.

## Repeated Word

### Problem Domain 

Write a function that takes in a lenghty string and return the first word that is repeated within the input string. 

### Approach & Efficiency 

The algorithm will utilize a hash table to keep track of all the words that are seen so far. The current word that is being examined will be checked against the hash table to see if the word exist in the table as a key. If it exists, then that means the word has been repeated so we return it. Otherwise move on the next word. If we have not encountered any repeated word at the end when we look at every words, then return null. This approach would take at most `O(n)` time where `n` is the entire length of the string in the case that there is no repeated word. Space-wise, it would be also `O(m)` where `m` is the number of words within the string. 

The other complexity within this problem is to extract each word properly using regex. There are cases that the word contains apostrophe like "can't" or with hyphen like "president-elect" that we have to considered. 

### Solution 

![repeated word solution](/assets/repeated-word.png)

## Common Values Between Two Binary Trees

### Problem Domain 

Write a function called `tree_intersection` that takes two binary tree parameters and return a set of values found in both trees. 

### Approach & Efficiency

A solution would be to have a hash table that keep track of all the values seen in both trees. The keys of the hash table would correspond to the values of each node and the values of the hash table would correspond to the number of times that we seen it. Essentially, we keep count of the amount of times that we seen the values and at the end when we traversed both trees, we would return a set of the values that we have seen more than once. This approach requires us to traverse through every nodes of both trees and also look through the entire hash table at the end as well to check which keys have values greater than one. Time complexity would be O(n) where n is the total number of nodes of both trees. Space complexity would also be O(n) since in the worse case where there are no common values, we are storing every values of each node of both trees in the hash table. 

### Solution 

![Common Values Between Two Binary Trees WhiteBoard Solution](/assets/common-values.png)

## Left Join 

### Problem Domain 

Write a function that LEFT JOIN two hashmaps into a single 2d array. The first parameter is a hashmap that has word strings as keys, and a synonym of the key as values. The second parameter is a hashmap that has word strings as keys, and antonyms of the key as values. LEFT JOIN means all the values in the first hashmap are returned, and if values exist in the “right” hashmap, they are appended to the result row. If no values exist in the right hashmap, then some flavor of `NULL` should be appended to the result row.

### Approach & Efficiency

My solution involves going through each entry of the synonym hashmap and check its keys against the antonym hashmap. Since left join means that all of the entries from the synonym table will be in the result array but not all of the entries from the antonym table will be in the result. Therefore we would check the keys of the synonym table against the antonym and if the key exists in both, then we include both values from both table in the resulting array. Otherwise, include only the value from the synonym table and have null as the value of the antonym table for that key. This solution would involves only iterate through each entry in the synonym table which has a time complexity of `O(n)` where n is the number of entries of synonym table. Space complexity would be `O(n)` also since we are storing the same amount of entries in the resulting array as there are in the synonym table. 

### Solution

![Left Join Two HashMap Solution](/assets/left-join.png)

## Graphs

### Challenge

Implement your own Graph. The graph should be represented as an adjacency list, and should include the following methods:

1. `AddNode()`
    * Adds a new node to the graph
    * Takes in the value of that node
    * Returns the added node
2. `AddEdge()`
    * Adds a new edge between two nodes in the graph
    * Include the ability to have a “weight”
    * Takes in the two nodes to be connected by the edge
        * Both nodes should already be in the Graph
3. `GetNodes()`
    * Returns all of the nodes in the graph as a collection (set, list, or similar)
4. `GetNeighbors()`
    * Returns a collection of nodes connected to the given node
    * Takes in a given node
    * Include the weight of the connection in the returned collection
5. `Size()`
    * Returns the total number of nodes in the graph

### Approach & Efficiency 

The overall structure of the graph would be to have the graph class holds a set of nodes and within those nodes, each of them have their list of edges that indicate which nodes they point to. And so we would have a Node class that holds a value and a list of type Edge and the Edge class would holds the weight of the connection and what Node it points to. 

* `Node<T> addNode(T value)`: create a node with the input value and add that node to the set of nodes in the graph class and return the created node. 
* `Edge<T> addEdge(Node node1, Node node2, (optional) int weight)`: create a new edge object that points to node2 and add that edge object to the list of edges in node1.
* `Set<Node<T>> getNodes()` : just return the set of nodes in the graph class.
* `List<Edge<T>> getNeighbors(Node node)`: return the list of edges in the node object
* `int size()`: return the size of the set of nodes in the graph class.

## Breadth First Traversal Graph

### Challenge

Implement a breadth-first traversal on a graph. Extend your graph object with a breadth-first traversal method that accepts a starting node. Without utilizing any of the built-in methods available to your language, return a collection of nodes in the order they were visited. Display the collection.

### Approach & Efficiency

Similar to how we do breadth-first traversal on a tree, we use similar method to traverse a graph. This solution utilize a queue to keep track of which nodes to visit next and also a set to keep track which nodes already visited. Since nodes in graph can connect in ways that if we dont keep track of the ones we already visited, we can end up traversing in an endless cycle. And so at every node we visit, we would add all of its neighbor nodes to the back of the queue and also to the set. Then we just dequeue whichever node is in the front of queue and continue to visit the next one. 

This solution would take `O(n)` time since there is a chance that we will visit every nodes. Space-wise, it would take `O(n)` since we are storing the nodes in the set and also temporarily in the queue. 

### Solution

![breadth-first traversal on a graph](/assets/breadth-first-graph.PNG)