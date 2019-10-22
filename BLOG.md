# Blog Notes: Sorting Algorithms

This blog contains detailed explanations of popular sorting algorithms for new programmers to learn from.

## Table of Contents 

1. [Insertion Sort](#insertion-sort)

# Insertion Sort

This algorithm provide a simple process to sort items in a list in ascending order. It works by comparing a number to previous numbers that were looked at to see where the correct ordered place the number needs to be. This sorting algorithm can be done in place and so the space complexity is O(1). However, this algorithm is relatively slow compare to other ones later in the list as in the worst case of a reverse ordered list, it needs to check every previous numbers that were looked at for every number that is currently look at to determine the correct ordered place. This means that it needs to compare approximately 1/2 N^2 times and also moves position of elements 1/2 N^2 times as well which result in a time complexity of O(N^2).

## Diagram

![alt text](/assets/insertion-sort.png)

## Algorithm

Insertion sort works by figuring out one element at a time where it belongs in a group of elements that we already see. It will start out with comparing the first two numbers in the list. If the list have zero or one element in the list,then nothing will be sorted and the original list would be returned. If the second number is less than the first number, then swap them. Otherwise keep the two numbers in the same place. At this point, we know that the two numbers we looked at are in the right place relative to each other at this moment. All we have to do is continue to check the rest of the number one at a time to see where they fit in the elements that we already sorted. Now we check if the third number is less than, greater than, or equal to the second number. If greater than or equal to, there is no need to do anything since the third number is in the correct order already relatively to the numbers that we already see. If it is less than the second number, move the second number to the third position since the second number is greater than the third number. Now compare the previously third position to the first number to see if it greater than, less than, or equal to. If greater than or equal to, leave that number in the second position. Otherwise move the first number to the second position and place the previously third number in the first position since we just check that it is less than both numbers before it. Continue this process for the rest of the numbers in order to obtain a sorted list at the end. 

## Pseudocode 

```
InsertionSort(int[] arr)

FOR i = 1 to arr.length

    int j <-- i - 1
    int temp <-- arr[i]
    
    WHILE j >= 0 AND temp < arr[j]
    arr[j + 1] <-- arr[j]
    j <-- j - 1
    
    arr[j + 1] <-- temp
```

## Readings and References

**Watch this video for visual demonstration of insertion sort**

* [Insertion Sort | GeeksforGeeks](https://www.youtube.com/watch?v=OGzPmgsI-pQ&t=22s)

**Read these articles for more explanations on insertion sort**

* [Hackerearth](https://www.hackerearth.com/practice/algorithms/sorting/insertion-sort/tutorial/)
* [InterviewBit](https://www.interviewbit.com/tutorial/insertion-sort-algorithm/)