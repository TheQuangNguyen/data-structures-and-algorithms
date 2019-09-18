package code401challenges;

import org.junit.Test;

import static code401challenges.ArrayShift.insertShiftArray;
import static org.junit.Assert.*;

public class ArrayShiftTest {

    @Test
    public void testInsertShiftArrayEvenAmount() {
        assertArrayEquals("the resulting array should be [2,4,8,6,8]",
                    insertShiftArray(new int[]{2,4,6,8}, 8), new int[]{2, 4, 8, 6, 8});
    }

    @Test
    public void testInsertShiftArrayOddAmount() {
        assertArrayEquals("the resulting array should be [4,8,15,23,42]",
                    insertShiftArray(new int[]{4,8,15,23,42}, 16), new int[]{4, 8, 15, 16, 23, 42});
    }

    @Test
    public void testInsertShiftArrayNegative() {
        assertArrayEquals("the resulting array should be [-1,9,-2,100,0,-18]",
                insertShiftArray(new int[]{-1,9,-2,0,-18}, 100), new int[]{-1, 9, -2, 100, 0, -18});
    }
}