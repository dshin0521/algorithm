package ArraysAndStrings.Matrix;

/**
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        if (grid == null) return 0;

        int numIsland = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '0') continue;
                numIsland++;
                convertLandToWater(grid, row, col);
            }
        }
        return numIsland;
    }

    private static void convertLandToWater(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row > grid.length - 1 || col > grid[row].length - 1 || grid[row][col] == '0') return;
        grid[row][col] = '0';
        convertLandToWater(grid, row - 1, col);
        convertLandToWater(grid, row, col - 1);
        convertLandToWater(grid, row + 1, col);
        convertLandToWater(grid, row, col + 1);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };

        System.out.println(numIslands(grid));
    }
}
