package code401challenges;

public class BinarySearch {

    // Write a function called BinarySearch which takes in 2 parameters: a sorted array and the search key.
    // Without utilizing any of the built-in methods available to your language,
    // return the index of the array’s element that is equal to the search key, or -1 if the element does not exist.

    // Solution using while loop
    public static int binarySearch(int[] arr, int key) {
        // Define the upper and lower bounds of where to search
        int lower = 0;
        int upper = arr.length - 1;

        while(lower <= upper) {
            int mid = (lower + upper) / 2;

            if (key > arr[mid]) {
                lower = mid + 1;
            } else if (key < arr[mid]) {
                upper = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // Binary search using recursion
    public static int binarySearchRecursiveMain(int[] inputArr, int key) {
        int lower = 0;
        int upper = inputArr.length - 1;
        return recursiveBinarySearch(inputArr, key, lower, upper);
    }

    // Helper function for recursion.
    public static int recursiveBinarySearch(int[] arr, int key, int lower, int upper) {
        if (lower > upper) {
            return -1;
        }
        int mid = (lower + upper) / 2;
        if (key > arr[mid]) {
            lower = mid + 1;
            return recursiveBinarySearch(arr, key, lower, upper);
        } else if (key < arr[mid]) {
            upper = mid - 1;
            return recursiveBinarySearch(arr, key, lower, upper);
        } else {
            return mid;
        }
    }
}
