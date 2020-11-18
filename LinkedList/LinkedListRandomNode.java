package LinkedList;

import pojo.ListNode;
import java.util.Random;

/**
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 *
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 *
 * Example:
 *
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 *
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * solution.getRandom();
 */
public class LinkedListRandomNode {
    public static class Solution {

        ListNode head;
        Random r = new Random();

        public Solution(ListNode head) {
            this.head = head;
        }

        // https://florian.github.io/reservoir-sampling/
        // https://leetcode.com/problems/linked-list-random-node/discuss/85659/Brief-explanation-for-Reservoir-Sampling
        public int getRandom() {
            int result = this.head.val;
            ListNode node = this.head.next;
            int k = 1;
            int i = 1;
            while(node != null){
                double x = r.nextDouble();
                double y = (double) k / (k + i);
                // y is a probability of an element staying in reservoir
                // x is a probability whether it can stay in reservoir or not as an arbitrary element
                // if (x <= y), it means element cannot stay in reservoir so need to store result
                if(x <= y){
                    result = node.val;
                }
                i++;
                node = node.next;
            }
            return result;
        }
    }



    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(head);
     * int param_1 = obj.getRandom();
     */

    public static void main(String[] args) {
        ListNode testHead = new ListNode(1);
        testHead.next = new ListNode(2);
        testHead.next.next = new ListNode(3);
        Solution testSolution = new Solution(testHead);

        System.out.println(testSolution.getRandom());
    }
}
