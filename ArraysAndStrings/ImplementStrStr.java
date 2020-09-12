package ArraysAndStrings;

/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's strstr() and Java's indexOf().
 *
 *
 * Constraints:
 * haystack and needle consist only of lowercase English characters.
 */
public class ImplementStrStr {
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null ||
                haystack.length() < needle.length()) return -1;
        if (needle.isEmpty()) return 0;

        /*
        boolean foundNeedle;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                foundNeedle = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        foundNeedle = false;
                        break;
                    }
                }
                if (foundNeedle) return i;
            }
        }
        */

        for (int i = 0; i <= haystack.length() - needle.length(); i ++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                // if (haystack.substring(i, i + needle.length()).equals(needle)) return i;
                if (haystack.startsWith(needle, i)) return i;
            }
        }
        return -1;
    }

    /*
    KMP related
    https://www.topcoder.com/community/competitive-programming/tutorials/introduction-to-string-searching-algorithms/
    http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/
     */
    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("helloworld", "world"));
    }
}
