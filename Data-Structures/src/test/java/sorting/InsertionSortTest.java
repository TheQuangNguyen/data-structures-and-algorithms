package sorting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InsertionSortTest {

    InsertionSort insertionSort;
    @Before
    public void setUp() throws Exception {
        insertionSort = new InsertionSort();
    }

    // Test for empty array
    @Test
    public void testInsertionSortEmptyArray() {
        int[] arr = new int[0];
        int[] sortedArr = insertionSort.sort(arr);

        assertArrayEquals(arr, sortedArr);
    }

    // Test for one number in array
    @Test
    public void testInsertionSortArrayOneElement() {
        int[] arr = new int[]{7};
        int[] sortedArr = insertionSort.sort(arr);

        assertArrayEquals(arr, sortedArr);
    }

    // Test for 2 numbers in array in order
    @Test
    public void testInsertionSortArrayTwoElementsInOrder() {
        int[] arr = new int[]{3,7};
        int[] sortedArr = insertionSort.sort(arr);

        assertArrayEquals(arr, sortedArr);
    }

    // Test for 2 numbers in array not in order
    @Test
    public void testInsertionSortArrayTwoElementsNotInOrder() {
        int[] arr = {7,3};
        int[] sortedArr = insertionSort.sort(arr);
        int[] expected = {3,7};

        assertArrayEquals(expected, sortedArr);
    }

    // Test for multiple numbers in array not in order
    @Test
    public void testInsertionSortArrayMultipleElementsNotInOrder() {
        int[] arr = new int[]{7,8,5,3,6,1,9};
        int[] sortedArr = insertionSort.sort(arr);
        int[] expected = new int[]{1,3,5,6,7,8,9};

        assertArrayEquals(expected, sortedArr);
    }

    // Test for multiple numbers in array in order already
    @Test
    public void testInsertionSortArrayMultipleElementsInOrder() {
        int[] arr = new int[]{1,3,5,6,7,8,9};
        int[] sortedArr = insertionSort.sort(arr);

        assertArrayEquals(arr, sortedArr);
    }

    // Test for negative numbers in array not in order
    @Test
    public void testInsertionSortArrayMultipleElementsIncludingNegativeNotInOrder() {
        int[] arr = new int[]{3,-9,-2,0,2,5,1};
        int[] sortedArr = insertionSort.sort(arr);
        int[] expected = new int[]{-9,-2,0,1,2,3,5};

        assertArrayEquals(expected, sortedArr);
    }
}