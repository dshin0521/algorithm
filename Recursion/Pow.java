package Recursion;

/**
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 *
 * Example 1:
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 *
 * Example 2
 *
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 *
 * Example 3:
 *
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2^-2 = (1/2)^2 = 1/4 = 0.25
 *
 * Constraints:
 *
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 */
public class Pow {

    /**
     * Iterative solution (which exceeds time limit)
     */
    public static double myPow(double x, int n) {
        if (x == 0) return 0;

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double result = 1;
        for (int i = 0; i < n; i++) {
            result = result * x;
        }

        return result;
    }

    /**
     * Recursive solution (which exceeds time limit)
     */
    public static double myPowRecursive(double x, int n) {
        if (x == 0) return 0;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return myPowRecursive(1, x, n);
    }

    private static double myPowRecursive(double val, double x, int n) {
        if (n == 0) return val;
        return myPowRecursive(val * x, x, n-1);
    }

    /**
     * Recursive solution with some optimization
     * Uses method called "Fast Power."
     *
     * Intuition
     *
     * Assuming we have got the result of x^n, how can we get x^(2*n)?
     * Obviously we do not need to multiply x for another n times.
     * Using the formula (x^n)^2 = x^(2*n), we can get x^(2*n) at the cost of only one computation.
     * Using this optimization, we can reduce the time complexity of our algorithm.
     *
     * Algorithm
     *
     * Assume we have got the result of x^(n/2), and now we want to get the result of x^n.
     * Let A be result of x^(n/2), we can talk about x^n based on the parity of n respectively.
     * If n is even, we can use the formula (x^n)^2 = x^(2*n) to get x^n = A * A.
     * If n is odd, then A * A = x^(n-1).
     * Intuitively, We need to multiply another x to the result, so x^n = A * A * x.
     * This approach can be easily implemented using recursion.
     * We call this method "Fast Power", because we only need at most O(log n) computations to get x^n.
     */

    public static double myPowFastPower(double x, int n) {
        if (x == 0) return 0;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x, n);
    }

    private static double fastPow(double x, int n) {
        if (n == 0) return 1;
        double half = fastPow(x, n/2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(2, -2));

        System.out.println(myPowRecursive(2, 10));
        System.out.println(myPowRecursive(2.1, 3));
        System.out.println(myPowRecursive(2, -2));

        System.out.println(myPowFastPower(2, 10));
        System.out.println(myPowFastPower(2.1, 3));
        System.out.println(myPowFastPower(2, -2));
    }
}
