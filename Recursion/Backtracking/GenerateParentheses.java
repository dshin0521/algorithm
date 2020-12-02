package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> solution = new ArrayList<>();
        generateParenthesis(solution, "", 0, 0, n);
        return solution;
    }

    private static void generateParenthesis(List<String> list, String parenthesis, int open, int close, int n) {
        if (parenthesis.length() == n * 2) {
            list.add(parenthesis);
            return;
        }

        if (open < n)
            generateParenthesis(list, parenthesis + "(", open + 1, close, n);
        if (close < open)
            generateParenthesis(list, parenthesis + ")", open, close + 1, n);
    }

    public static void main(String[] args) {
        generateParenthesis(2);
    }

}
