package ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
	public static int[] searchRange(int[] nums, int target) {
		int firstIdx = findFirstOccurranceIndex(nums, target, 0, nums.length - 1);
		if (firstIdx == -1) return new int[]{-1, -1};
		int lastIdx = findLastOccurranceIndex(nums, target, 0, nums.length - 1);
		if (lastIdx == -1) return new int[]{-1, -1};

		return new int[]{firstIdx, lastIdx};
	}


	private static int findFirstOccurranceIndex(int[] nums, int target, int startIdx, int endIdx) {
		int firstIdx = -1;
		while (startIdx < endIdx) {
			int midIdx = (startIdx + endIdx)/2;
			if (nums[midIdx] < target) {
				startIdx = midIdx;
			}
			else if (nums[midIdx] >= target) {
				endIdx = midIdx;
			}

			if (nums[midIdx] == target) {
				firstIdx = midIdx;
			}
		}
		return firstIdx;
	}

	private static int findLastOccurranceIndex(int[] nums, int target, int startIdx, int endIdx) {
		int lastIdx = -1;
		while (startIdx < endIdx) {
			int midIdx = (startIdx + endIdx)/2;
			if (nums[midIdx] <= target) {
				startIdx = midIdx;
			}
			else if (nums[midIdx] > target) {
				endIdx = midIdx;
			}

			if (nums[midIdx] == target) {
				lastIdx = midIdx;
			}
		}
		return lastIdx;
	}
}
