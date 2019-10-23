package sorting;

public class MergeSort implements SortingAlgorithm {

    // array to store values of original array to enable in place sorting of original array
    private int[] aux;
    // Sort array by recursively merging two sorted arrays together
    @Override
    public int[] sort(int[] arr) {
        aux = new int[arr.length];
        sort(arr, 0, arr.length-1);
        return arr;
    }

    // helper method for recursively sort left half and right half of the input array and merge them together
    // left and right are defined as the boundary of the array that we are sorting
    private void sort(int[] arr, int left, int right) {
        // check if array has one or zero element in it
        if (right <= left) {
            return;
        }

        // sort left half and right half of array then merge them together
        int mid = left + (right - left)/2;
        sort(arr, left, mid);
        sort(arr, mid+1, right);
        merge(left, mid, right, arr);
    }

    // helper method to merge two sorted arrays together into one sorted array
    private void merge(int left, int mid, int right, int[] arr) {
        // Declare two pointers: i for traversing from left to mid and j for traversing from mid + 1 to right
        int i = left, j = mid + 1;

        // store the values of original array to aux array for reference since we will change values in original array in place
        for (int k = left; k <= right; k++) {
            aux[k] = arr[k];
        }

        // Sort the numbers ascending from left to right by comparing values at i and j pointers
        for (int k = left; k <= right;  k++) {
            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > right) {
                arr[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                arr[k] = aux[i++];
            } else {
                arr[k] = aux[j++];
            }
        }
    }
}
