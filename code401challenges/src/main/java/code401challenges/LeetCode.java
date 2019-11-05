package code401challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class LeetCode {

    // string is abcabcbb
    public static int lengthOfLongestSubstring(String s) {
        int subStringCounter = 0;
        int i = 0;
        int j = 0;
        int ans = 0;
        HashMap<Character, Integer> table = new HashMap<>();

        while (j < s.length()) {
            if (!table.containsKey(s.charAt(j))) {
                table.put(s.charAt(j), j);
                j++;
            } else {
                i = Math.max(table.get(s.charAt(j++)) + 1, i);
            }

            ans = Math.max(ans, j - i);
        }

        return ans;
    }

    // given a linked list that represent an integer number and an int number, return a linked list
    // that is equivalent to the sum of the number represented by the input linked list and the given int.
    public static LinkedList<Integer> LinkedListSum(LinkedList<Integer> llNumber, int intNumber) {
        int llLength = llNumber.size() - 1;
        int intNumberCopy = intNumber;
        ArrayList<Integer> numArr = new ArrayList<>();

        while (intNumberCopy != 0) {
            numArr.add(intNumberCopy % 10);
            intNumberCopy /= 10;
        }

        boolean overTen = false;
        int digitSum;
        for(int i = 0; i <= numArr.size(); i--) {
            if (overTen) {
                digitSum = 1;
            } else {
                digitSum = 0;
            }
            digitSum = digitSum + llNumber.get(llLength - i) + numArr.get(i);
            llNumber.set(llLength - i, digitSum % 10);
            if (digitSum >= 10) {
                overTen = true;
            } else {
                overTen = false;
            }
        }

        return llNumber;
    }
}
