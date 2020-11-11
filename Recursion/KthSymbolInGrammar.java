package Recursion;

/**
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 *
 * Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).
 *
 * Examples:
 * Input: N = 1, K = 1
 * Output: 0
 *
 * Input: N = 2, K = 1
 * Output: 0
 *
 * Input: N = 2, K = 2
 * Output: 1
 *
 * Input: N = 4, K = 5
 * Output: 1
 *
 * Explanation:
 * row 1: 0
 * row 2: 01
 * row 3: 0110
 * row 4: 01101001
 *
 * Note:
 *
 * N will be an integer in the range [1, 30].
 * K will be an integer in the range [1, 2^(N-1)].
 */
public class KthSymbolInGrammar {
    public static int kthGrammar(int N, int K) {
        String[] cache = new String[N];
        cache[0] = "0";
        if (N > 1) cache[1] = "01";

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N; i++) {
            String prevRow = cache[i - 1];
            sb.append(prevRow);
            for (char c : prevRow.toCharArray()) {
                if (c == '0') sb.append("1");
                else if (c == '1') sb.append("0");
            }
            cache[i] = sb.toString();
            sb.setLength(0);
        }
        return Character.getNumericValue(cache[N - 1].charAt(K - 1));
    }

    /**
     * Think of the problem like this..
     *
     *            0
     *         /    \
     *        0     1
     *      /  \   /  \
     *     0   1  1   0
     *
     * When we generally implement a tree from an array, a node's left child is stored at 2 * its index + 1.
     * And its right child is stored at 2 * its index + 2.
     * We will use similar logic but different.
     *
     * 0-->01-->0110-->01101001
     * 1-->12-->1234-->12345678 (represents the k values of each row)
     *
     * This problem has a different indexing (k always starts with 1).
     * We can know a node's left child is stored at (2 * k) - 1 and the right child stored at 2 * k.
     * i.e. a node at n = 3, k = 3 generates "5", "6" as its children --> (2 * 3) - 1 = 5, 2 * 3 = 6.
     * This shows that if we know the parent's symbol at k, we will know the symbol of its child at 2k - 1 and 2k.
     *
     * The problem gives us N and K.
     * And symbol at N with K index is 'child' of N - 1 at (K+1)/2 or K/2.
     * This is because 2x - 1 = y --> x = (y + 1)/2 assuming x = parent's index and y = child's index.
     *
     * We can know whether the position of K is a left node or a right node by dividing 2.
     * If K is even, current node is right child, and its parent is the (K/2)th node in previous row;
     * else if K is odd, current node is left child and its parent is the ((K+1)/2)th node in previous row.
     *
     * Checking some examples will show "patter" or rules:
     * For example, when N = 3 ("0110"),
     * Assume K = 3 --> (3 + 1)/2 = 2. Go check 2nd index in N - 1 ("01"); parents and child have same symbol of "1".
     * Assume K = 4 --> 4 / 2 = 2. Go check 2nd index in N - 1 ("01"); parents and child have different symbol (need to reverse parent's symbol).
     *
     * So two rules can be developed:
     * 1) If K is even, go to K / 2 in N - 1 and reverse the parent's symbol
     * 2) If K is odd, go to (K + 1) / 2 in N - 1 and parent have the same symbol
     *
     * The value of current node depends on its parent node, without knowing its parent node value, we still cannot determine current node value.
     * That's why we need recursion, we keep going previous row to find the parent node until reach the first row.
     * Then all the parent node value will be determined after the recursion function returns.
     *
     * source:
     * https://leetcode.com/problems/k-th-symbol-in-grammar/discuss/611833/Full-Explanation-for-Beginners
     * https://leetcode.com/problems/k-th-symbol-in-grammar/discuss/113697/my-3-lines-c-recursive-solution
     */
    public static int kthGrammarOptimized(int N, int K) {
        if (N == 1) return 0;

        if (K % 2 == 0) {
            if (kthGrammarOptimized(N - 1, K / 2) == 0) return 1;
            else return 0;
        } else {
            if (kthGrammarOptimized(N - 1, (K + 1) / 2) == 0) return 0;
            else return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(kthGrammar(1,1));
        System.out.println(kthGrammar(2,1));
        System.out.println(kthGrammar(2,2));
        System.out.println(kthGrammar(4,5));

        System.out.println(kthGrammarOptimized(1,1));
        System.out.println(kthGrammarOptimized(2,1));
        System.out.println(kthGrammarOptimized(2,2));
        System.out.println(kthGrammarOptimized(4,5));
    }
}
