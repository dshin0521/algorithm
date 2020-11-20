package ArraysAndStrings.Matrix;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * Example:
 *
 * Consider the following matrix:
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 * Given target = 20, return false.
 */
public class SearchMatrixII {
    public static boolean searchMatrixRecursive(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        return searchMatrixRecursive(matrix, 0, matrix[0].length - 1, target);
    }

    private static boolean searchMatrixRecursive(int[][] matrix, int row, int col, int target) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) return false;
        if (matrix[row][col] > target) return searchMatrixRecursive(matrix, row, col - 1, target);
        else if (matrix[row][col] < target) return searchMatrixRecursive(matrix, row + 1, col, target);
        else return true;
    }

    public static boolean searchMatrixIterative(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = 0;
        int col = matrix[0].length - 1;

        while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
            if (matrix[row][col] < target) row++;
            else if (matrix[row][col] > target) col--;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] testMatrix = new int[][] {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };

        int testTarget = 15;

        System.out.println(searchMatrixRecursive(testMatrix, testTarget));
        System.out.println(searchMatrixIterative(testMatrix, testTarget));

        testMatrix = new int[][]{
                {1, 4, 7, 11,15},
                {2, 5, 8, 12,19},
                {3, 6, 9, 16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };

        testTarget = 5;

        System.out.println(searchMatrixRecursive(testMatrix, testTarget));
        System.out.println(searchMatrixIterative(testMatrix, testTarget));
    }
}
