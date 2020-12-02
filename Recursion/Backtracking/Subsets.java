package Recursion.Backtracking;


import utils.ListUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new LinkedList<>();
        List<Integer> subset = new LinkedList<>();
        subsetsHelper(subsets, subset, nums, 0);
        return subsets;
    }

    private static void subsetsHelper(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int startIdx) {
        subsets.add(new LinkedList<>(subset));
        for(int i = startIdx; i < nums.length; i++) {
            subset.add(nums[i]);
            subsetsHelper(subsets, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        for (List<Integer> subset : subsets) {
            ListUtil.printList(subset);
        }
    }
}
