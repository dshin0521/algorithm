package Recursion;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1.
 * That is,
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 *
 * Given N, calculate F(N).
 *
 *
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 * Example 2:
 *
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 *
 * Example 3:
 *
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 *
 * Note:
 *
 * 0 ≤ N ≤ 30.
 */
public class FibonacciNumber {
    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib (n - 2);
    }

    /**
     * Memoized solution
     * Top-down approach
     */
    public static int[] cache = new int[31];
    public static int fibTopDown(int n) {
        if (n <= 1) return n;
        else if (cache[n] != 0) return cache[n];
        else return cache[n] = fibTopDown(n - 1) + fibTopDown(n - 2);
    }

    /**
     * Memoized solution
     * Bottom-up approach
     */
    public static int fibBottomUp(int n) {
        if (n <= 1) return n;

        int[] cache = new int[31];
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[n];
    }



    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println(fibTopDown(5));
        System.out.println(fibBottomUp(5));
    }
}
