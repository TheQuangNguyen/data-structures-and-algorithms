package code401challenges;

import org.junit.Before;
import org.junit.Test;

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
}