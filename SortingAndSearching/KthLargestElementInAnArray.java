package SortingAndSearching;

import java.util.PriorityQueue;

/**
 Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 Example 1:

 Input: [3,2,1,5,6,4] and k = 2
 Output: 5
 Example 2:

 Input: [3,2,3,1,2,4,5,5,6] and k = 4
 Output: 4

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInAnArray {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.print(findKthLargest(nums, k));
        /*
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int num : nums) {
            pq.offer(num);
            System.out.println("num : " + num);
            Object[] objArr = pq.toArray();
            Arrays.sort(objArr);
            Stream<Object> stream = Arrays.stream(objArr);
            stream.forEach(s -> System.out.print(s + " "));
            System.out.println();
            System.out.println("peak : " + pq.peek());
        }
        System.out.println("-----------------------");

        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        for (int num: nums) {
            pq2.offer(num);
            int polledNum = 0;
            if (pq2.size() > k) polledNum = pq2.poll();
            System.out.println("num : " + num);
            System.out.println("polled num : " + polledNum);
            Object[] objArr = pq2.toArray();
            Arrays.sort(objArr);
            Stream<Object> stream = Arrays.stream(objArr);
            stream.forEach(s -> System.out.print(s + " "));
            System.out.println();
        }
        */
    }
}
