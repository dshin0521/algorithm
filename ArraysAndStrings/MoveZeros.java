package ArraysAndStrings;

import java.util.Arrays;

/**
 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 Example:

 Input: [0,1,0,3,12]
 Output: [1,3,12,0,0]
 Note:

 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.
 */
public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        /* Write */
        /*
        if (nums == null || nums.length == 0) return;

        int idx = 0;
        for (int num : nums) {
            if (num != 0) nums[idx++] = num;
        }

        while (idx < nums.length) {
            nums[idx++] = 0;
        }
        */

        /* Swap */
        if (nums == null || nums.length == 0) return;

        int front = 0;
        int back = 1;

        while (back < nums.length) {
            if (nums[front] == 0) {
                /* Find first non-zero int. After swap, all numbers prior to b is non-zeros */
                while (back < nums.length - 1) {
                    if (nums[back] != 0) break;
                    back++;
                }
                nums[front] = nums[back];
                nums[back] = 0;
            }
            front++;
            back++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
