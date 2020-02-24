package ArraysAndStrings;

import java.util.Arrays;

/**
 * Given an array nums of n integers where n > 1, return an array output such that
 * output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity?
 * (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {
  public static int[] productExceptSelf(int[] nums) {
    int[] productFromLeft = new int[nums.length];
    int[] productFromRight = new int[nums.length];

    productFromLeft[0] = 1;
    productFromRight[nums.length - 1] = 1;
    for (int i = 0 ; i < nums.length - 1; i++) {
      productFromLeft[i + 1] = productFromLeft[i] * nums[i];
      productFromRight[nums.length - 1 - 1 - i] =
          productFromRight[nums.length - 1 - i] * nums[nums.length - 1 - i];
    }

    int[] productExceptSelf = new int[nums.length];
    for (int i = 0; i < nums.length; i ++) {
      productExceptSelf[i] = productFromLeft[i] * productFromRight[i];
    }
    return productExceptSelf;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1,2,3,4};
    System.out.println(Arrays.toString(productExceptSelf(nums)));

    nums = new int[]{2,3,4,5};
    System.out.println(Arrays.toString(productExceptSelf(nums)));

  }
}
