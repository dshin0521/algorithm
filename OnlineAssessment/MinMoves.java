package OnlineAssessment;

/**
 * You are given a String S consisting of N letters 'a' and/or 'b'.
 * In one move, you can swap one letter for the other ('a' for 'b' or 'b' for 'a').
 *
 * Write a function that, given such a String S, returns the minimum number of moves required
 * to obtain a String containing no instances of three identical consecutive letters.
 *
 * Examples:
 * 1. Given S = "baaaaa", the function should return 1.
 * The String without three identical consecutive letters which can be obtained in one move is,
 * "baabaa".
 *
 * 2. Given S = "baaabbaabbba", the function should return 2.
 * There are four valid Strings obtainable in two moves: for example, "bbaabbaabbaa"
 *
 * 3. Given S = "baabab, the function should return 0.
 *
 * Write an efficient algorithm for the following assumptions:
 * 1. N is an integer within the range [0...200,000]
 * 2. String S consists only of the characters "a" and/or "b".
 */
public class MinMoves {
    public static int solution(String s) {

        int countA = 0;
        int countB = 0;
        int numMove = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == 'a') {
                countB = 0;
                countA += 1;
                if (countA == 3) {
                    numMove += 1;
                    countA = 0;
                }
            } else {
                countA = 0;
                countB += 1;
                if (countB == 3) {
                    numMove += 1;
                    countB = 0;
                }
            }
        }
        return numMove;
    }

    public static void main(String[] args) {
        System.out.println(solution("baaaaa"));
        System.out.println(solution("baaabbaabbba"));
        System.out.println(solution("baabab"));
        System.out.println(solution("baaaaaaaaaab"));
    }
}
