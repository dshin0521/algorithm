package Recursion;


import utils.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new LinkedList<>();
        List<Integer> subset = new LinkedList<>();
        subsetsHelper(subsets, subset, nums, 0);
        return subsets;
    }

    private static void subsetsHelper(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int startIdx) {
        System.out.println("subsetsHelper started with startIdx = " + startIdx);
        subsets.add(new LinkedList<>(subset));
        System.out.print("subsets : ");
        ListUtil.printListOfList(subsets);
        for(int i = startIdx; i < nums.length; i++) {
            System.out.println("loop starts with i = " + i + ", startIdx = "  + startIdx);
            subset.add(nums[i]);
            System.out.print("subset : ");
            ListUtil.printList(subset);
            System.out.println("subsetHelper getting called\n");
            subsetsHelper(subsets, subset, nums, i + 1);
            System.out.println("subsetHelper exited with i = " + i + ", startIdx = " + startIdx);
            subset.remove(subset.size() - 1);
            System.out.println("removed element");
            System.out.print("subset : ");
            ListUtil.printList(subset);
        }
        System.out.println("subsetHelper execution completed with startIdx = " + startIdx);
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println("answer : ");
        for (List<Integer> subset : subsets) {
            ListUtil.printList(subset);
        }
    }
}
