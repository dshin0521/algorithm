package ArraysAndStrings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 *
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 *
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistance {
    public static int shortestDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> wordMap = new HashMap<>();

        List<Integer> firstWordLoc = new LinkedList<>();
        List<Integer> secondWordLoc = new LinkedList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) firstWordLoc.add(i);
            if (words[i].equals(word2)) secondWordLoc.add(i);
        }

        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < firstWordLoc.size(); i++) {
            for (int j = 0; j < secondWordLoc.size(); j++) {
                minDist = Math.min(minDist, Math.abs(firstWordLoc.get(i) - secondWordLoc.get(j)));
            }
        }

        return minDist;
    }

    public static void main(String[] args) {
        String[] testWords = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(shortestDistance(testWords, "coding", "practice"));
    }
}
