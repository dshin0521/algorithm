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

    public static void main(String[] args) {
        System.out.println(kthGrammar(1,1));
        System.out.println(kthGrammar(2,1));
        System.out.println(kthGrammar(2,2));
        System.out.println(kthGrammar(4,5));
    }
}
