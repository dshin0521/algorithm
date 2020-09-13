package ArraysAndStrings;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 * Example 2:
 *
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * Example 3:
 *
 * Input: matrix = [[1]]
 * Output: [[1]]
 *
 * Example 4:
 *
 * Input: matrix = [[1,2],[3,4]]
 * Output: [[3,1],[4,2]]
 *
 * Constraints:
 *
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 *
 */
public class RotateImage {
    public static void rotate(int[][] matrix) {
        if (matrix == null
                || matrix.length < 1
                || matrix[0].length < 1
                || matrix.length != matrix[0].length) return;

        int numIteration = 0;

        for (int col = 0; col < Math.ceil((double) matrix[0].length / 2.0); col++) {
            for (int row = numIteration; row < Math.ceil((double) matrix.length / 2.0); row++) {
                rotateHelper(matrix, row, col);
            }
            numIteration++;
        }
    }

    private static void rotateHelper(int[][] matrix, int row, int col) {
        int tempVal = matrix[row][col];
        matrix[row][col] = matrix[matrix.length - 1 - col][row];
        matrix[matrix.length - 1 - col][row] = matrix[matrix.length - 1 - row][matrix.length - 1 - col];
        matrix[matrix.length - 1 - row][matrix.length - 1 - col] = matrix[col][matrix.length - 1 - row];
        matrix[col][matrix.length - 1 - row] = tempVal;
    }
}
