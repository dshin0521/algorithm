package ArraysAndStrings;

import utils.ArrayUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                if (i == map.get(target - nums[i])) continue;
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] input1 = new int[]{2, 7, 11, 15};
        int target1 = 9;
        ArrayUtil.printIntArray(twoSum(input1, target1));
        int[] input2 = new int[]{3, 5, 1, 7};
        int target2 = 6;
        ArrayUtil.printIntArray(twoSum(input2, target2));
    }
}
