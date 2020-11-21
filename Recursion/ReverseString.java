package Recursion;

import utils.ArrayUtil;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 *
 * Example 1:
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 * Example 2:
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
public class ReverseString {
    public static void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        reverseStringHelper(s, 0, s.length - 1);
    }

    private static void reverseStringHelper(char[] s, int startIdx, int endIdx) {
        System.out.println("startIdx: " + startIdx + ", endIdx: " + endIdx);
        if (startIdx >= endIdx) return;
        char tempChar = s[startIdx];
        s[startIdx] = s[endIdx];
        s[endIdx] = tempChar;
        reverseStringHelper(s, ++startIdx, --endIdx);
    }

    public static void main(String[] args) {
        char[] charArr = {'H','a','n','n','a','h'};
        reverseString(charArr);
        ArrayUtil.printCharArray(charArr);
    }
}
