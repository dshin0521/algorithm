package Recursion;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * Constraints:
 *
 * 1 <= n <= 45
 */
public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n <= 1) return n;
        return climbStairs(n, 0, 0);
    }

    private static int climbStairs(int target, int climbed, int count) {
        if (target == climbed) count++;
        if (target <= climbed) return count;
        return climbStairs(target, climbed + 1, count) + climbStairs(target, climbed + 2, count);
    }

    /**
     * Memoized solution
     * Top-down approach
     */
    public static int[] cache = new int[46];
    public static int climbStairsTopDown(int n) {
        if (cache[n] != 0) return cache[n];
        if (n == 1) return 1;
        if (n == 2) return 2;
        return cache[n] =
                climbStairsTopDown(n - 1) + climbStairsTopDown(n - 2);
    }

    /**
     * Memoized solution
     * Bottom-up approach
     */
    public static int climbStairsBottomUp(int n) {
        int[] cache = new int[46];

        cache[1] = 1;
        cache[2] = 2;
        for (int i = 3; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairsTopDown(1));
        System.out.println(climbStairsBottomUp(1));

        System.out.println(climbStairs(2));
        System.out.println(climbStairsTopDown(2));
        System.out.println(climbStairsBottomUp(2));

        System.out.println(climbStairs(3));
        System.out.println(climbStairsTopDown(3));
        System.out.println(climbStairsBottomUp(3));

        System.out.println(climbStairs(4));
        System.out.println(climbStairsTopDown(4));
        System.out.println(climbStairsBottomUp(4));
    }
}
