package sorting;

import java.util.List;

public class InsertionSort implements SortingAlgorithm {

    // sort the input array in place using insertion sort
    @Override
    public int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int temp = arr[i];

            while(j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = temp;
        }
        return arr;
    }
}
