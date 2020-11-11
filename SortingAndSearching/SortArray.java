package SortingAndSearching;

import utils.ArrayUtil;

import java.util.Arrays;

/**
 * Given an array of integers, sort the array in ascending order.
 *
 * Example 1:
 *
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 *
 * Example 2:
 *
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 */
public class SortArray {

    /**
     * Top-down merge sort
     */
    public static int[] sortArray(int[] nums) {
        if (nums.length <= 1) return nums;
        int midIdx = nums.length / 2;

        int[] leftArr = sortArray(Arrays.copyOfRange(nums, 0, midIdx));
        int[] rightArr = sortArray(Arrays.copyOfRange(nums, midIdx, nums.length));

        return merge(leftArr, rightArr);
    }

    private static int[] merge(int[] leftArr, int[] rightArr) {
        if (leftArr == null) return rightArr;
        if (rightArr == null) return leftArr;

        int[] mergedArr = new int[leftArr.length + rightArr.length];
        int mergedArrIdx = 0, leftArrIdx = 0, rightArrIdx = 0;
        while (leftArrIdx < leftArr.length && rightArrIdx < rightArr.length) {
            if (leftArr[leftArrIdx] <= rightArr[rightArrIdx]) mergedArr[mergedArrIdx++] = leftArr[leftArrIdx++];
            else mergedArr[mergedArrIdx++] = rightArr[rightArrIdx++];
        }

        while (leftArrIdx < leftArr.length) {
            mergedArr[mergedArrIdx++] = leftArr[leftArrIdx++];
        }

        while (rightArrIdx < rightArr.length) {
            mergedArr[mergedArrIdx++] = rightArr[rightArrIdx++];
        }

        return mergedArr;
    }

    public static void main(String[] args) {
        ArrayUtil.printIntArray(sortArray(new int[]{1,5,3,2,8,7,6,4}));
    }
}
