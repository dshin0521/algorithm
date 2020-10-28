package Recursion;

import utils.ListUtil;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new LinkedList<>();
        generate(list, numRows, 0);
        return list;
    }

    private static void generate(List<List<Integer>> list, int numRows, int currRows) {
        if (numRows == 0 || numRows <= currRows) return;

        List<Integer> sublist = new LinkedList<>();
        sublist.add(1);

        if (currRows > 0) {
            List<Integer> prevRow = list.get(currRows - 1);
            for (int i = 1; i < prevRow.size(); i++) {
                sublist.add(prevRow.get(i - 1) + prevRow.get(i));
            }
        }

        if (currRows > 0) sublist.add(1);
        list.add(sublist);

        generate(list, numRows, ++currRows);
    }

    public static void main(String[] args) {
        ListUtil.printList(generate(1));
        ListUtil.printList(generate(2));
        ListUtil.printList(generate(3));
        ListUtil.printList(generate(4));
        ListUtil.printList(generate(5));
    }
}
