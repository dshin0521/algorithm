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
    public static int[] mergeSortTopDown(int[] nums) {
        if (nums.length <= 1) return nums;
        int midIdx = nums.length / 2;

        int[] leftArr = mergeSortTopDown(Arrays.copyOfRange(nums, 0, midIdx));
        int[] rightArr = mergeSortTopDown(Arrays.copyOfRange(nums, midIdx, nums.length));

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

    /**
     * Bottom-up merge sort
     */
    public static int[] mergeSortBottomUp(int[] nums) {
        if (nums.length <= 1) return nums;

        int[] numsCopy = Arrays.copyOf(nums, nums.length);

        // Divide the array into blocks of size i
        // i = [1, 2, 4, 8, 16 ...]
        for (int i = 1; i < nums.length; i *= 2) {

            // Start index of each block with size of i
            // i = 1, j = 0, 2, 4, 6, 8 ...
            // i = 2, j = 0, 4, 8, 12, 24 ...
            // i = 4, j = 0, 8, 16, 32, 64 ...
            for (int j = 0; j < nums.length; j += 2 * i) {
                int fromIdx = j;
                int midIdx = j + i - 1;
                int toIdx = Math.min(j + 2 * i - 1, nums.length - 1);
                mergeSortBottomUp(nums, numsCopy, fromIdx, midIdx, toIdx);
            }
        }
        return nums;
    }

    private static void mergeSortBottomUp(int[] originalArr, int[] copyArr, int fromIdx, int midIdx, int toIdx) {

        int i = fromIdx, j = midIdx + 1, k = fromIdx;

        // Loop till there are elements in both left and right blocks
        while (i <= midIdx && j <= toIdx) {
            if (originalArr[i] < originalArr[j]) copyArr[k++] = originalArr[i++];
            else copyArr[k++] = originalArr[j++];
        }

        // Copy remaining elements
        while (i < originalArr.length && i <= midIdx) copyArr[k++] = originalArr[i++];

        // Do not need to copy second half

        // Copy back to the original array to reflect sorted order
        for (i = fromIdx; i <= toIdx; i++) {
            originalArr[i] = copyArr[i];
        }
    }

    /**
     * Quick sort
     * https://www.youtube.com/watch?v=COk73cpQbFQ&t=895
     */
    public static int[] quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = partition(nums, l, r);
        quickSort(nums, l, mid - 1);
        quickSort(nums, mid + 1, r);
    }

    private static int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int partitionIdx = l;
        // at any stage, all the elements to the left of partition index will be lesser than the pivot
        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, partitionIdx);
                partitionIdx++;
            }
        }
        swap(nums, partitionIdx, r);
        return partitionIdx;
    }

    /**
     * Heap sort
     * https://www.youtube.com/watch?v=HqPJF2L5h9U
     */
    public static int[] heapSort(int[] nums) {
        buildMaxHeap(nums);
        removeAndFillElems(nums);
        return nums;
    }

    private static void buildMaxHeap(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            heapify(nums, nums.length - 1 - i, nums.length - 1);
            i++;
        }
    }

    private static void removeAndFillElems(int[] nums) {
        int i = nums.length - 1;
        while (i >= 1) {
            swap(nums,  0, i);
            heapify(nums, 0, i - 1);
            i--;
        }
    }

    private static void heapify(int[] nums, int i, int end) {
        // sift down for O(n) of buildHeap
        // https://stackoverflow.com/questions/9755721/how-can-building-a-heap-be-on-time-complexity
        while (i <= end) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int k;

            // 1. no child is available.
            // 2. only left child is available
            // 3. both left and right child are available
            if (l > end) break;
            else if (r > end) k = l;
            else k = nums[l] >= nums[r] ? l : r;

            if (nums[i] < nums[k]) swap(nums, i, k);
            i = k;
        }
    }

    /**
     * Selection sort
     */
    private static int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) minIdx = j;
            }
            swap(nums, i, minIdx);
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        ArrayUtil.printIntArray(mergeSortTopDown(new int[]{1,5,3,2,8,7,6,4}));
        ArrayUtil.printIntArray(mergeSortBottomUp(new int[]{5,3,2,8,7,6,4,1}));
        ArrayUtil.printIntArray(quickSort(new int[]{5,3,2,8,7,6,4,1}));
        ArrayUtil.printIntArray(heapSort(new int[]{5,3,2,8,7,6,4,1}));
        ArrayUtil.printIntArray(selectionSort(new int[]{5,3,2,8,7,6,4,1}));
    }
}
