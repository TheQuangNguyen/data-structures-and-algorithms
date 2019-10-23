# Blog Notes: Sorting Algorithms

This blog contains detailed explanations of popular sorting algorithms for new programmers to learn from.

## Table of Contents 

1. [Insertion Sort](#insertion-sort)
2. [Merge Sort](#merge-sort)

# Insertion Sort

This algorithm provide a simple process to sort items in a list in ascending order. It works by comparing a number to previous numbers that were looked at to see where the correct ordered place the number needs to be. This sorting algorithm can be done in place and so the space complexity is O(1). However, this algorithm is relatively slow compare to other ones later in the list as in the worst case of a reverse ordered list, it needs to check every previous numbers that were looked at for every number that is currently look at to determine the correct ordered place. This means that it needs to compare approximately 1/2 N^2 times and also moves position of elements 1/2 N^2 times as well which result in a time complexity of O(N^2).

## Diagram

Source: **"Algorithms: Fourth Edition"** by Robert Sedgewick and Kevin Wayne
![insertion sort](/assets/insertion-sort.png)

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

# Merge Sort

This algorithm is considered to be a divide and conquer algorithm meaning that it divides the list up into smaller pieces and sort those smaller pieces rather than sort the list as a whole like with insertion sort. It works by recursively splitting the list in half and sort the two halves and in the end merge them together in sorted order. This is a more efficient algorithm than insertion sort because merging the two sorted lists into one single sorted list takes `O(n)` time and we recursively divide the list into halves so that takes `O(log(n))` time. In the end, we have an algorithm that takes O(nlog(n)) time. For space though, we have to store the values of the original list for reference since we are sorting the original list in place so that takes O(n) space,which is worse than insertion sort. But since storage capability is pretty high in modern times, we generally care more about algorithm that can deliver faster time than one that takes up more memory space.  

## Diagram

Source: **"Algorithms: Fourth Edition"** by Robert Sedgewick and Kevin Wayne
![merge sort](/assets/merge-sort.png)


## Algorithm

To understand this algorithm, you need to understand what a recursive algorithm is. A recursive function is just a function that calls itself. Simple as that. But now you might think that since the function just call itself, wouldn't that just end up in an endless loop of the function calling itself sort of like a while true loop. Well like a normal while loop, recursion also have a condition that if met, it would stop the recursion. This condition is called the base case. For a function, if the base case is met, you would just return to end the function. And since all of these function call ends up in a call stack, the call stack would just pop off the function that was return and move on to the next function call on top of the stack and continue the process. 

So now we have an idea of what recursion is, I said that merge sort is a recursive algorithm and the premise is that we will split the list in halves, sort the two halves, and merge them at the end. This is basically what our sort function will do. Now using recursion, what we would do is in order to sort the two halves, we would use our sort function that we just created to sort those two halves. Your brain should start to hurt a bit. So then when should the recursive function stop or in other words, what is the base case? The base case is that the pieces of the list cannot have less than one element in it. This means that when you have a list and you split that list in half then split the halves into half again and repeat that process until you end up with a bunch of lists that have only one element or is empty in them. At this point, you would just return since a list that has one element or none is by default a sorted list. Now a light bulb should go off in your head. If that is the case, then at this point we have a bunch of lists that are all sorted. Now all we have to have to is start merging them in sorted order and at the end, we would have our original list in sorted order. 

Now we would need to have a function as our helper function that would do the merging of two sorted list into one sorted list. Well, the algorithm is pretty simple. You would have two pointers, one pointed at the first element in the first list and the other pointed at the first element in the second list and also an empty list that is the size of the two lists combined. At this point, you would compare the values of the elements of those two pointers. The lesser values would be the first value in your empty list. Then you would move the pointer of whichever list that you just put the values in the empty list by one. Then continue to compare the values between the two pointers and whichever is lesser would be put into the new list while that pointer would be incremented. Continue until the pointer exceeds the length of the list that it is traversing. At the point, put the rest of the elements in the other list into our new list and voila, we have a single sorted list. We would return this new ordered list and let the recursion magic takes care of the rest.   

## Pseudocode 

```
ALGORITHM Mergesort(arr)
    DECLARE n <-- arr.length
           
    if n > 1
      DECLARE mid <-- n/2
      DECLARE left <-- arr[0...mid]
      DECLARE right <-- arr[mid...n]
      // sort the left side
      Mergesort(left)
      // sort the right side
      Mergesort(right)
      // merge the sorted left and right sides together
      Merge(left, right, arr)

ALGORITHM Merge(left, right, arr)
    DECLARE i <-- 0
    DECLARE j <-- 0
    DECLARE k <-- 0

    while i < left.length && j < right.length
        if left[i] <= right[j]
            arr[k] <-- left[i]
            i <-- i + 1
        else
            arr[k] <-- right[j]
            j <-- j + 1
            
        k <-- k + 1

    if i = left.length
       set remaining entries in arr to remaining values in right
    else
       set remaining entries in arr to remaining values in left
```

## Readings and References

**Watch this video for visual demonstration of merge sort**

* [Merge Sort | GeeksforGeeks](https://www.youtube.com/watch?v=JSceec-wEyw)

**Read these articles for more explanations on merge sort**

* [Hackerearth](https://www.hackerearth.com/practice/algorithms/sorting/merge-sort/tutorial/)
* [InterviewBit](https://www.interviewbit.com/tutorial/merge-sort-algorithm/)