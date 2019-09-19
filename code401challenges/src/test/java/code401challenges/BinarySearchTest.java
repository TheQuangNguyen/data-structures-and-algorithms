package code401challenges;

import org.junit.Test;

import static code401challenges.BinarySearch.*;
import static org.junit.Assert.*;

public class BinarySearchTest {

    ///////////////// Testing for binary search with while loop //////////////////////////////

    // Testing for even amount of elements in input array
    @Test
    public void testBinarySearchEvenAmount() {
        assertEquals("This should result in key being found at index 2", 2, binarySearch(new int[]{1,2,3,4,5,6,7,8}, 3));
    }

    // Testing for odd amount of elements in input array
    @Test
    public void testBinarySearchOddAmount() {
        assertEquals("This should result in key being found at index 8", 8, binarySearch(new int[]{1,2,3,4,5,6,7,8,9}, 9));
    }

    // Testing for zero amount of elements in input array
    @Test
    public void testBinarySearchEmpty() {
        assertEquals("This should result in key not found", -1, binarySearch(new int[]{}, 1));
    }

    // Testing for one single element in input array
    @Test
    public void testBinarySearchOneElement() {
        assertEquals("This should result in key being found at index 0", 0, binarySearch(new int[]{100}, 100));
    }

    // Testing for if key is the first element in input array
    @Test
    public void testBinarySearchKeyAtBeginning() {
        assertEquals("This should result in key being found at index 1", 1, binarySearch(new int[]{1,4,8,12,56,89,100,101,901}, 4));
    }

    // Testing for all negative elements in input array
    @Test
    public void testBinarySearchNegativeNumber() {
        assertEquals("This should result in key being found at index 6", 6, binarySearch(new int[]{-10,-9,-8,-7,-6,-5,-4,-3}, -4));
    }

    // Testing if the key is not in input array
    @Test
    public void testBinarySearchKeyNotFound() {
        assertEquals("This should result in key not found", -1, binarySearch(new int[]{-4,-2,-1,0,5,9,45,65}, 100));
    }

    // Testing for all duplicate elements in input array
    @Test
    public void testBinarySearchAllDuplicates() {
        assertEquals("This should result in key not found", -1, binarySearch(new int[]{3,3,3,3,3,3,3,3,3,3}, 5));
    }


    ////////////////////////// Testing for binary search with recursion ///////////////////////////////////

    // Testing for even amount of elements in input array
    @Test
    public void testBinarySearchEvenAmountRecursion() {
        assertEquals("This should result in key being found at index 2", 2, binarySearchRecursiveMain(new int[]{1,2,3,4,5,6,7,8}, 3));
    }

    // Testing for odd amount of elements in input array
    @Test
    public void testBinarySearchOddAmountRecursion() {
        assertEquals("This should result in key being found at index 8", 8, binarySearchRecursiveMain(new int[]{1,2,3,4,5,6,7,8,9}, 9));
    }

    // Testing for zero amount of elements in input array
    @Test
    public void testBinarySearchEmptyRecursion() {
        assertEquals("This should result in key not found", -1, binarySearchRecursiveMain(new int[]{}, 1));
    }

    // Testing for one single element in input array
    @Test
    public void testBinarySearchOneElementRecursion() {
        assertEquals("This should result in key being found at index 0", 0, binarySearchRecursiveMain(new int[]{100}, 100));
    }

    // Testing for if key is the first element in input array
    @Test
    public void testBinarySearchKeyAtBeginningRecursion() {
        assertEquals("This should result in key being found at index 1", 1, binarySearchRecursiveMain(new int[]{1,4,8,12,56,89,100,101,901}, 4));
    }

    // Testing for all negative elements in input array
    @Test
    public void testBinarySearchNegativeNumberRecursion() {
        assertEquals("This should result in key being found at index 6", 6, binarySearchRecursiveMain(new int[]{-10,-9,-8,-7,-6,-5,-4,-3}, -4));
    }

    // Testing if the key is not in input array
    @Test
    public void testBinarySearchKeyNotFoundRecursion() {
        assertEquals("This should result in key not found", -1, binarySearchRecursiveMain(new int[]{-4,-2,-1,0,5,9,45,65}, 100));
    }

    // Testing for all duplicate elements in input array
    @Test
    public void testBinarySearchAllDuplicatesRecursion() {
        assertEquals("This should result in key not found", -1, binarySearchRecursiveMain(new int[]{3,3,3,3,3,3,3,3,3,3}, 5));
    }
}