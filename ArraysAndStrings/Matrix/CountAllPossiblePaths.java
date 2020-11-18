package ArraysAndStrings.Matrix;

/**
 * Given an m x n 2D matrix, write an algorithm to count all possible paths from top left corner to bottom-right corner.
 * You are allowed to move only in two directions, move right OR move down.
 * There are few obstructions as well, means few cells are blocked and you cannot travel that cell.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [1,  1,  1],
 *   [1, -1,  1],
 *   [1,  1,  1]
 * ]
 * Output: 2
 * Explanation:
 * First path is from index (0, 0) to (0, 2) and (0, 2) to (2, 2)
 * Second path is from index (0, 0) to (2, 0) and (2, 0) to (2, 2)
 *
 *
 * Example 2:
 *
 * Input:
 * [
 *   [1,  1,  1],
 *   [1,  1,  1],
 *   [1, -1,  1]
 * ]
 * Output: 3
 * Explanation:
 * First path is from index (0, 0) to (0, 2) and (0, 2) to (2, 2)
 * Second path is from index (0, 0) to (1, 0) and (1, 0) to (1, 2) and (1, 2) to (2, 2)
 * Third path is from index (0, 0) to (0, 1) and (0, 1) to (1, 1) and (1, 1) to (1, 2) and (1, 2) to (2, 2)
 */
public class CountAllPossiblePaths {
    public static int countPathRecursive(int[][] matrix) {
        return countPathRecursive(matrix, 0, 0);
    }

    private static int countPathRecursive(int[][] matrix, int row, int col) {
        if (row == matrix.length - 1 && col == matrix[0].length - 1) return 1;

        int pathToRight = 0, pathToDown = 0;
        if (row < matrix.length - 1 && matrix[row + 1][col] != -1) {
            pathToRight = countPathRecursive(matrix, row + 1, col);
        }
        if (col < matrix[0].length - 1 && matrix[row][col + 1] != -1) {
            pathToDown = countPathRecursive(matrix, row, col + 1);
        }

        return pathToRight + pathToDown;
    }

    public static int countPathIterative(int[][] matrix) {
        int[][] pathCount = new int[matrix.length][matrix[0].length];
        pathCount[0][0] = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1) pathCount[i][j] = 0;
                else {
                    if (i - 1 >= 0) pathCount[i][j] += pathCount[i - 1][j];
                    if (j - 1 >= 0) pathCount[i][j] += pathCount[i][j - 1];
                }
            }
        }
        return pathCount[matrix.length - 1][matrix[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] testMatrix = new int[][]{{1,1,1},{1,-1,1},{1,1,1}};
        System.out.println(countPathRecursive(testMatrix));
        System.out.println(countPathIterative(testMatrix));

        testMatrix = new int[][]{{1,1,1},{1,1,1},{1,-1,1}};
        System.out.println(countPathRecursive(testMatrix));
        System.out.println(countPathIterative(testMatrix));
    }
}
