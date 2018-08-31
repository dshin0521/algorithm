import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 Given an array of strings, group anagrams together.

 Example:

 Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Output:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 Note:

 All inputs will be in lowercase.
 The order of your output does not matter.
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return null;
        Map<String, List<String>> anagramsMap = new HashMap<>();

        for (String s : strs) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String key = String.valueOf(charArr);
            /*
            if(!anagramsMap.containsKey(key)) {
              anagramsMap.put(key, new LinkedList<String>());
            }
            anagramsMap.get(key).add(s);
            */
            List<String> anagrams = anagramsMap.getOrDefault(key, new LinkedList<String>());
            anagrams.add(s);
            anagramsMap.put(key, anagrams);
        }

        return new ArrayList<List<String>>(anagramsMap.values());
    }

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> output = groupAnagrams(input);
        for (List<String> anagrams : output) {
            System.out.println(anagrams.size());
            for (String anagram : anagrams) {
                System.out.println(anagram);
            }
        }
    }
}
