package SortingAndSearching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import utils.ListUtil;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
  public static class Pair {
    int key;
    int value;
    public Pair(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
  public static List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> numCount = new HashMap<>();
    for (int i : nums) {
      int count = numCount.getOrDefault(i, 0);
      numCount.put(i, ++count);
    }

    /*
      PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
        @Override
        public int compare(Pair p1, Pair p2) {
          return p2.value - p1.value;
        }
      });
    */
    PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.value - p1.value);

    for(Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
      Pair p = new Pair(entry.getKey(), entry.getValue());
      pq.add(p);
    }

    List<Integer> solution = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      if (pq.isEmpty()) break;
      Pair poppedPair = pq.poll();
      solution.add(poppedPair.key);
    }
    return solution;
  }

  public static void main(String[] args) {
    int[] testArr = new int[]{1,1,1,2,2,3};
    int testK = 2;

    List<Integer> answer = topKFrequent(testArr, testK);
    ListUtil.printList(answer);
  }
}
