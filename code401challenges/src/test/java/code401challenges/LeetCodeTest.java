package code401challenges;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static code401challenges.LeetCode.*;
import static org.junit.Assert.*;

public class LeetCodeTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void test() {
       int result = lengthOfLongestSubstring("abcabcbb");
       assertEquals(3, result);
    }

    @Test
    public void testLinkedListSum() {
        LinkedList<Integer> test = new LinkedList<>();
        test.add(1);
        test.add(3);
        test.add(5);

        LinkedList<Integer> result = LinkedListSum(test, 77);
        assertEquals(2, (int) result.get(0));
        assertEquals(1, (int) result.get(1));
        assertEquals(2, (int) result.get(2));
    }
}