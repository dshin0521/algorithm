package Recursion.Backtracking;

import java.util.Arrays;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example 1:
 * Input: n = 4
 * Output: 2
 *
 * Example 2:
 * Input: n = 1
 * Output: 1
 *
 * Constraints:
 * 1 <= n <= 9
 */
public class NQueenII {

    public static final int EMPTY = -1;

    public static int totalNQueen(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, EMPTY);
        return totalNQueen(queens, 0);
    }

    private static int totalNQueen(int[] queens, int row) {
        if (row == queens.length) {
            return 1;
        }

        int count = 0;

        for (int col = 0; col < queens.length; col++) {
            if (!isUnderAttack(queens, row, col)) {
                queens[row] = col;
                count += totalNQueen(queens, row + 1);
                queens[row] = EMPTY;
            }
        }
        return count;
    }

    private static boolean isUnderAttack(int[] queens, int row, int col) {

        // row check
        if (queens[row] != EMPTY) return true;

        for (int i = 0; i < queens.length; i++) {

            if (queens[i] == EMPTY) continue;

            // column check for each row
            if (queens[i] == col) return true;

            // diagonal (\) check for each row
            if (row - col == i - queens[i]) return true;

            // diagonal (/) check for each row
            if (row + col == i + queens[i]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueen(4));
        System.out.println(totalNQueen(1));
    }
}
