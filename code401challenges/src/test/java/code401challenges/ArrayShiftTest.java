package code401challenges;

import org.junit.Test;

import static code401challenges.ArrayShift.*;
import static org.junit.Assert.*;

public class ArrayShiftTest {

    // Tests for insertArrayShift //

    // Testing for even number of elements in the input array
    @Test
    public void testInsertShiftArrayEvenAmount() {
        assertArrayEquals("the resulting array should be [2,4,8,6,8]",
                    insertShiftArray(new int[]{2,4,6,8}, 8), new int[]{2, 4, 8, 6, 8});
    }

    // Testing for odd number of elements in the input array
    @Test
    public void testInsertShiftArrayOddAmount() {
        assertArrayEquals("the resulting array should be [4,8,15,23,42]",
                    insertShiftArray(new int[]{4,8,15,23,42}, 16), new int[]{4, 8, 15, 16, 23, 42});
    }

    // Testing for negative numbers in the input array
    @Test
    public void testInsertShiftArrayNegative() {
        assertArrayEquals("the resulting array should be [-1,9,-2,100,0,-18]",
                insertShiftArray(new int[]{-1,9,-2,0,-18}, 100), new int[]{-1, 9, -2, 100, 0, -18});
    }

    // Testing for no elements in the array
    @Test
    public void testInsertShiftArrayEmpty() {
        assertArrayEquals("the resulting array should be [100]",
            insertShiftArray(new int[]{}, 100), new int[]{100});
    }


    // Test for removeArrayShift //

    @Test
    public void testRemoveShiftArrayEvenAmount() {
        assertArrayEquals("the resulting array should be [2,4,8]",
                        removeShiftArray(new int[]{2,4,6,8}), new int[]{2,4,8});
    }

    @Test
    public void testRemoveShiftArrayOddAmount() {
        assertArrayEquals("the resulting array should be [4,8,23,42]",
            removeShiftArray(new int[]{4,8,15,23,42}), new int[]{4,8,23,42});
    }

    @Test
    public void testRemoveShiftArrayEmpty() {
        assertArrayEquals("the resulting array should be []",
            removeShiftArray(new int[]{}), new int[]{});
    }

    @Test
    public void testRemoveShiftArrayOneElement() {
        assertArrayEquals("the resulting array should be []",
            removeShiftArray(new int[]{1}), new int[]{});
    }
}