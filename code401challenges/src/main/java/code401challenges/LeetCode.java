package code401challenges;

import java.util.HashMap;

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
}
