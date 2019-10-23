package sorting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {

    MergeSort mergeSort;
    @Before
    public void setUp() throws Exception {
        mergeSort = new MergeSort();
    }

    // Test for empty array
    @Test
    public void testMergeSortEmptyArray() {
        int[] arr = new int[0];
        int[] sortedArr = mergeSort.sort(arr);

        assertArrayEquals(arr, sortedArr);
    }

    // Test for one number in array
    @Test
    public void testMergeSortArrayOneElement() {
        int[] arr = new int[]{7};
        int[] sortedArr = mergeSort.sort(arr);

        assertArrayEquals(arr, sortedArr);
    }

    // Test for 2 numbers in array in order
    @Test
    public void testMergeSortArrayTwoElementsInOrder() {
        int[] arr = new int[]{3,7};
        int[] sortedArr = mergeSort.sort(arr);

        assertArrayEquals(arr, sortedArr);
    }

    // Test for 2 numbers in array not in order
    @Test
    public void testMergeSortArrayTwoElementsNotInOrder() {
        int[] arr = {7,3};
        int[] sortedArr = mergeSort.sort(arr);
        int[] expected = {3,7};

        assertArrayEquals(expected, sortedArr);
    }

    // Test for multiple numbers in array not in order
    @Test
    public void testMergeSortArrayMultipleElementsNotInOrder() {
        int[] arr = new int[]{7,8,5,3,6,1,9};
        int[] sortedArr = mergeSort.sort(arr);
        int[] expected = new int[]{1,3,5,6,7,8,9};

        assertArrayEquals(expected, sortedArr);
    }

    // Test for multiple numbers in array in order already
    @Test
    public void testMergeSortArrayMultipleElementsInOrder() {
        int[] arr = new int[]{1,3,5,6,7,8,9};
        int[] sortedArr = mergeSort.sort(arr);

        assertArrayEquals(arr, sortedArr);
    }

    // Test for negative numbers in array not in order
    @Test
    public void testMergeSortArrayMultipleElementsIncludingNegativeNotInOrder() {
        int[] arr = new int[]{3,-9,-2,0,2,5,1};
        int[] sortedArr = mergeSort.sort(arr);
        int[] expected = new int[]{-9,-2,0,1,2,3,5};

        assertArrayEquals(expected, sortedArr);
    }

    // Test for duplicate numbers in array not in order
    @Test
    public void testMergeSortArrayDuplicateNumbersNotInOrder() {
        int[] arr = new int[]{7,3,6,9,7,0,6,1};
        int[] sortedArr = mergeSort.sort(arr);
        int[] expected = new int[]{0,1,3,6,6,7,7,9};

        assertArrayEquals(expected, sortedArr);
    }

    // Test for array in reverse order
    @Test
    public void testMergeSortArrayReverseOrder() {
        int[] arr = new int[]{13,11,9,7,5,3,1};
        int[] sortedArr = mergeSort.sort(arr);
        int[] expected = new int[]{1,3,5,7,9,11,13};

        assertArrayEquals(expected, sortedArr);
    }
}