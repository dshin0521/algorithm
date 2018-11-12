package ArraysAndStrings;

/**
 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

 Examples:
 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.
 Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInAString {
    public static int firstUniqChar(String s) {
        /*
        Very smart solution.
        Keeping track of minimum idx of unique character.

        char ch;
        int loc = s.length();
        for (ch = 'a'; ch <= 'z'; ch++) {
            int idx1 = s.indexOf(ch);
            if (idx1 != -1 && idx1 == s.lastIndexOf(ch)) {
                loc = Math.min(loc, idx1);
            }
        }
        return loc == s.length() ? -1 : loc;
        */
        if (s == null || s.length() < 1) return -1;

        int[] posArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            //posArr[s.charAt(i) - 'a'] = posArr[s.charAt(i) - 'a'] + 1;
            posArr[s.charAt(i) - 97] = posArr[s.charAt(i) - 'a'] + 1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (posArr[s.charAt(i) - 97] == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
