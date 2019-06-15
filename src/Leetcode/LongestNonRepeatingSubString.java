package Leetcode;

import java.util.HashMap;

public class LongestNonRepeatingSubString {

    public static void main(String[] args) {
        String str = "ABDEFGAABEF";
        System.out.println("The input string is " + str);
        int len = longestUniqueSubsttr(str);
        System.out.println("The length of "
                + "the longest non repeating character is " + len);
    }

    private static int longestUniqueSubsttr(String test2) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; i < test2.length(); i++) {

            if (map.containsKey(test2.charAt(i))) {

                j = Math.max(map.get(test2.charAt(i)), j);

            }
            ans = Math.max(ans, i - j + 1);

            map.put(test2.charAt(i), i + 1);

        }
        return ans;
    }
}
