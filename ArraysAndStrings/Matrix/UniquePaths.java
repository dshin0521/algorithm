package ArraysAndStrings.Matrix;

/**
 * A robot is located at the top-left corner of a m x n grid (0, 0).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (m - 1, n - 1).
 * How many possible unique paths are there?
 *
 * Example 1:
 *
 * Input: m = 3, n = 7
 * Output: 28
 *
 * Example 2:
 *
 * Input: m = 3, n = 2
 * Output: 3
 *
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 *
 * Example 3:
 *
 * Input: m = 7, n = 3
 * Output: 28
 *
 * Example 4:
 *
 * Input: m = 3, n = 3
 * Output: 6
 *
 *
 * Constraints:
 *
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 109.
 */
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        matrix[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j< n; j++) {
                if (i - 1 >= 0) matrix[i][j] += matrix[i - 1][j];
                if (j - 1 >= 0) matrix[i][j] += matrix[i][j - 1];
            }
        }

        return matrix[m - 1][n -1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(3, 3));
    }
}
