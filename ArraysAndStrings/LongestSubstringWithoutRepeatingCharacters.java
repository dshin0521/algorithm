package ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 *  Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Example 4:
 *
 * Input: s = ""
 * Output: 0
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    // Resource: https://www.youtube.com/watch?v=WKTgajDkVcA
    public static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;

        int start = 0;
        int end = 0;
        int longestLength = 0;
        Set<Character> set = new HashSet<>();
        while (end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end++));
                longestLength = Math.max(longestLength, set.size());
            } else {
                set.remove(s.charAt(start++));
            }
        }
        return longestLength;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

}
