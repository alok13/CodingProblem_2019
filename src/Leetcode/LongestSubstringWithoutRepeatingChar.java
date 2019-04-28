package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("GEEKSFORGEEKS"));
    }


        public static int lengthOfLongestSubstring(String test2) {
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

