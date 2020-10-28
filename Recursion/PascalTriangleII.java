package Recursion;

import utils.ListUtil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.
 * Notice that the row index starts from 0.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Follow up:
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * Example 1:
 *
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 *
 * Example 2:
 *
 * Input: rowIndex = 0
 * Output: [1]
 *
 * Example 3:
 *
 * Input: rowIndex = 1
 * Output: [1,1]
 *
 * Constraints:
 *
 * 0 <= rowIndex <= 40
 */
public class PascalTriangleII {

    public static Map<Integer, List<Integer>> map;
    static {
        map = new HashMap<>();
    }

    public static List<Integer> getRow(int rowIndex) {
        getRow(rowIndex, 0);
        return map.get(rowIndex);
    }

    private static void getRow(int rowIndex, int currRow) {
        if (rowIndex < currRow) return;

        if (!map.containsKey(currRow)) {
            List<Integer> row = new LinkedList<>();
            row.add(1);

            List<Integer> prevRow = map.getOrDefault(currRow - 1, new LinkedList<>());
            for (int i = 1; i < prevRow.size(); i++) {
                row.add(prevRow.get(i - 1) + prevRow.get(i));
            }

            if (currRow > 0) row.add(1);
            map.put(currRow, row);
        }

        getRow(rowIndex, ++currRow);
    }

    public static void main(String[] args) {
        ListUtil.printList(getRow(0));
        ListUtil.printList(getRow(1));
        ListUtil.printList(getRow(2));
        ListUtil.printList(getRow(3));
        ListUtil.printList(getRow(4));
        ListUtil.printList(getRow(5));
    }
}
