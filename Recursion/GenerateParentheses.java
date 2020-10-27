package Recursion;

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

    private static void generateParenthesis(
            List<String> parenthesisList, String parenthesis, int open, int close, int n) {
        System.out.println("recursive call  :" + parenthesis + " open: " + open + ", close: " + close);
        if (parenthesis.length() == n * 2) {
            parenthesisList.add(parenthesis);
            System.out.println("parenthesis val :" + parenthesis + " open: " + open + ", close: " + close);
            return;
        }

        if (open < n)
            generateParenthesis(parenthesisList, parenthesis + "(", open + 1, close, n);
        if (close < open)
            generateParenthesis(parenthesisList, parenthesis + ")", open, close + 1, n);
    }

    public static void main(String[] args) {
        generateParenthesis(2);
    }

}
