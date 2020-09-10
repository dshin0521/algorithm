package ArraysAndStrings;

import java.util.Arrays;
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
		int firstIdx = findFirstOccurrenceIndex(nums, target);
		if (firstIdx == -1) return new int[]{-1, -1};
		int lastIdx = findLastOccurrenceIndex(nums, target);
		if (lastIdx == -1) return new int[]{-1, -1};

		return new int[]{firstIdx, lastIdx};
	}


	/**
	 * [ | |X| | ...
	 * 이렇게 긴 array 가 있다고 생각해보자. X의 인덱스에서 다다랐을때 mid 의 값이며, 고려할것은 딱 3가지.
	 * 1. target 보다 작다 => 이 경우 start = mid + 1
	 * 2. target 보다 크다 => 이 경우 end = mid - 1
	 * 3. target 과 같은 값 => mid 의 idx 저장, end = mid - 1 (그 이후것은 고려할 필요가 없다).
	 */
	private static int findFirstOccurrenceIndex(int[] nums, int target) {
		int startIdx = 0;
		int endIdx = nums.length - 1;
		int midIdx;
		int occurredIdx = -1;

		while (startIdx <= endIdx) {
			// midIdx = (startIdx + endIdx)/2; => can cause overflow
			midIdx = startIdx + (endIdx - startIdx)/2;

			if (nums[midIdx] < target) {
				startIdx = midIdx + 1;
			}
			else if (nums[midIdx] > target){
				endIdx = midIdx - 1;
			}
			else {
				occurredIdx = midIdx;
				endIdx = midIdx - 1;
			}
		}
		return occurredIdx;
	}

	/**
	 * ... | | |X| | ]
	 * 이렇게 긴 array 가 있다고 생각해보자. X의 인덱스에서 다다랐을때 mid 의 값이며, 고려할것은 딱 3가지.
	 * 1. target 보다 작다 => 이 경우 start = mid + 1
	 * 2. target 보다 크다 => 이 경우 end = mid - 1
	 * 3. target 과 같은 값 => mid 의 idx 저장, start = mid + 1 (그 전 것은 고려할 필요가 없다).
	 */
	private static int findLastOccurrenceIndex(int[] nums, int target) {
		int startIdx = 0;
		int endIdx = nums.length - 1;
		int midIdx;
		int occurredIdx = -1;

		while (startIdx <= endIdx) {
			midIdx = startIdx + (endIdx - startIdx)/2;
			if (nums[midIdx] < target) {
				startIdx = midIdx + 1;
			} else if (nums[midIdx] > target) {
				endIdx = midIdx - 1;
			} else {
				occurredIdx = midIdx;
				startIdx = midIdx + 1;
			}
		}
		return occurredIdx;
	}

	public static int[] searchRangeRecursively(int[] nums, int target) {
		int[] range = new int[]{nums.length, -1};
		recursivelyFindIndices(nums, target, 0, nums.length - 1, range);
		return range;
	}
	private static void recursivelyFindIndices(int[] nums, int target, int startIdx, int endIdx, int[] range) {
		if (startIdx > endIdx || startIdx < 0 || endIdx > nums.length - 1) return;

		int midIdx = startIdx + (endIdx - startIdx)/2;
		if (nums[midIdx] < target) {
			recursivelyFindIndices(nums, target, midIdx + 1, endIdx, range);
		} else if (nums[midIdx] > target) {
			recursivelyFindIndices(nums, target, startIdx, midIdx - 1, range);
		} else {
			if (range[0] > midIdx) {
				range[0] = midIdx;
				recursivelyFindIndices(nums, target, startIdx, midIdx - 1, range);
			}
			if (range[1] < midIdx) {
				range[1] = midIdx;
				recursivelyFindIndices(nums, target, midIdx + 1, endIdx, range);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
		System.out.println(Arrays.toString(searchRangeRecursively(new int[]{5, 7, 7, 8, 8, 10}, 8)));
	}
}
