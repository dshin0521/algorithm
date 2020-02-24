package DynamicProgramming;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 */
public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] newGrid = new int[row][column];

        int carryOver = 0;
        for (int i = 0; i < row; i++) {
            newGrid[i][0] = carryOver + grid[i][0];
            carryOver = newGrid[i][0];
        }
        carryOver = 0;
        for (int j = 0; j < column; j++) {
            newGrid[0][j] = carryOver + grid[0][j];
            carryOver = newGrid[0][j];
        }

        /*
            At this point, new grid will be,
            [1, 4, 5]
            [2, 0, 0]
            [6, 0, 0]

            Each iteration, will fill all 0s by Math.min(4,2) + 5 = 7,
            [1, 4, 5]
            [2, 7, 0]
            [6, 0, 0]

            Math.min(5,7) + 1 = 6,
            [1, 4, 5]
            [2, 7, 6]
            [6, 0, 0]

            ...
         */
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                newGrid[i][j] = grid[i][j] + Math.min(newGrid[i-1][j], newGrid[i][j-1]);
            }
        }
        return newGrid[row-1][column-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
}
