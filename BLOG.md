# Blog Notes: Sorting Algorithms

This blog contains detailed explanations of popular sorting algorithms for new programmers to learn from.

## Table of Contents 

1. [Insertion Sort](#insertion-sort)
2. [Merge Sort](#merge-sort)
3. [Quick Sort](#quick-sort)

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

# Quick Sort

Quick sort is another fast sorting algorithm whose speed is comparable to merge sort. It is also a divide and conquer algorithm that utilize recursion although in a different way than merge sort. The algorithm uses a random arbitrary element in the list that we call the "pivot". We would sort the list in such a way that everything to the left of the pivot is of lesser values and everything to the right of the pivot is of greater values. If we do this recursively, we would get to the point of having 2 elements in the list in which if we use the logic that we said quick sort is gonna do, it would sort those 2 elements in the correct order. Once we get to that point, our algorithm successfully sorted the entire list. Quick sort, unlike merge sort, is unstable in that its performance largely depend on how we choose our pivot. If we choose our pivot to be lowest or largest element in the list everytime within the recursive process, then its performance will degrade to O(n^2). We can randomize our pivot so that most of the time, the pivot would be a value in between the lowest and largest values which in that case, performance would be O(nlog(n)). Space wise, it is better than merge sort since quick sort swap values around like insertion sort and so space complexity is O(1).  

## Diagram

Source: [InterviewBit](https://www.interviewbit.com/tutorial/quicksort-algorithm/)

<img src="/assets/quick-sort.png" alt="Quick Sort Diagram">

## Algorithm

Now that we are familiar with recursion, we can dive straight into the meat of quick sort. Basically at every recursive steps, we would do the same thing as portrayed in the diagram where we select a `pivot` and sort the rest of elements so that the lesser values are to the left of the `pivot` and the greater values are to the right of the `pivot`. In our case, we would always choose the last element in the list/sublist that we are sorting to be our pivot for convenience sake. We would have 2 pointers, one called `low` to reference the boundary where all the lowest values would be to the left of that pointer and one called `i` to traverse through the entire list except for the `pivot` itself. We would set up a for loop to increment `i` from 0 to the second to last value since the last value is the pivot and set `low` as the first element in the list. At every iteration, we compare the values at `i` to the value at the `pivot`. If it is less than the `pivot`, then we swap the value at `i` with the value at `low` and increment `low` by 1. Since we only do this when we encounter a lower value than the `pivot`, we effectively sort all of the lower values to the front of the list and all the larger values to the back of the list. The location of the `low` pointer marks the separation between the lower and larger values. At the end, we swap the `low` pointer with the `pivot` so now the pivot is the separation point. It is important to note that the region of lesser and greater values are not sorted themselves. Afterward we recursively doing the same thing now for the lesser and greater regions. This works because when we get to a list of only 1 or 2 elements, we can sort them super easy. Once we get to the point, our list is basically all sorted.   

## Pseudocode

```
ALGORITHM QuickSort(arr, left, right)
    if left < right
        // Partition the array by setting the position of the pivot value 
        DEFINE position <-- Partition(arr, left, right)
        // Sort the left
        QuickSort(arr, left, position - 1)
        // Sort the right
        QuickSort(arr, position + 1, right)

ALGORITHM Partition(arr, left, right)
    // set a pivot value as a point of reference
    DEFINE pivot <-- arr[right]
    // create a variable to track the largest index of numbers lower than the defined pivot
    DEFINE low <-- left - 1
    for i <- left to right do
        if arr[i] <= pivot
            low++
            Swap(arr, i, low)

     // place the value of the pivot location in the middle.
     // all numbers smaller than the pivot are on the left, larger on the right. 
     Swap(arr, right, low + 1)
    // return the pivot index point
     return low + 1

ALGORITHM Swap(arr, i, low)
    DEFINE temp;
    temp <-- arr[i]
    arr[i] <-- arr[low]
    arr[low] <-- temp
```

## Readings and References

**Watch this video for visual demonstration of quick sort**

* [Quick Sort | GeeksforGeeks](https://www.youtube.com/watch?v=PgBzjlCcFvc)

**Read these articles for more explanations on merge sort**

* [Hackerearth](https://www.hackerearth.com/practice/algorithms/sorting/quick-sort/tutorial/)
* [InterviewBit](https://www.interviewbit.com/tutorial/quicksort-algorithm/)